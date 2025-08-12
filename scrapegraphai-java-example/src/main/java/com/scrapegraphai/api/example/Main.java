package com.scrapegraphai.api.example;

import com.scrapegraphai.api.client.ScrapegraphaiClient;
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClient;
import com.scrapegraphai.api.models.smartscraper.CompletedSmartscraper;
import com.scrapegraphai.api.models.smartscraper.SmartscraperCreateParams;

/**
 * Basic example demonstrating how to use the ScrapeGraphAI Java SDK
 * to extract structured data from a website using the SmartScraper.
 * 
 * Before running this example:
 * 1. Set your API key as an environment variable: SCRAPEGRAPHAI_API_KEY=your_api_key
 * 2. Or set it as a system property: -Dscrapegraphai.apiKey=your_api_key
 * 
 * Run with: ./gradlew :scrapegraphai-java-example:run
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("🕷️ ScrapeGraphAI Java SDK - Basic Example");
        System.out.println("==========================================");
        
        try {
            // Initialize the client (reads API key from environment or system properties)
            ScrapegraphaiClient client = ScrapegraphaiOkHttpClient.fromEnv();
            
            // Create a simple scraping request
            SmartscraperCreateParams params = SmartscraperCreateParams.builder()
                .userPrompt("Extract the main heading, description, and any pricing information from this page")
                .websiteUrl("https://scrapegraphai.com")
                .build();
            
            System.out.println("🚀 Starting scraping operation...");
            System.out.println("Target URL: https://scrapegraphai.com");
            System.out.println("Prompt: Extract the main heading, description, and any pricing information");
            
            // Execute the scraping request
            CompletedSmartscraper result = client.smartscraper().create(params);
            
            System.out.println("\n✅ Scraping completed successfully!");
            System.out.println("📊 Extracted Data:");
            System.out.println("==================");
            System.out.println(result.result());
            
        } catch (Exception e) {
            System.err.println("❌ Error occurred during scraping:");
            System.err.println(e.getMessage());
            
            // Print helpful troubleshooting information
            System.err.println("\n🔧 Troubleshooting:");
            System.err.println("1. Make sure your API key is set correctly");
            System.err.println("2. Check your internet connection");
            System.err.println("3. Verify the target website is accessible");
            
            e.printStackTrace();
        }
    }
}
