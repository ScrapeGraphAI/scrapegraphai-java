// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.blocking

import com.scrapegraphai.api.TestServerExtension
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClient
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.models.crawl.CrawlStartParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CrawlServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveResults() {
        val client =
            ScrapegraphaiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val crawlService = client.crawl()

        val response = crawlService.retrieveResults("task_id")

        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun start() {
        val client =
            ScrapegraphaiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val crawlService = client.crawl()

        val response =
            crawlService.start(
                CrawlStartParams.builder()
                    .url("https://example.com")
                    .depth(0L)
                    .extractionMode(true)
                    .maxPages(1L)
                    .prompt("prompt")
                    .renderHeavyJs(true)
                    .rules(
                        CrawlStartParams.Rules.builder()
                            .addExclude("string")
                            .sameDomain(true)
                            .build()
                    )
                    .schema(JsonValue.from(mapOf<String, Any>()))
                    .sitemap(true)
                    .build()
            )

        response.validate()
    }
}
