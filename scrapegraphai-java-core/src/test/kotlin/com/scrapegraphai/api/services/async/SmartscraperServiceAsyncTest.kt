// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.async

import com.scrapegraphai.api.TestServerExtension
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClientAsync
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.models.smartscraper.SmartscraperCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SmartscraperServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            ScrapegraphaiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val smartscraperServiceAsync = client.smartscraper()

        val completedSmartscraperFuture =
            smartscraperServiceAsync.create(
                SmartscraperCreateParams.builder()
                    .userPrompt("Extract the product name, price, and description")
                    .cookies(
                        SmartscraperCreateParams.Cookies.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .headers(
                        SmartscraperCreateParams.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .numberOfScrolls(0L)
                    .outputSchema(JsonValue.from(mapOf<String, Any>()))
                    .renderHeavyJs(true)
                    .addStep("string")
                    .totalPages(1L)
                    .websiteHtml("website_html")
                    .websiteUrl("https://example.com/product")
                    .build()
            )

        val completedSmartscraper = completedSmartscraperFuture.get()
        completedSmartscraper.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            ScrapegraphaiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val smartscraperServiceAsync = client.smartscraper()

        val smartscraperFuture =
            smartscraperServiceAsync.retrieve("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        val smartscraper = smartscraperFuture.get()
        smartscraper.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            ScrapegraphaiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val smartscraperServiceAsync = client.smartscraper()

        val smartscrapersFuture = smartscraperServiceAsync.list()

        val smartscrapers = smartscrapersFuture.get()
        smartscrapers.validate()
    }
}
