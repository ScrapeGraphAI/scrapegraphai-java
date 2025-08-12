// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.markdownify

import com.scrapegraphai.api.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MarkdownifyConvertParamsTest {

    @Test
    fun create() {
        MarkdownifyConvertParams.builder()
            .websiteUrl("https://example.com")
            .headers(
                MarkdownifyConvertParams.Headers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .addStep("string")
            .build()
    }

    @Test
    fun body() {
        val params =
            MarkdownifyConvertParams.builder()
                .websiteUrl("https://example.com")
                .headers(
                    MarkdownifyConvertParams.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .addStep("string")
                .build()

        val body = params._body()

        assertThat(body.websiteUrl()).isEqualTo("https://example.com")
        assertThat(body.headers())
            .contains(
                MarkdownifyConvertParams.Headers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.steps().getOrNull()).containsExactly("string")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = MarkdownifyConvertParams.builder().websiteUrl("https://example.com").build()

        val body = params._body()

        assertThat(body.websiteUrl()).isEqualTo("https://example.com")
    }
}
