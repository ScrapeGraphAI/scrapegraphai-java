package com.scrapegraphai.api.example;

import com.scrapegraphai.api.client.ScrapegraphaiClient;
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClient;
import com.scrapegraphai.api.models.crawl.CrawlStartParams;
import com.scrapegraphai.api.models.crawl.CrawlStartResponse;
import com.scrapegraphai.api.models.crawl.CrawlRetrieveResultsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Examples demonstrating website crawling functionality:
 * - Starting crawl operations for entire websites or specific sections
 * - Configuring crawl parameters like depth, filters, and limits
 * - Monitoring crawl progress and retrieving results
 * - Handling large-scale data extraction from multiple pages
 * 
 * The Crawl service allows you to systematically explore and extract data
 * from entire websites or specific sections, following links and navigating
 * through site structures automatically.
 * 
 * Run with: ./gradlew :scrapegraphai-java-example:run -Pexample=Crawl
 */
public class CrawlExample {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    public static void main(String[] args) {
        System.out.println("🕸️ ScrapeGraphAI Java SDK - Crawl Examples");
        System.out.println("===========================================");
        
        ScrapegraphaiClient client = ScrapegraphaiOkHttpClient.fromEnv();
        
        // Example 1: Basic website crawling
        basicWebsiteCrawl(client);
        
        // Example 2: E-commerce catalog crawling
        ecommerceCatalogCrawl(client);
        
        // Example 3: Blog/News site crawling
        blogNewsCrawl(client);
        
        // Example 4: Documentation site crawling
        documentationCrawl(client);
        
        // Example 5: Monitoring crawl progress and retrieving results
        monitorCrawlProgress(client);
    }
    
    /**
     * Example 1: Basic website crawling with standard parameters
     */
    private static void basicWebsiteCrawl(ScrapegraphaiClient client) {
        System.out.println("\n🕸️ Example 1: Basic Website Crawl");
        System.out.println("---------------------------------");
        
        try {
            CrawlStartParams params = CrawlStartParams.builder()
                .userPrompt("Extract the main content, headings, and links from each page")
                .websiteUrl("https://quotes.toscrape.com")
                .maxDepth(2L)
                .maxPages(10L)
                .build();
            
            System.out.println("🚀 Starting basic website crawl...");
            System.out.println("Target URL: https://quotes.toscrape.com");
            System.out.println("Max Depth: 2");
            System.out.println("Max Pages: 10");
            
            CrawlStartResponse result = client.crawl().start(params);
            
            System.out.println("✅ Crawl started successfully!");
            System.out.println("📋 Crawl ID: " + result.crawlId());
            System.out.println("📊 Initial Status: " + result.status());
            
            if (result.message() != null) {
                System.out.println("💬 Message: " + result.message());
            }
            
        } catch (Exception e) {
            System.err.println("❌ Error in basic website crawl: " + e.getMessage());
        }
    }
    
    /**
     * Example 2: E-commerce catalog crawling with product-specific extraction
     */
    private static void ecommerceCatalogCrawl(ScrapegraphaiClient client) {
        System.out.println("\n🛍️ Example 2: E-commerce Catalog Crawl");
        System.out.println("--------------------------------------");
        
        try {
            CrawlStartParams params = CrawlStartParams.builder()
                .userPrompt("Extract product information including name, price, description, availability, and images from each product page")
                .websiteUrl("https://books.toscrape.com")
                .maxDepth(3L)
                .maxPages(50L)
                .excludePaths(java.util.List.of("/contact", "/about", "/terms"))
                .includePaths(java.util.List.of("/catalogue"))
                .build();
            
            System.out.println("🚀 Starting e-commerce catalog crawl...");
            System.out.println("Target URL: https://books.toscrape.com");
            System.out.println("Max Depth: 3");
            System.out.println("Max Pages: 50");
            System.out.println("Include Paths: /catalogue");
            System.out.println("Exclude Paths: /contact, /about, /terms");
            
            CrawlStartResponse result = client.crawl().start(params);
            
            System.out.println("✅ E-commerce crawl started!");
            System.out.println("📋 Crawl ID: " + result.crawlId());
            System.out.println("📊 Status: " + result.status());
            
        } catch (Exception e) {
            System.err.println("❌ Error in e-commerce catalog crawl: " + e.getMessage());
        }
    }
    
    /**
     * Example 3: Blog/News site crawling for article content
     */
    private static void blogNewsCrawl(ScrapegraphaiClient client) {
        System.out.println("\n📰 Example 3: Blog/News Site Crawl");
        System.out.println("----------------------------------");
        
        try {
            CrawlStartParams params = CrawlStartParams.builder()
                .userPrompt("Extract article titles, authors, publication dates, content, and tags from blog posts and news articles")
                .websiteUrl("https://blog.scrapegraphai.com")
                .maxDepth(2L)
                .maxPages(25L)
                .includePaths(java.util.List.of("/post", "/article", "/blog"))
                .excludePaths(java.util.List.of("/admin", "/login", "/register"))
                .build();
            
            System.out.println("🚀 Starting blog/news crawl...");
            System.out.println("Target URL: https://blog.scrapegraphai.com");
            System.out.println("Max Depth: 2");
            System.out.println("Max Pages: 25");
            System.out.println("Include Paths: /post, /article, /blog");
            System.out.println("Exclude Paths: /admin, /login, /register");
            
            CrawlStartResponse result = client.crawl().start(params);
            
            System.out.println("✅ Blog crawl started!");
            System.out.println("📋 Crawl ID: " + result.crawlId());
            System.out.println("📊 Status: " + result.status());
            
        } catch (Exception e) {
            System.err.println("❌ Error in blog/news crawl: " + e.getMessage());
        }
    }
    
    /**
     * Example 4: Documentation site crawling for structured content
     */
    private static void documentationCrawl(ScrapegraphaiClient client) {
        System.out.println("\n📚 Example 4: Documentation Site Crawl");
        System.out.println("--------------------------------------");
        
        try {
            CrawlStartParams params = CrawlStartParams.builder()
                .userPrompt("Extract documentation content including section titles, code examples, descriptions, and navigation structure")
                .websiteUrl("https://docs.scrapegraphai.com")
                .maxDepth(4L)
                .maxPages(100L)
                .includePaths(java.util.List.of("/docs", "/api", "/guides", "/tutorials"))
                .excludePaths(java.util.List.of("/search", "/feedback"))
                .build();
            
            System.out.println("🚀 Starting documentation crawl...");
            System.out.println("Target URL: https://docs.scrapegraphai.com");
            System.out.println("Max Depth: 4");
            System.out.println("Max Pages: 100");
            System.out.println("Include Paths: /docs, /api, /guides, /tutorials");
            System.out.println("Exclude Paths: /search, /feedback");
            
            CrawlStartResponse result = client.crawl().start(params);
            
            System.out.println("✅ Documentation crawl started!");
            System.out.println("📋 Crawl ID: " + result.crawlId());
            System.out.println("📊 Status: " + result.status());
            
        } catch (Exception e) {
            System.err.println("❌ Error in documentation crawl: " + e.getMessage());
        }
    }
    
    /**
     * Example 5: Monitoring crawl progress and retrieving results
     */
    private static void monitorCrawlProgress(ScrapegraphaiClient client) {
        System.out.println("\n⏱️ Example 5: Monitoring Crawl Progress");
        System.out.println("--------------------------------------");
        
        try {
            // Start a crawl operation
            CrawlStartParams params = CrawlStartParams.builder()
                .userPrompt("Extract page titles and main content")
                .websiteUrl("https://example.com")
                .maxDepth(1L)
                .maxPages(5L)
                .build();
            
            System.out.println("🚀 Starting crawl for monitoring...");
            CrawlStartResponse startResult = client.crawl().start(params);
            
            String crawlId = startResult.crawlId();
            System.out.println("📋 Crawl ID: " + crawlId);
            System.out.println("📊 Initial Status: " + startResult.status());
            
            // Wait a moment and then check results
            System.out.println("⏳ Waiting for crawl to process...");
            
            try {
                Thread.sleep(5000); // Wait 5 seconds (in real usage, you might poll periodically)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            // Retrieve crawl results
            System.out.println("🔄 Retrieving crawl results...");
            CrawlRetrieveResultsResponse results = client.crawl().retrieveResults(crawlId);
            
            System.out.println("✅ Crawl Results Retrieved:");
            System.out.println("📊 Status: " + results.status());
            
            if (results.results() != null && !results.results().isEmpty()) {
                System.out.println("📄 Pages Crawled: " + results.results().size());
                System.out.println("📋 Sample Results:");
                
                // Show first few results
                results.results().stream()
                    .limit(3)
                    .forEach(result -> {
                        System.out.println("  🔗 URL: " + result.url());
                        if (result.data() != null) {
                            System.out.println("  📝 Data: " + formatJson(result.data()));
                        }
                        System.out.println("  ---");
                    });
            } else {
                System.out.println("📭 No results available yet");
            }
            
            if (results.error() != null) {
                System.out.println("⚠️ Error: " + results.error());
            }
            
            if (results.totalPages() != null) {
                System.out.println("📊 Total Pages Found: " + results.totalPages());
            }
            
        } catch (Exception e) {
            System.err.println("❌ Error monitoring crawl progress: " + e.getMessage());
        }
    }
    
    /**
     * Helper method to format JSON output for better readability
     */
    private static String formatJson(Object obj) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            return obj.toString();
        }
    }
}
