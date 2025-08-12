package com.scrapegraphai.api.example;

import com.scrapegraphai.api.client.ScrapegraphaiClientAsync;
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClientAsync;
import com.scrapegraphai.api.models.smartscraper.CompletedSmartscraper;
import com.scrapegraphai.api.models.smartscraper.SmartscraperCreateParams;
import com.scrapegraphai.api.models.searchscraper.CompletedSearchScraper;
import com.scrapegraphai.api.models.searchscraper.SearchscraperCreateParams;
import com.scrapegraphai.api.models.crawl.CrawlStartParams;
import com.scrapegraphai.api.models.crawl.CrawlStartResponse;
import com.scrapegraphai.api.models.markdownify.CompletedMarkdownify;
import com.scrapegraphai.api.models.markdownify.MarkdownifyConvertParams;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;

/**
 * Examples demonstrating asynchronous operations with the ScrapeGraphAI SDK:
 * - Using async clients for non-blocking operations
 * - Handling CompletableFuture responses
 * - Parallel processing of multiple requests
 * - Error handling in async operations
 * - Combining multiple async operations
 * 
 * Async operations are essential for high-performance applications that need
 * to handle multiple scraping tasks concurrently without blocking threads.
 * 
 * Run with: ./gradlew :scrapegraphai-java-example:run -Pexample=Async
 */
public class AsyncExample {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ExecutorService executor = Executors.newFixedThreadPool(4);
    
    public static void main(String[] args) {
        System.out.println("⚡ ScrapeGraphAI Java SDK - Async Examples");
        System.out.println("==========================================");
        
        ScrapegraphaiClientAsync client = ScrapegraphaiOkHttpClientAsync.fromEnv();
        
        try {
            // Example 1: Basic async smartscraper operation
            basicAsyncScraping(client);
            
            // Example 2: Parallel processing of multiple URLs
            parallelScraping(client);
            
            // Example 3: Chaining async operations
            chainingAsyncOperations(client);
            
            // Example 4: Mixed service async operations
            mixedServiceOperations(client);
            
            // Example 5: Error handling in async operations
            asyncErrorHandling(client);
            
        } finally {
            // Clean up executor
            executor.shutdown();
            try {
                if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
    
    /**
     * Example 1: Basic async smartscraper operation
     */
    private static void basicAsyncScraping(ScrapegraphaiClientAsync client) {
        System.out.println("\n🚀 Example 1: Basic Async Scraping");
        System.out.println("----------------------------------");
        
        try {
            SmartscraperCreateParams params = SmartscraperCreateParams.builder()
                .userPrompt("Extract the main heading and description")
                .websiteUrl("https://example.com")
                .build();
            
            System.out.println("⏳ Starting async scraping operation...");
            
            CompletableFuture<CompletedSmartscraper> future = client.smartscraper().create(params);
            
            // Non-blocking: do other work while waiting
            System.out.println("🔄 Doing other work while scraping...");
            Thread.sleep(1000); // Simulate other work
            
            // Get the result when ready
            CompletedSmartscraper result = future.get(30, TimeUnit.SECONDS);
            
            System.out.println("✅ Async scraping completed!");
            System.out.println("📊 Result: " + formatJson(result.result()));
            
        } catch (Exception e) {
            System.err.println("❌ Error in basic async scraping: " + e.getMessage());
        }
    }
    
    /**
     * Example 2: Parallel processing of multiple URLs
     */
    private static void parallelScraping(ScrapegraphaiClientAsync client) {
        System.out.println("\n🔀 Example 2: Parallel Scraping");
        System.out.println("-------------------------------");
        
        try {
            List<String> urls = List.of(
                "https://example.com",
                "https://httpbin.org/json",
                "https://jsonplaceholder.typicode.com/posts/1"
            );
            
            List<CompletableFuture<CompletedSmartscraper>> futures = new ArrayList<>();
            
            System.out.println("🚀 Starting parallel scraping of " + urls.size() + " URLs...");
            
            // Start all async operations
            for (int i = 0; i < urls.size(); i++) {
                String url = urls.get(i);
                SmartscraperCreateParams params = SmartscraperCreateParams.builder()
                    .userPrompt("Extract the main content and key information from this page")
                    .websiteUrl(url)
                    .build();
                
                CompletableFuture<CompletedSmartscraper> future = client.smartscraper().create(params);
                futures.add(future);
                
                System.out.println("⏳ Started scraping: " + url);
            }
            
            // Wait for all to complete
            CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
            );
            
            allFutures.get(60, TimeUnit.SECONDS);
            
            System.out.println("✅ All parallel scraping completed!");
            
            // Process results
            for (int i = 0; i < futures.size(); i++) {
                CompletedSmartscraper result = futures.get(i).get();
                System.out.println("\n📊 Result " + (i + 1) + " (" + urls.get(i) + "):");
                System.out.println(formatJson(result.result()));
            }
            
        } catch (Exception e) {
            System.err.println("❌ Error in parallel scraping: " + e.getMessage());
        }
    }
    
    /**
     * Example 3: Chaining async operations
     */
    private static void chainingAsyncOperations(ScrapegraphaiClientAsync client) {
        System.out.println("\n🔗 Example 3: Chaining Async Operations");
        System.out.println("--------------------------------------");
        
        try {
            System.out.println("🚀 Starting chained async operations...");
            
            // First operation: SmartScraper
            SmartscraperCreateParams smartscraperParams = SmartscraperCreateParams.builder()
                .userPrompt("Extract any URLs or links mentioned on this page")
                .websiteUrl("https://example.com")
                .build();
            
            CompletableFuture<CompletedSmartscraper> smartscraperFuture = 
                client.smartscraper().create(smartscraperParams);
            
            // Chain with SearchScraper based on SmartScraper results
            CompletableFuture<CompletedSearchScraper> chainedFuture = smartscraperFuture
                .thenCompose(smartscraperResult -> {
                    System.out.println("✅ SmartScraper completed, starting SearchScraper...");
                    
                    SearchscraperCreateParams searchParams = SearchscraperCreateParams.builder()
                        .userPrompt("Find more information about the topics mentioned in the previous result")
                        .query("example domain information")
                        .maxResults(3L)
                        .build();
                    
                    return client.searchscraper().create(searchParams);
                })
                .exceptionally(throwable -> {
                    System.err.println("❌ Error in chained operation: " + throwable.getMessage());
                    return null;
                });
            
            // Wait for the entire chain to complete
            CompletedSearchScraper finalResult = chainedFuture.get(60, TimeUnit.SECONDS);
            
            if (finalResult != null) {
                System.out.println("✅ Chained operations completed!");
                System.out.println("📊 Final Result: " + formatJson(finalResult.result()));
            } else {
                System.out.println("❌ Chained operations failed");
            }
            
        } catch (Exception e) {
            System.err.println("❌ Error in chaining async operations: " + e.getMessage());
        }
    }
    
    /**
     * Example 4: Mixed service async operations
     */
    private static void mixedServiceOperations(ScrapegraphaiClientAsync client) {
        System.out.println("\n🎯 Example 4: Mixed Service Operations");
        System.out.println("-------------------------------------");
        
        try {
            System.out.println("🚀 Starting mixed async service operations...");
            
            // Create multiple different async operations
            CompletableFuture<CompletedSmartscraper> smartscraperFuture = 
                client.smartscraper().create(
                    SmartscraperCreateParams.builder()
                        .userPrompt("Extract main content")
                        .websiteUrl("https://example.com")
                        .build()
                );
            
            CompletableFuture<CompletedMarkdownify> markdownifyFuture = 
                client.markdownify().convert(
                    MarkdownifyConvertParams.builder()
                        .websiteUrl("https://example.com")
                        .build()
                );
            
            CompletableFuture<CrawlStartResponse> crawlFuture = 
                client.crawl().start(
                    CrawlStartParams.builder()
                        .userPrompt("Extract page titles")
                        .websiteUrl("https://example.com")
                        .maxDepth(1L)
                        .maxPages(3L)
                        .build()
                );
            
            // Combine all results
            CompletableFuture<String> combinedFuture = CompletableFuture.allOf(
                smartscraperFuture, markdownifyFuture, crawlFuture
            ).thenApply(v -> {
                try {
                    CompletedSmartscraper smartscraperResult = smartscraperFuture.get();
                    CompletedMarkdownify markdownifyResult = markdownifyFuture.get();
                    CrawlStartResponse crawlResult = crawlFuture.get();
                    
                    return String.format(
                        "Mixed Operations Results:\n" +
                        "SmartScraper: %s\n" +
                        "Markdownify: %s\n" +
                        "Crawl: %s",
                        formatJson(smartscraperResult.result()),
                        markdownifyResult.result().substring(0, Math.min(100, markdownifyResult.result().length())),
                        crawlResult.status()
                    );
                } catch (Exception e) {
                    return "Error combining results: " + e.getMessage();
                }
            });
            
            String combinedResult = combinedFuture.get(60, TimeUnit.SECONDS);
            System.out.println("✅ Mixed service operations completed!");
            System.out.println("📊 Combined Results:");
            System.out.println(combinedResult);
            
        } catch (Exception e) {
            System.err.println("❌ Error in mixed service operations: " + e.getMessage());
        }
    }
    
    /**
     * Example 5: Error handling in async operations
     */
    private static void asyncErrorHandling(ScrapegraphaiClientAsync client) {
        System.out.println("\n🛡️ Example 5: Async Error Handling");
        System.out.println("----------------------------------");
        
        try {
            System.out.println("🚀 Testing async error handling...");
            
            // Create an operation that might fail
            SmartscraperCreateParams params = SmartscraperCreateParams.builder()
                .userPrompt("Extract information")
                .websiteUrl("https://invalid-url-that-does-not-exist.com")
                .build();
            
            CompletableFuture<CompletedSmartscraper> future = client.smartscraper().create(params)
                .handle((result, throwable) -> {
                    if (throwable != null) {
                        System.out.println("⚠️ Async operation failed: " + throwable.getMessage());
                        // Return a default result or handle the error appropriately
                        return null;
                    } else {
                        System.out.println("✅ Async operation succeeded");
                        return result;
                    }
                })
                .exceptionally(throwable -> {
                    System.out.println("🔄 Fallback handling: " + throwable.getMessage());
                    return null;
                });
            
            // Multiple async operations with individual error handling
            List<CompletableFuture<String>> errorTestFutures = List.of(
                client.smartscraper().create(params)
                    .thenApply(result -> "Success: " + result.requestId())
                    .exceptionally(throwable -> "Failed: " + throwable.getMessage()),
                    
                client.smartscraper().create(
                    SmartscraperCreateParams.builder()
                        .userPrompt("Extract content")
                        .websiteUrl("https://httpbin.org/status/500")
                        .build()
                )
                .thenApply(result -> "Success: " + result.requestId())
                .exceptionally(throwable -> "Failed: " + throwable.getMessage()),
                
                client.smartscraper().create(
                    SmartscraperCreateParams.builder()
                        .userPrompt("Extract content")
                        .websiteUrl("https://httpbin.org/json")
                        .build()
                )
                .thenApply(result -> "Success: " + result.requestId())
                .exceptionally(throwable -> "Failed: " + throwable.getMessage())
            );
            
            // Wait for all error test operations
            CompletableFuture<Void> allErrorTests = CompletableFuture.allOf(
                errorTestFutures.toArray(new CompletableFuture[0])
            );
            
            allErrorTests.get(30, TimeUnit.SECONDS);
            
            System.out.println("✅ Error handling test completed!");
            System.out.println("📊 Results:");
            
            for (int i = 0; i < errorTestFutures.size(); i++) {
                String result = errorTestFutures.get(i).get();
                System.out.println("  " + (i + 1) + ". " + result);
            }
            
        } catch (Exception e) {
            System.err.println("❌ Error in async error handling test: " + e.getMessage());
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
