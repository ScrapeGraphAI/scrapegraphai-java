// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.searchscraper

import com.scrapegraphai.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SearchscraperCreateParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.userPrompt())
            .isEqualTo("Find the latest AI news and extract headlines and summaries")
        assertThat(body.headers())
            .contains(
                SearchscraperCreateParams.Headers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.numResults()).contains(3L)
        assertThat(body._outputSchema()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            SearchscraperCreateParams.builder()
                .userPrompt("Find the latest AI news and extract headlines and summaries")
                .build()

        val body = params._body()

        assertThat(body.userPrompt())
            .isEqualTo("Find the latest AI news and extract headlines and summaries")
    }
}
