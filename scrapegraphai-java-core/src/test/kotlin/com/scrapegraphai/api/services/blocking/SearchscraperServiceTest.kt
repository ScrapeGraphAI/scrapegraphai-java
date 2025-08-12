// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.blocking

import com.scrapegraphai.api.TestServerExtension
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClient
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.models.searchscraper.SearchscraperCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SearchscraperServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            ScrapegraphaiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val searchscraperService = client.searchscraper()

        val completedSearchScraper =
            searchscraperService.create(
                SearchscraperCreateParams.builder()
                    .userPrompt("Find the latest AI news and extract headlines and summaries")
                    .headers(
                        SearchscraperCreateParams.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .numResults(3L)
                    .outputSchema(JsonValue.from(mapOf<String, Any>()))
                    .build()
            )

        completedSearchScraper.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveStatus() {
        val client =
            ScrapegraphaiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val searchscraperService = client.searchscraper()

        val response = searchscraperService.retrieveStatus("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        response.validate()
    }
}
