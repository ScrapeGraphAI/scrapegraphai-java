package com.scrapegraphai.api.example;

import com.scrapegraphai.api.client.ScrapegraphaiClient;
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClient;
import com.scrapegraphai.api.models.generateschema.GenerateSchemaCreateParams;
import com.scrapegraphai.api.models.generateschema.GenerateSchemaCreateResponse;
import com.scrapegraphai.api.models.generateschema.GenerateSchemaRetrieveResponse;
import com.scrapegraphai.api.models.smartscraper.SmartscraperCreateParams;
import com.scrapegraphai.api.models.smartscraper.CompletedSmartscraper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Examples demonstrating Schema Generation functionality:
 * - Automatically generating JSON schemas from website content
 * - Using generated schemas for structured data extraction
 * - Handling different types of content and data structures
 * - Combining schema generation with smartscraper operations
 * - Monitoring schema generation progress
 * 
 * Schema Generation analyzes website content and creates appropriate
 * JSON schemas that can be used for consistent, structured data extraction.
 * 
 * Run with: ./gradlew :scrapegraphai-java-example:run -Pexample=SchemaGeneration
 */
public class SchemaGenerationExample {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    public static void main(String[] args) {
        System.out.println("🏗️ ScrapeGraphAI Java SDK - Schema Generation Examples");
        System.out.println("=======================================================");
        
        ScrapegraphaiClient client = ScrapegraphaiOkHttpClient.fromEnv();
        
        // Example 1: Basic schema generation from e-commerce page
        basicSchemaGeneration(client);
        
        // Example 2: Schema generation for blog/news content
        blogContentSchemaGeneration(client);
        
        // Example 3: Schema generation for product listings
        productListingSchemaGeneration(client);
        
        // Example 4: Using generated schema with SmartScraper
        useGeneratedSchemaWithScraper(client);
        
        // Example 5: Monitoring schema generation progress
        monitorSchemaGeneration(client);
    }
    
    /**
     * Example 1: Basic schema generation from e-commerce page
     */
    private static void basicSchemaGeneration(ScrapegraphaiClient client) {
        System.out.println("\n🛍️ Example 1: E-commerce Schema Generation");
        System.out.println("------------------------------------------");
        
        try {
            GenerateSchemaCreateParams params = GenerateSchemaCreateParams.builder()
                .websiteUrl("https://books.toscrape.com/catalogue/a-light-in-the-attic_1000/index.html")
                .build();
            
            System.out.println("🚀 Generating schema for e-commerce product page...");
            System.out.println("Target URL: https://books.toscrape.com/catalogue/a-light-in-the-attic_1000/index.html");
            
            GenerateSchemaCreateResponse result = client.generateSchema().create(params);
            
            System.out.println("✅ Schema generation completed!");
            System.out.println("📋 Request ID: " + result.requestId());
            System.out.println("🏗️ Generated Schema:");
            System.out.println("===================");
            System.out.println(formatJson(result.result()));
            
            // Show how this schema can be used
            System.out.println("\n💡 Usage: This schema can now be used with SmartScraper for consistent data extraction");
            
        } catch (Exception e) {
            System.err.println("❌ Error in basic schema generation: " + e.getMessage());
        }
    }
    
    /**
     * Example 2: Schema generation for blog/news content
     */
    private static void blogContentSchemaGeneration(ScrapegraphaiClient client) {
        System.out.println("\n📰 Example 2: Blog Content Schema Generation");
        System.out.println("-------------------------------------------");
        
        try {
            GenerateSchemaCreateParams params = GenerateSchemaCreateParams.builder()
                .websiteUrl("https://blog.scrapegraphai.com/latest-post")
                .build();
            
            System.out.println("🚀 Generating schema for blog content...");
            System.out.println("Target URL: https://blog.scrapegraphai.com/latest-post");
            
            GenerateSchemaCreateResponse result = client.generateSchema().create(params);
            
            System.out.println("✅ Blog schema generation completed!");
            System.out.println("📋 Request ID: " + result.requestId());
            System.out.println("🏗️ Generated Blog Schema:");
            System.out.println("========================");
            System.out.println(formatJson(result.result()));
            
            System.out.println("\n💡 This schema captures typical blog elements like title, author, date, content, and tags");
            
        } catch (Exception e) {
            System.err.println("❌ Error in blog content schema generation: " + e.getMessage());
        }
    }
    
    /**
     * Example 3: Schema generation for product listings
     */
    private static void productListingSchemaGeneration(ScrapegraphaiClient client) {
        System.out.println("\n📋 Example 3: Product Listing Schema Generation");
        System.out.println("-----------------------------------------------");
        
        try {
            GenerateSchemaCreateParams params = GenerateSchemaCreateParams.builder()
                .websiteUrl("https://books.toscrape.com/")
                .build();
            
            System.out.println("🚀 Generating schema for product listing page...");
            System.out.println("Target URL: https://books.toscrape.com/");
            
            GenerateSchemaCreateResponse result = client.generateSchema().create(params);
            
            System.out.println("✅ Product listing schema generation completed!");
            System.out.println("📋 Request ID: " + result.requestId());
            System.out.println("🏗️ Generated Listing Schema:");
            System.out.println("===========================");
            System.out.println(formatJson(result.result()));
            
            System.out.println("\n💡 This schema can handle arrays of products with consistent structure");
            
        } catch (Exception e) {
            System.err.println("❌ Error in product listing schema generation: " + e.getMessage());
        }
    }
    
    /**
     * Example 4: Using generated schema with SmartScraper
     */
    private static void useGeneratedSchemaWithScraper(ScrapegraphaiClient client) {
        System.out.println("\n🔄 Example 4: Using Generated Schema with SmartScraper");
        System.out.println("-----------------------------------------------------");
        
        try {
            String targetUrl = "https://books.toscrape.com/catalogue/a-light-in-the-attic_1000/index.html";
            
            // Step 1: Generate schema
            System.out.println("🏗️ Step 1: Generating schema...");
            GenerateSchemaCreateParams schemaParams = GenerateSchemaCreateParams.builder()
                .websiteUrl(targetUrl)
                .build();
            
            GenerateSchemaCreateResponse schemaResult = client.generateSchema().create(schemaParams);
            System.out.println("✅ Schema generated successfully!");
            
            // Step 2: Use the generated schema with SmartScraper
            System.out.println("\n🕷️ Step 2: Using schema with SmartScraper...");
            
            JsonNode generatedSchema = schemaResult.result();
            
            SmartscraperCreateParams scraperParams = SmartscraperCreateParams.builder()
                .userPrompt("Extract product information according to the generated schema")
                .websiteUrl(targetUrl)
                .outputSchema(generatedSchema)
                .build();
            
            CompletedSmartscraper scraperResult = client.smartscraper().create(scraperParams);
            
            System.out.println("✅ Scraping with generated schema completed!");
            System.out.println("\n📊 Comparison:");
            System.out.println("==============");
            System.out.println("🏗️ Generated Schema:");
            System.out.println(formatJson(generatedSchema));
            System.out.println("\n📝 Extracted Data (following schema):");
            System.out.println(formatJson(scraperResult.result()));
            
            System.out.println("\n💡 The extracted data follows the structure defined by the generated schema!");
            
        } catch (Exception e) {
            System.err.println("❌ Error using generated schema with scraper: " + e.getMessage());
        }
    }
    
    /**
     * Example 5: Monitoring schema generation progress
     */
    private static void monitorSchemaGeneration(ScrapegraphaiClient client) {
        System.out.println("\n⏱️ Example 5: Monitoring Schema Generation Progress");
        System.out.println("--------------------------------------------------");
        
        try {
            // Start schema generation
            GenerateSchemaCreateParams params = GenerateSchemaCreateParams.builder()
                .websiteUrl("https://en.wikipedia.org/wiki/JSON")
                .build();
            
            System.out.println("🚀 Starting schema generation for monitoring...");
            System.out.println("Target URL: https://en.wikipedia.org/wiki/JSON");
            
            GenerateSchemaCreateResponse result = client.generateSchema().create(params);
            
            String requestId = result.requestId();
            System.out.println("📋 Request ID: " + requestId);
            System.out.println("✅ Initial schema generation completed");
            
            // Retrieve the schema generation status/result
            System.out.println("\n🔄 Retrieving schema generation status...");
            GenerateSchemaRetrieveResponse status = client.generateSchema().retrieve(requestId);
            
            System.out.println("📊 Schema Generation Status:");
            System.out.println("============================");
            System.out.println("Status: " + status.status());
            
            if (status.result() != null) {
                System.out.println("🏗️ Generated Schema:");
                System.out.println(formatJson(status.result()));
                
                // Analyze the schema structure
                analyzeGeneratedSchema(status.result());
            }
            
            if (status.error() != null) {
                System.out.println("⚠️ Error: " + status.error());
            }
            
            if (status.requestId() != null) {
                System.out.println("🔗 Request ID: " + status.requestId());
            }
            
        } catch (Exception e) {
            System.err.println("❌ Error monitoring schema generation: " + e.getMessage());
        }
    }
    
    /**
     * Helper method to analyze and describe a generated schema
     */
    private static void analyzeGeneratedSchema(JsonNode schema) {
        System.out.println("\n🔍 Schema Analysis:");
        System.out.println("==================");
        
        try {
            if (schema.has("type")) {
                System.out.println("📝 Schema Type: " + schema.get("type").asText());
            }
            
            if (schema.has("properties")) {
                JsonNode properties = schema.get("properties");
                System.out.println("🏷️ Properties Found: " + properties.size());
                
                properties.fieldNames().forEachRemaining(fieldName -> {
                    JsonNode property = properties.get(fieldName);
                    String type = property.has("type") ? property.get("type").asText() : "unknown";
                    System.out.println("  • " + fieldName + " (" + type + ")");
                });
            }
            
            if (schema.has("required")) {
                JsonNode required = schema.get("required");
                if (required.isArray()) {
                    System.out.println("⚠️ Required Fields: " + required.size());
                    required.forEach(field -> 
                        System.out.println("  • " + field.asText())
                    );
                }
            }
            
            System.out.println("\n💡 This schema can be used to extract structured data consistently from similar pages");
            
        } catch (Exception e) {
            System.out.println("❌ Error analyzing schema: " + e.getMessage());
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
