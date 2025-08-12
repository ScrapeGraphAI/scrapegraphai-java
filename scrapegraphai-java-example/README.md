# ScrapeGraphAI Java SDK Examples

This module contains comprehensive examples demonstrating all features of the ScrapeGraphAI Java SDK.

## Prerequisites

1. **API Key**: Set your ScrapeGraphAI API key as an environment variable:
   ```bash
   export SCRAPEGRAPHAI_API_KEY="your_api_key_here"
   ```
   
   Or set it as a system property:
   ```bash
   -Dscrapegraphai.apiKey=your_api_key_here
   ```

2. **Java 8+**: This SDK requires Java 8 or later.

## Running Examples

### Basic Example
Run the main example (basic SmartScraper usage):
```bash
./gradlew :scrapegraphai-java-example:run
```

### Specific Examples
Run any specific example using the `-Pexample` parameter:

```bash
# Comprehensive SmartScraper examples
./gradlew :scrapegraphai-java-example:run -Pexample=Smartscraper

# Web search and scraping examples
./gradlew :scrapegraphai-java-example:run -Pexample=Searchscraper

# Website crawling examples
./gradlew :scrapegraphai-java-example:run -Pexample=Crawl

# HTML to Markdown conversion examples
./gradlew :scrapegraphai-java-example:run -Pexample=Markdownify

# Asynchronous operation examples
./gradlew :scrapegraphai-java-example:run -Pexample=Async

# Schema generation examples
./gradlew :scrapegraphai-java-example:run -Pexample=SchemaGeneration

# Utility service examples (validation, health, credits)
./gradlew :scrapegraphai-java-example:run -Pexample=Utility
```

## Example Overview

| Example File | Description | Key Features |
|-------------|-------------|--------------|
| **Main.java** | Basic SmartScraper usage | Simple scraping, error handling, getting started |
| **SmartscraperExample.java** | Comprehensive scraping scenarios | Custom schemas, pagination, JavaScript rendering, headers/cookies, result retrieval |
| **SearchscraperExample.java** | Web search + data extraction | Multi-source aggregation, product comparison, news collection, academic research |
| **CrawlExample.java** | Website crawling operations | Site exploration, path filtering, depth control, progress monitoring |
| **MarkdownifyExample.java** | HTML to Markdown conversion | Content formatting, documentation generation, custom options |
| **AsyncExample.java** | Asynchronous operations | Non-blocking requests, parallel processing, chaining operations, error handling |
| **SchemaGenerationExample.java** | Automatic schema creation | Schema analysis, structured data extraction, schema-driven scraping |
| **UtilityExample.java** | Service utilities | API validation, health checks, credit monitoring, feedback submission |

## Example Details

### 🕷️ SmartScraper Examples
- Basic product information extraction
- Structured data with custom JSON schemas
- Dynamic content requiring JavaScript rendering
- Pagination handling
- Custom headers and cookies for authenticated scraping
- Retrieving results by request ID

### 🔍 SearchScraper Examples
- General web search and data aggregation
- Product comparison across multiple e-commerce sites
- News aggregation from various sources
- Academic research paper collection
- Search progress monitoring

### 🕸️ Crawl Examples
- Basic website crawling
- E-commerce catalog exploration
- Blog and news site crawling
- Documentation site mapping
- Crawl progress monitoring and result retrieval

### 📝 Markdownify Examples
- Basic web page to Markdown conversion
- Blog post formatting
- Documentation page conversion
- Direct HTML content processing
- Conversion progress monitoring

### ⚡ Async Examples
- Basic asynchronous operations
- Parallel processing of multiple URLs
- Chaining async operations
- Mixed service operations
- Comprehensive error handling

### 🏗️ Schema Generation Examples
- E-commerce page schema generation
- Blog content schema creation
- Product listing schemas
- Using generated schemas with SmartScraper
- Schema analysis and monitoring

### 🛠️ Utility Examples
- API key validation and user information
- Service health checks
- Credit balance monitoring
- Feedback submission
- Comprehensive service status checks

## Common Use Cases

### E-commerce Data Extraction
```java
// Use SmartscraperExample for product details
// Use SearchscraperExample for price comparison
// Use CrawlExample for catalog exploration
```

### Content Management
```java
// Use MarkdownifyExample for content conversion
// Use CrawlExample for site mapping
// Use SchemaGenerationExample for consistent data structure
```

### Research and Analysis
```java
// Use SearchscraperExample for information gathering
// Use SmartscraperExample for specific data extraction
// Use AsyncExample for high-volume processing
```

### Monitoring and Maintenance
```java
// Use UtilityExample for service health checks
// Use AsyncExample for performance optimization
// Use CrawlExample for site monitoring
```

## Error Handling

All examples include comprehensive error handling patterns:
- Network connectivity issues
- API key validation problems
- Rate limiting and quota management
- Service availability checks
- Data parsing and validation errors

## Best Practices Demonstrated

1. **Resource Management**: Proper client initialization and cleanup
2. **Error Handling**: Graceful degradation and user-friendly error messages
3. **Async Operations**: Efficient parallel processing and non-blocking operations
4. **Configuration**: Environment-based configuration management
5. **Monitoring**: Service health and usage monitoring
6. **Documentation**: Clear code comments and usage examples

## Getting Help

- Check the main [README.md](../README.md) for general SDK documentation
- Review the [API documentation](https://docs.scrapegraphai.com) for detailed endpoint information
- Run the UtilityExample to verify your setup and check service status
- Use the feedback functionality in UtilityExample to report issues or suggestions

## Contributing

If you have ideas for additional examples or improvements to existing ones, please:
1. Fork the repository
2. Create a new example following the existing patterns
3. Add appropriate documentation
4. Submit a pull request

Examples should be:
- Self-contained and runnable
- Well-documented with clear explanations
- Include error handling
- Demonstrate best practices
- Cover real-world use cases
