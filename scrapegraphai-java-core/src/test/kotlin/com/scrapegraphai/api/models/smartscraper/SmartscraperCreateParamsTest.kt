// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.smartscraper

import com.scrapegraphai.api.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SmartscraperCreateParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.userPrompt()).isEqualTo("Extract the product name, price, and description")
        assertThat(body.cookies())
            .contains(
                SmartscraperCreateParams.Cookies.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.headers())
            .contains(
                SmartscraperCreateParams.Headers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.numberOfScrolls()).contains(0L)
        assertThat(body._outputSchema()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.renderHeavyJs()).contains(true)
        assertThat(body.steps().getOrNull()).containsExactly("string")
        assertThat(body.totalPages()).contains(1L)
        assertThat(body.websiteHtml()).contains("website_html")
        assertThat(body.websiteUrl()).contains("https://example.com/product")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            SmartscraperCreateParams.builder()
                .userPrompt("Extract the product name, price, and description")
                .build()

        val body = params._body()

        assertThat(body.userPrompt()).isEqualTo("Extract the product name, price, and description")
    }
}
