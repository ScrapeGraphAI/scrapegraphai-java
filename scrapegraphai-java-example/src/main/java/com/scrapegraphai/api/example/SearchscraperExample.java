package com.scrapegraphai.api.example;

import com.scrapegraphai.api.client.ScrapegraphaiClient;
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClient;
import com.scrapegraphai.api.models.searchscraper.CompletedSearchScraper;
import com.scrapegraphai.api.models.searchscraper.SearchscraperCreateParams;
import com.scrapegraphai.api.models.searchscraper.SearchscraperRetrieveStatusResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Examples demonstrating SearchScraper functionality:
 * - Performing web searches and extracting data from multiple sources
 * - Using different search engines and providers
 * - Handling search result aggregation and filtering
 * - Monitoring search scraping progress
 * 
 * SearchScraper combines web search with intelligent content extraction,
 * allowing you to find and scrape relevant information from multiple websites
 * based on search queries.
 * 
 * Run with: ./gradlew :scrapegraphai-java-example:run -Pexample=Searchscraper
 */
public class SearchscraperExample {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    public static void main(String[] args) {
        System.out.println("🔍 ScrapeGraphAI Java SDK - SearchScraper Examples");
        System.out.println("===================================================");
        
        ScrapegraphaiClient client = ScrapegraphaiOkHttpClient.fromEnv();
        
        // Example 1: Basic search and scrape
        basicSearchAndScrape(client);
        
        // Example 2: Product comparison across multiple sites
        productComparison(client);
        
        // Example 3: News aggregation
        newsAggregation(client);
        
        // Example 4: Academic research
        academicResearch(client);
        
        // Example 5: Monitoring search scraping status
        monitorSearchProgress(client);
    }
    
    /**
     * Example 1: Basic search and scrape for general information
     */
    private static void basicSearchAndScrape(ScrapegraphaiClient client) {
        System.out.println("\n🔍 Example 1: Basic Search and Scrape");
        System.out.println("------------------------------------");
        
        try {
            SearchscraperCreateParams params = SearchscraperCreateParams.builder()
                .userPrompt("Find information about the latest developments in artificial intelligence and machine learning")
                .query("latest AI machine learning developments 2024")
                .maxResults(5L)
                .build();
            
            System.out.println("🚀 Searching and scraping AI/ML information...");
            System.out.println("Search Query: latest AI machine learning developments 2024");
            System.out.println("Max Results: 5");
            
            CompletedSearchScraper result = client.searchscraper().create(params);
            
            System.out.println("✅ Search and scrape completed!");
            System.out.println("📊 Aggregated Results:");
            System.out.println(formatJson(result.result()));
            
        } catch (Exception e) {
            System.err.println("❌ Error in basic search and scrape: " + e.getMessage());
        }
    }
    
    /**
     * Example 2: Product comparison across multiple e-commerce sites
     */
    private static void productComparison(ScrapegraphaiClient client) {
        System.out.println("\n🛒 Example 2: Product Comparison");
        System.out.println("-------------------------------");
        
        try {
            SearchscraperCreateParams params = SearchscraperCreateParams.builder()
                .userPrompt("Compare prices, features, and reviews for wireless headphones. Extract product name, price, rating, and key features from each source.")
                .query("best wireless headphones 2024 reviews comparison")
                .maxResults(8L)
                .build();
            
            System.out.println("🚀 Comparing wireless headphones across multiple sites...");
            System.out.println("Search Query: best wireless headphones 2024 reviews comparison");
            System.out.println("Max Results: 8");
            
            CompletedSearchScraper result = client.searchscraper().create(params);
            
            System.out.println("✅ Product comparison completed!");
            System.out.println("📊 Comparison Results:");
            System.out.println(formatJson(result.result()));
            
        } catch (Exception e) {
            System.err.println("❌ Error in product comparison: " + e.getMessage());
        }
    }
    
    /**
     * Example 3: News aggregation from multiple sources
     */
    private static void newsAggregation(ScrapegraphaiClient client) {
        System.out.println("\n📰 Example 3: News Aggregation");
        System.out.println("-----------------------------");
        
        try {
            SearchscraperCreateParams params = SearchscraperCreateParams.builder()
                .userPrompt("Aggregate recent news about renewable energy developments. Extract headline, summary, publication date, and source for each article.")
                .query("renewable energy news solar wind power 2024")
                .maxResults(6L)
                .build();
            
            System.out.println("🚀 Aggregating renewable energy news...");
            System.out.println("Search Query: renewable energy news solar wind power 2024");
            System.out.println("Max Results: 6");
            
            CompletedSearchScraper result = client.searchscraper().create(params);
            
            System.out.println("✅ News aggregation completed!");
            System.out.println("📊 News Summary:");
            System.out.println(formatJson(result.result()));
            
        } catch (Exception e) {
            System.err.println("❌ Error in news aggregation: " + e.getMessage());
        }
    }
    
    /**
     * Example 4: Academic research data collection
     */
    private static void academicResearch(ScrapegraphaiClient client) {
        System.out.println("\n🎓 Example 4: Academic Research");
        System.out.println("------------------------------");
        
        try {
            SearchscraperCreateParams params = SearchscraperCreateParams.builder()
                .userPrompt("Find academic papers and research about quantum computing applications. Extract paper title, authors, abstract, publication venue, and year.")
                .query("quantum computing applications research papers 2023 2024")
                .maxResults(10L)
                .build();
            
            System.out.println("🚀 Collecting quantum computing research...");
            System.out.println("Search Query: quantum computing applications research papers 2023 2024");
            System.out.println("Max Results: 10");
            
            CompletedSearchScraper result = client.searchscraper().create(params);
            
            System.out.println("✅ Research collection completed!");
            System.out.println("📊 Academic Papers Found:");
            System.out.println(formatJson(result.result()));
            
        } catch (Exception e) {
            System.err.println("❌ Error in academic research: " + e.getMessage());
        }
    }
    
    /**
     * Example 5: Monitoring search scraping progress
     * This demonstrates how to check the status of a long-running search operation
     */
    private static void monitorSearchProgress(ScrapegraphaiClient client) {
        System.out.println("\n⏱️ Example 5: Monitoring Search Progress");
        System.out.println("---------------------------------------");
        
        try {
            // Start a search operation
            SearchscraperCreateParams params = SearchscraperCreateParams.builder()
                .userPrompt("Find comprehensive information about sustainable technology trends")
                .query("sustainable technology trends green tech innovation")
                .maxResults(12L)
                .build();
            
            System.out.println("🚀 Starting comprehensive search operation...");
            CompletedSearchScraper result = client.searchscraper().create(params);
            
            // Get the request ID for status monitoring
            String requestId = result.requestId();
            System.out.println("📋 Request ID: " + requestId);
            
            // In a real scenario, you might want to check status periodically
            // Here we'll just demonstrate how to retrieve the status
            System.out.println("🔄 Checking search status...");
            SearchscraperRetrieveStatusResponse status = client.searchscraper().retrieveStatus(requestId);
            
            System.out.println("✅ Search Status Retrieved:");
            System.out.println("Status: " + status.status());
            if (status.result() != null) {
                System.out.println("📊 Results Available:");
                System.out.println(formatJson(status.result()));
            }
            
            // Additional status information
            if (status.error() != null) {
                System.out.println("⚠️ Error Details: " + status.error());
            }
            
            if (status.requestId() != null) {
                System.out.println("🔗 Request ID: " + status.requestId());
            }
            
        } catch (Exception e) {
            System.err.println("❌ Error monitoring search progress: " + e.getMessage());
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
