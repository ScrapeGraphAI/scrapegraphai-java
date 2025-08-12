// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.async

import com.scrapegraphai.api.TestServerExtension
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClientAsync
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.models.crawl.CrawlStartParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CrawlServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveResults() {
        val client =
            ScrapegraphaiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val crawlServiceAsync = client.crawl()

        val responseFuture = crawlServiceAsync.retrieveResults("task_id")

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun start() {
        val client =
            ScrapegraphaiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val crawlServiceAsync = client.crawl()

        val responseFuture =
            crawlServiceAsync.start(
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

        val response = responseFuture.get()
        response.validate()
    }
}
