package com.scrapegraphai.api.example;

import com.scrapegraphai.api.client.ScrapegraphaiClient;
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClient;
import com.scrapegraphai.api.models.markdownify.CompletedMarkdownify;
import com.scrapegraphai.api.models.markdownify.MarkdownifyConvertParams;
import com.scrapegraphai.api.models.markdownify.MarkdownifyRetrieveStatusResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Examples demonstrating Markdownify functionality:
 * - Converting web pages to clean Markdown format
 * - Handling different content types and structures
 * - Customizing Markdown output format and style
 * - Processing HTML content directly
 * - Monitoring conversion progress
 * 
 * Markdownify is perfect for creating clean, readable documentation,
 * archiving web content, or preparing content for static site generators.
 * 
 * Run with: ./gradlew :scrapegraphai-java-example:run -Pexample=Markdownify
 */
public class MarkdownifyExample {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    public static void main(String[] args) {
        System.out.println("📝 ScrapeGraphAI Java SDK - Markdownify Examples");
        System.out.println("=================================================");
        
        ScrapegraphaiClient client = ScrapegraphaiOkHttpClient.fromEnv();
        
        // Example 1: Basic web page to Markdown conversion
        basicWebPageConversion(client);
        
        // Example 2: Blog post conversion
        blogPostConversion(client);
        
        // Example 3: Documentation page conversion
        documentationConversion(client);
        
        // Example 4: HTML content conversion
        htmlContentConversion(client);
        
        // Example 5: Monitoring conversion progress
        monitorConversionProgress(client);
    }
    
    /**
     * Example 1: Basic web page to Markdown conversion
     */
    private static void basicWebPageConversion(ScrapegraphaiClient client) {
        System.out.println("\n📄 Example 1: Basic Web Page Conversion");
        System.out.println("---------------------------------------");
        
        try {
            MarkdownifyConvertParams params = MarkdownifyConvertParams.builder()
                .websiteUrl("https://example.com")
                .build();
            
            System.out.println("🚀 Converting web page to Markdown...");
            System.out.println("Target URL: https://example.com");
            
            CompletedMarkdownify result = client.markdownify().convert(params);
            
            System.out.println("✅ Conversion completed!");
            System.out.println("📋 Request ID: " + result.requestId());
            System.out.println("📝 Markdown Content:");
            System.out.println("==================");
            System.out.println(result.result());
            
        } catch (Exception e) {
            System.err.println("❌ Error in basic web page conversion: " + e.getMessage());
        }
    }
    
    /**
     * Example 2: Blog post conversion with clean formatting
     */
    private static void blogPostConversion(ScrapegraphaiClient client) {
        System.out.println("\n📰 Example 2: Blog Post Conversion");
        System.out.println("----------------------------------");
        
        try {
            MarkdownifyConvertParams params = MarkdownifyConvertParams.builder()
                .websiteUrl("https://blog.example.com/latest-post")
                .includeImages(true)
                .includeLinks(true)
                .build();
            
            System.out.println("🚀 Converting blog post to Markdown...");
            System.out.println("Target URL: https://blog.example.com/latest-post");
            System.out.println("Include Images: true");
            System.out.println("Include Links: true");
            
            CompletedMarkdownify result = client.markdownify().convert(params);
            
            System.out.println("✅ Blog post conversion completed!");
            System.out.println("📝 Markdown Content:");
            System.out.println("==================");
            
            String markdown = result.result();
            // Show first 500 characters to avoid overwhelming output
            if (markdown.length() > 500) {
                System.out.println(markdown.substring(0, 500) + "...\n[Content truncated for display]");
            } else {
                System.out.println(markdown);
            }
            
        } catch (Exception e) {
            System.err.println("❌ Error in blog post conversion: " + e.getMessage());
        }
    }
    
    /**
     * Example 3: Documentation page conversion
     */
    private static void documentationConversion(ScrapegraphaiClient client) {
        System.out.println("\n📚 Example 3: Documentation Page Conversion");
        System.out.println("-------------------------------------------");
        
        try {
            MarkdownifyConvertParams params = MarkdownifyConvertParams.builder()
                .websiteUrl("https://docs.example.com/api-reference")
                .includeImages(false)
                .includeLinks(true)
                .includeTables(true)
                .includeCodeBlocks(true)
                .build();
            
            System.out.println("🚀 Converting documentation to Markdown...");
            System.out.println("Target URL: https://docs.example.com/api-reference");
            System.out.println("Include Images: false");
            System.out.println("Include Links: true");
            System.out.println("Include Tables: true");
            System.out.println("Include Code Blocks: true");
            
            CompletedMarkdownify result = client.markdownify().convert(params);
            
            System.out.println("✅ Documentation conversion completed!");
            System.out.println("📝 Markdown Documentation:");
            System.out.println("=========================");
            
            String markdown = result.result();
            // Show first 800 characters for documentation
            if (markdown.length() > 800) {
                System.out.println(markdown.substring(0, 800) + "...\n[Content truncated for display]");
            } else {
                System.out.println(markdown);
            }
            
        } catch (Exception e) {
            System.err.println("❌ Error in documentation conversion: " + e.getMessage());
        }
    }
    
    /**
     * Example 4: Direct HTML content conversion
     */
    private static void htmlContentConversion(ScrapegraphaiClient client) {
        System.out.println("\n🏷️ Example 4: HTML Content Conversion");
        System.out.println("-------------------------------------");
        
        try {
            String htmlContent = """
                <html>
                <head>
                    <title>Sample Document</title>
                </head>
                <body>
                    <h1>Welcome to Our Service</h1>
                    <p>This is a <strong>sample document</strong> with various HTML elements:</p>
                    <ul>
                        <li>First item with <em>emphasis</em></li>
                        <li>Second item with <a href="https://example.com">a link</a></li>
                        <li>Third item with <code>inline code</code></li>
                    </ul>
                    <h2>Code Example</h2>
                    <pre><code>
                    function hello() {
                        console.log("Hello, World!");
                    }
                    </code></pre>
                    <blockquote>
                        This is a quote from someone important.
                    </blockquote>
                    <table>
                        <tr>
                            <th>Name</th>
                            <th>Value</th>
                        </tr>
                        <tr>
                            <td>Item 1</td>
                            <td>100</td>
                        </tr>
                        <tr>
                            <td>Item 2</td>
                            <td>200</td>
                        </tr>
                    </table>
                </body>
                </html>
                """;
            
            MarkdownifyConvertParams params = MarkdownifyConvertParams.builder()
                .websiteHtml(htmlContent)
                .includeImages(true)
                .includeLinks(true)
                .includeTables(true)
                .includeCodeBlocks(true)
                .build();
            
            System.out.println("🚀 Converting HTML content to Markdown...");
            System.out.println("HTML Content: [Custom HTML document with various elements]");
            
            CompletedMarkdownify result = client.markdownify().convert(params);
            
            System.out.println("✅ HTML conversion completed!");
            System.out.println("📝 Generated Markdown:");
            System.out.println("====================");
            System.out.println(result.result());
            
        } catch (Exception e) {
            System.err.println("❌ Error in HTML content conversion: " + e.getMessage());
        }
    }
    
    /**
     * Example 5: Monitoring conversion progress
     */
    private static void monitorConversionProgress(ScrapegraphaiClient client) {
        System.out.println("\n⏱️ Example 5: Monitoring Conversion Progress");
        System.out.println("-------------------------------------------");
        
        try {
            // Start a conversion operation
            MarkdownifyConvertParams params = MarkdownifyConvertParams.builder()
                .websiteUrl("https://en.wikipedia.org/wiki/Markdown")
                .includeImages(false)
                .includeLinks(true)
                .build();
            
            System.out.println("🚀 Starting conversion for monitoring...");
            System.out.println("Target URL: https://en.wikipedia.org/wiki/Markdown");
            
            CompletedMarkdownify result = client.markdownify().convert(params);
            
            String requestId = result.requestId();
            System.out.println("📋 Request ID: " + requestId);
            System.out.println("✅ Initial conversion completed");
            
            // In a real scenario, you might want to check status for long-running operations
            System.out.println("🔄 Checking conversion status...");
            MarkdownifyRetrieveStatusResponse status = client.markdownify().retrieveStatus(requestId);
            
            System.out.println("📊 Status Information:");
            System.out.println("Status: " + status.status());
            
            if (status.result() != null) {
                System.out.println("📝 Markdown Result Available:");
                String markdown = status.result();
                // Show first 300 characters
                if (markdown.length() > 300) {
                    System.out.println(markdown.substring(0, 300) + "...\n[Content truncated for display]");
                } else {
                    System.out.println(markdown);
                }
            }
            
            if (status.error() != null) {
                System.out.println("⚠️ Error: " + status.error());
            }
            
            if (status.requestId() != null) {
                System.out.println("🔗 Request ID: " + status.requestId());
            }
            
        } catch (Exception e) {
            System.err.println("❌ Error monitoring conversion progress: " + e.getMessage());
        }
    }
}
