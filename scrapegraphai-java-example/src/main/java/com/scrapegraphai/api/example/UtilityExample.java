package com.scrapegraphai.api.example;

import com.scrapegraphai.api.client.ScrapegraphaiClient;
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClient;
import com.scrapegraphai.api.models.validate.ValidateApiKeyResponse;
import com.scrapegraphai.api.models.healthz.HealthzCheckResponse;
import com.scrapegraphai.api.models.credits.CreditRetrieveResponse;
import com.scrapegraphai.api.models.feedback.FeedbackSubmitParams;
import com.scrapegraphai.api.models.feedback.FeedbackSubmitResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Examples demonstrating utility services:
 * - API key validation and user information
 * - Service health checks
 * - Credit balance and usage monitoring
 * - Feedback submission
 * - Service status monitoring
 * 
 * These utility services help you manage your API usage, monitor service
 * health, and provide feedback to improve the ScrapeGraphAI platform.
 * 
 * Run with: ./gradlew :scrapegraphai-java-example:run -Pexample=Utility
 */
public class UtilityExample {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    public static void main(String[] args) {
        System.out.println("🛠️ ScrapeGraphAI Java SDK - Utility Examples");
        System.out.println("==============================================");
        
        ScrapegraphaiClient client = ScrapegraphaiOkHttpClient.fromEnv();
        
        // Example 1: API key validation
        validateApiKey(client);
        
        // Example 2: Health check
        performHealthCheck(client);
        
        // Example 3: Check credit balance
        checkCreditBalance(client);
        
        // Example 4: Submit feedback
        submitFeedback(client);
        
        // Example 5: Comprehensive service status check
        comprehensiveStatusCheck(client);
    }
    
    /**
     * Example 1: Validate API key and get user information
     */
    private static void validateApiKey(ScrapegraphaiClient client) {
        System.out.println("\n🔑 Example 1: API Key Validation");
        System.out.println("--------------------------------");
        
        try {
            System.out.println("🔍 Validating API key...");
            
            ValidateApiKeyResponse response = client.validate().apiKey();
            
            System.out.println("✅ API key validation successful!");
            System.out.println("📧 User Email: " + response.email());
            
            if (response.userId() != null) {
                System.out.println("👤 User ID: " + response.userId());
            }
            
            if (response.plan() != null) {
                System.out.println("📋 Plan: " + response.plan());
            }
            
            if (response.apiKeyValid() != null) {
                System.out.println("🔐 API Key Valid: " + response.apiKeyValid());
            }
            
            System.out.println("\n💡 Your API key is properly configured and ready to use!");
            
        } catch (Exception e) {
            System.err.println("❌ API key validation failed: " + e.getMessage());
            System.err.println("🔧 Please check:");
            System.err.println("  • API key is set correctly (SCRAPEGRAPHAI_API_KEY environment variable)");
            System.err.println("  • API key is valid and not expired");
            System.err.println("  • Network connection is working");
        }
    }
    
    /**
     * Example 2: Perform service health check
     */
    private static void performHealthCheck(ScrapegraphaiClient client) {
        System.out.println("\n🏥 Example 2: Service Health Check");
        System.out.println("----------------------------------");
        
        try {
            System.out.println("🔍 Checking service health...");
            
            HealthzCheckResponse response = client.healthz().check();
            
            System.out.println("✅ Health check completed!");
            System.out.println("📊 Service Status: " + response.status());
            
            if (response.message() != null) {
                System.out.println("💬 Message: " + response.message());
            }
            
            if (response.timestamp() != null) {
                System.out.println("⏰ Timestamp: " + response.timestamp());
            }
            
            if (response.version() != null) {
                System.out.println("🏷️ Service Version: " + response.version());
            }
            
            // Interpret the status
            if ("healthy".equalsIgnoreCase(response.status()) || 
                "ok".equalsIgnoreCase(response.status())) {
                System.out.println("\n💚 Service is running normally!");
            } else {
                System.out.println("\n⚠️ Service may be experiencing issues");
            }
            
        } catch (Exception e) {
            System.err.println("❌ Health check failed: " + e.getMessage());
            System.err.println("🔧 This might indicate:");
            System.err.println("  • Service is temporarily unavailable");
            System.err.println("  • Network connectivity issues");
            System.err.println("  • Service maintenance in progress");
        }
    }
    
    /**
     * Example 3: Check credit balance and usage
     */
    private static void checkCreditBalance(ScrapegraphaiClient client) {
        System.out.println("\n💰 Example 3: Credit Balance Check");
        System.out.println("----------------------------------");
        
        try {
            System.out.println("🔍 Checking credit balance...");
            
            CreditRetrieveResponse response = client.credit().retrieve();
            
            System.out.println("✅ Credit information retrieved!");
            
            if (response.credits() != null) {
                System.out.println("💳 Available Credits: " + response.credits());
            }
            
            if (response.usedCredits() != null) {
                System.out.println("📊 Used Credits: " + response.usedCredits());
            }
            
            if (response.totalCredits() != null) {
                System.out.println("🎯 Total Credits: " + response.totalCredits());
                
                // Calculate usage percentage
                if (response.usedCredits() != null) {
                    double usagePercentage = (response.usedCredits().doubleValue() / 
                                            response.totalCredits().doubleValue()) * 100;
                    System.out.println("📈 Usage: " + String.format("%.1f%%", usagePercentage));
                }
            }
            
            if (response.resetDate() != null) {
                System.out.println("🔄 Reset Date: " + response.resetDate());
            }
            
            if (response.plan() != null) {
                System.out.println("📋 Plan: " + response.plan());
            }
            
            // Provide usage recommendations
            if (response.credits() != null && response.totalCredits() != null) {
                double remainingPercentage = (response.credits().doubleValue() / 
                                            response.totalCredits().doubleValue()) * 100;
                
                if (remainingPercentage < 10) {
                    System.out.println("\n⚠️ Warning: Low credit balance (" + 
                                     String.format("%.1f%%", remainingPercentage) + " remaining)");
                    System.out.println("💡 Consider upgrading your plan or monitoring usage");
                } else if (remainingPercentage < 25) {
                    System.out.println("\n🟡 Notice: Credit balance is getting low (" + 
                                     String.format("%.1f%%", remainingPercentage) + " remaining)");
                } else {
                    System.out.println("\n💚 Credit balance is healthy!");
                }
            }
            
        } catch (Exception e) {
            System.err.println("❌ Credit balance check failed: " + e.getMessage());
            System.err.println("🔧 This might be due to:");
            System.err.println("  • Invalid API key");
            System.err.println("  • Network connectivity issues");
            System.err.println("  • Temporary service unavailability");
        }
    }
    
    /**
     * Example 4: Submit feedback about the service
     */
    private static void submitFeedback(ScrapegraphaiClient client) {
        System.out.println("\n📝 Example 4: Submit Feedback");
        System.out.println("-----------------------------");
        
        try {
            FeedbackSubmitParams params = FeedbackSubmitParams.builder()
                .feedback("The Java SDK examples are very helpful! The async operations work great for our use case.")
                .rating(5L)
                .email("developer@example.com")
                .category("sdk")
                .build();
            
            System.out.println("📤 Submitting feedback...");
            System.out.println("Rating: 5/5 stars");
            System.out.println("Category: SDK");
            System.out.println("Feedback: The Java SDK examples are very helpful!");
            
            FeedbackSubmitResponse response = client.feedback().submit(params);
            
            System.out.println("✅ Feedback submitted successfully!");
            
            if (response.message() != null) {
                System.out.println("💬 Response: " + response.message());
            }
            
            if (response.feedbackId() != null) {
                System.out.println("📋 Feedback ID: " + response.feedbackId());
            }
            
            if (response.status() != null) {
                System.out.println("📊 Status: " + response.status());
            }
            
            System.out.println("\n💙 Thank you for helping improve ScrapeGraphAI!");
            
        } catch (Exception e) {
            System.err.println("❌ Feedback submission failed: " + e.getMessage());
            System.err.println("🔧 Please try again later or contact support");
        }
    }
    
    /**
     * Example 5: Comprehensive service status check
     */
    private static void comprehensiveStatusCheck(ScrapegraphaiClient client) {
        System.out.println("\n🔍 Example 5: Comprehensive Service Status");
        System.out.println("------------------------------------------");
        
        System.out.println("🚀 Running comprehensive service check...\n");
        
        // Track overall status
        boolean apiKeyValid = false;
        boolean serviceHealthy = false;
        boolean creditsAvailable = false;
        
        // 1. Check API Key
        System.out.println("1️⃣ API Key Validation:");
        try {
            ValidateApiKeyResponse validateResponse = client.validate().apiKey();
            apiKeyValid = Boolean.TRUE.equals(validateResponse.apiKeyValid());
            System.out.println("   ✅ API Key: " + (apiKeyValid ? "Valid" : "Invalid"));
            System.out.println("   👤 User: " + validateResponse.email());
        } catch (Exception e) {
            System.out.println("   ❌ API Key: Failed to validate");
        }
        
        // 2. Check Service Health
        System.out.println("\n2️⃣ Service Health:");
        try {
            HealthzCheckResponse healthResponse = client.healthz().check();
            serviceHealthy = "healthy".equalsIgnoreCase(healthResponse.status()) || 
                           "ok".equalsIgnoreCase(healthResponse.status());
            System.out.println("   " + (serviceHealthy ? "✅" : "❌") + " Status: " + healthResponse.status());
        } catch (Exception e) {
            System.out.println("   ❌ Health: Service unreachable");
        }
        
        // 3. Check Credits
        System.out.println("\n3️⃣ Credit Status:");
        try {
            CreditRetrieveResponse creditResponse = client.credit().retrieve();
            creditsAvailable = creditResponse.credits() != null && creditResponse.credits() > 0;
            System.out.println("   " + (creditsAvailable ? "✅" : "⚠️") + " Credits: " + 
                             (creditResponse.credits() != null ? creditResponse.credits() : "Unknown"));
        } catch (Exception e) {
            System.out.println("   ❌ Credits: Failed to retrieve");
        }
        
        // Overall Status Summary
        System.out.println("\n📊 Overall Status Summary:");
        System.out.println("========================");
        
        int checksPassedCount = 0;
        if (apiKeyValid) checksPassedCount++;
        if (serviceHealthy) checksPassedCount++;
        if (creditsAvailable) checksPassedCount++;
        
        String overallStatus;
        String statusEmoji;
        
        if (checksPassedCount == 3) {
            overallStatus = "Excellent - All systems operational";
            statusEmoji = "💚";
        } else if (checksPassedCount == 2) {
            overallStatus = "Good - Minor issues detected";
            statusEmoji = "🟡";
        } else if (checksPassedCount == 1) {
            overallStatus = "Warning - Multiple issues detected";
            statusEmoji = "🟠";
        } else {
            overallStatus = "Critical - Service unavailable";
            statusEmoji = "🔴";
        }
        
        System.out.println(statusEmoji + " Status: " + overallStatus);
        System.out.println("📈 Checks Passed: " + checksPassedCount + "/3");
        
        // Recommendations
        System.out.println("\n💡 Recommendations:");
        if (!apiKeyValid) {
            System.out.println("   • Verify your API key configuration");
        }
        if (!serviceHealthy) {
            System.out.println("   • Check service status or try again later");
        }
        if (!creditsAvailable) {
            System.out.println("   • Consider upgrading your plan or check billing");
        }
        if (checksPassedCount == 3) {
            System.out.println("   • All systems are ready for scraping operations! 🚀");
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
