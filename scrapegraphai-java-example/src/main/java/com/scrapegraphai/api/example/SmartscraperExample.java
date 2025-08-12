package com.scrapegraphai.api.example;

import com.scrapegraphai.api.client.ScrapegraphaiClient;
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClient;
import com.scrapegraphai.api.models.smartscraper.CompletedSmartscraper;
import com.scrapegraphai.api.models.smartscraper.SmartscraperCreateParams;
import com.scrapegraphai.api.models.smartscraper.SmartscraperRetrieveResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Comprehensive examples demonstrating various SmartScraper capabilities:
 * - Basic web scraping with custom prompts
 * - Structured data extraction with output schemas
 * - Handling dynamic content with JavaScript rendering
 * - Working with pagination and infinite scroll
 * - Custom headers and cookies
 * 
 * Run with: ./gradlew :scrapegraphai-java-example:run -Pexample=Smartscraper
 */
public class SmartscraperExample {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    public static void main(String[] args) {
        System.out.println("🕷️ ScrapeGraphAI Java SDK - SmartScraper Examples");
        System.out.println("==================================================");
        
        ScrapegraphaiClient client = ScrapegraphaiOkHttpClient.fromEnv();
        
        // Example 1: Basic product information extraction
        basicProductExtraction(client);
        
        // Example 2: Structured data extraction with custom schema
        structuredDataExtraction(client);
        
        // Example 3: Handling dynamic content with JavaScript
        dynamicContentScraping(client);
        
        // Example 4: Working with pagination
        paginationExample(client);
        
        // Example 5: Using custom headers and cookies
        customHeadersAndCookies(client);
        
        // Example 6: Retrieving scraping results by request ID
        retrieveScrapingResults(client);
    }
    
    /**
     * Example 1: Basic product information extraction from an e-commerce site
     */
    private static void basicProductExtraction(ScrapegraphaiClient client) {
        System.out.println("\n📦 Example 1: Basic Product Information Extraction");
        System.out.println("--------------------------------------------------");
        
        try {
            SmartscraperCreateParams params = SmartscraperCreateParams.builder()
                .userPrompt("Extract the product name, price, description, and availability status")
                .websiteUrl("https://books.toscrape.com/catalogue/a-light-in-the-attic_1000/index.html")
                .build();
            
            System.out.println("🚀 Extracting product information...");
            CompletedSmartscraper result = client.smartscraper().create(params);
            
            System.out.println("✅ Product information extracted:");
            System.out.println(formatJson(result.result()));
            
        } catch (Exception e) {
            System.err.println("❌ Error in basic product extraction: " + e.getMessage());
        }
    }
    
    /**
     * Example 2: Structured data extraction with a custom JSON schema
     */
    private static void structuredDataExtraction(ScrapegraphaiClient client) {
        System.out.println("\n🏗️ Example 2: Structured Data Extraction with Custom Schema");
        System.out.println("------------------------------------------------------------");
        
        try {
            // Define a custom output schema
            String outputSchema = """
                {
                    "type": "object",
                    "properties": {
                        "title": {"type": "string"},
                        "price": {"type": "number"},
                        "currency": {"type": "string"},
                        "in_stock": {"type": "boolean"},
                        "rating": {"type": "integer", "minimum": 1, "maximum": 5},
                        "description": {"type": "string"},
                        "categories": {
                            "type": "array",
                            "items": {"type": "string"}
                        }
                    },
                    "required": ["title", "price"]
                }
                """;
            
            SmartscraperCreateParams params = SmartscraperCreateParams.builder()
                .userPrompt("Extract book information according to the provided schema")
                .websiteUrl("https://books.toscrape.com/catalogue/a-light-in-the-attic_1000/index.html")
                .outputSchema(objectMapper.readTree(outputSchema))
                .build();
            
            System.out.println("🚀 Extracting data with custom schema...");
            CompletedSmartscraper result = client.smartscraper().create(params);
            
            System.out.println("✅ Structured data extracted:");
            System.out.println(formatJson(result.result()));
            
        } catch (Exception e) {
            System.err.println("❌ Error in structured data extraction: " + e.getMessage());
        }
    }
    
    /**
     * Example 3: Handling dynamic content that requires JavaScript rendering
     */
    private static void dynamicContentScraping(ScrapegraphaiClient client) {
        System.out.println("\n⚡ Example 3: Dynamic Content Scraping with JavaScript");
        System.out.println("-----------------------------------------------------");
        
        try {
            SmartscraperCreateParams params = SmartscraperCreateParams.builder()
                .userPrompt("Extract all the dynamically loaded content, including any data that appears after page load")
                .websiteUrl("https://quotes.toscrape.com/js/")
                .renderHeavyJs(true) // Enable JavaScript rendering
                .build();
            
            System.out.println("🚀 Scraping dynamic content with JavaScript rendering...");
            CompletedSmartscraper result = client.smartscraper().create(params);
            
            System.out.println("✅ Dynamic content extracted:");
            System.out.println(formatJson(result.result()));
            
        } catch (Exception e) {
            System.err.println("❌ Error in dynamic content scraping: " + e.getMessage());
        }
    }
    
    /**
     * Example 4: Working with pagination to scrape multiple pages
     */
    private static void paginationExample(ScrapegraphaiClient client) {
        System.out.println("\n📄 Example 4: Pagination Example");
        System.out.println("--------------------------------");
        
        try {
            SmartscraperCreateParams params = SmartscraperCreateParams.builder()
                .userPrompt("Extract all book titles and prices from this page and the next 2 pages")
                .websiteUrl("https://books.toscrape.com/")
                .totalPages(3L) // Scrape 3 pages total
                .build();
            
            System.out.println("🚀 Scraping multiple pages...");
            CompletedSmartscraper result = client.smartscraper().create(params);
            
            System.out.println("✅ Multi-page data extracted:");
            System.out.println(formatJson(result.result()));
            
        } catch (Exception e) {
            System.err.println("❌ Error in pagination example: " + e.getMessage());
        }
    }
    
    /**
     * Example 5: Using custom headers and cookies for authenticated scraping
     */
    private static void customHeadersAndCookies(ScrapegraphaiClient client) {
        System.out.println("\n🔐 Example 5: Custom Headers and Cookies");
        System.out.println("----------------------------------------");
        
        try {
            // Create custom headers
            SmartscraperCreateParams.Headers customHeaders = SmartscraperCreateParams.Headers.builder()
                .putAdditionalProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7)")
                .putAdditionalProperty("Accept-Language", "en-US,en;q=0.9")
                .build();
            
            // Create cookies
            SmartscraperCreateParams.Cookies cookies = SmartscraperCreateParams.Cookies.builder()
                .putAdditionalProperty("session_id", "example_session_123")
                .putAdditionalProperty("preferences", "theme=dark")
                .build();
            
            SmartscraperCreateParams params = SmartscraperCreateParams.builder()
                .userPrompt("Extract the main content, respecting any personalization or session-specific data")
                .websiteUrl("https://httpbin.org/headers")
                .headers(customHeaders)
                .cookies(cookies)
                .build();
            
            System.out.println("🚀 Scraping with custom headers and cookies...");
            CompletedSmartscraper result = client.smartscraper().create(params);
            
            System.out.println("✅ Data extracted with custom headers:");
            System.out.println(formatJson(result.result()));
            
        } catch (Exception e) {
            System.err.println("❌ Error with custom headers and cookies: " + e.getMessage());
        }
    }
    
    /**
     * Example 6: Retrieving scraping results using a request ID
     * (This would be used when you have a request ID from a previous operation)
     */
    private static void retrieveScrapingResults(ScrapegraphaiClient client) {
        System.out.println("\n🔍 Example 6: Retrieving Results by Request ID");
        System.out.println("----------------------------------------------");
        
        try {
            // First, create a scraping request to get a request ID
            SmartscraperCreateParams params = SmartscraperCreateParams.builder()
                .userPrompt("Extract the page title and main content")
                .websiteUrl("https://example.com")
                .build();
            
            System.out.println("🚀 Creating initial scraping request...");
            CompletedSmartscraper initialResult = client.smartscraper().create(params);
            
            // In a real scenario, you might store this request ID and retrieve it later
            String requestId = initialResult.requestId();
            System.out.println("📋 Request ID: " + requestId);
            
            // Now retrieve the results using the request ID
            System.out.println("🔄 Retrieving results by request ID...");
            SmartscraperRetrieveResponse retrievedResult = client.smartscraper().retrieve(requestId);
            
            System.out.println("✅ Retrieved results:");
            System.out.println("Status: " + retrievedResult.status());
            if (retrievedResult.result() != null) {
                System.out.println("Data: " + formatJson(retrievedResult.result()));
            }
            
        } catch (Exception e) {
            System.err.println("❌ Error retrieving results: " + e.getMessage());
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
