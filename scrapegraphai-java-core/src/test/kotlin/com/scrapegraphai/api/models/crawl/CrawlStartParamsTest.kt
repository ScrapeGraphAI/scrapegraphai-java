// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.crawl

import com.scrapegraphai.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CrawlStartParamsTest {

    @Test
    fun create() {
        CrawlStartParams.builder()
            .url("https://example.com")
            .depth(0L)
            .extractionMode(true)
            .maxPages(1L)
            .prompt("prompt")
            .renderHeavyJs(true)
            .rules(CrawlStartParams.Rules.builder().addExclude("string").sameDomain(true).build())
            .schema(JsonValue.from(mapOf<String, Any>()))
            .sitemap(true)
            .build()
    }

    @Test
    fun body() {
        val params =
            CrawlStartParams.builder()
                .url("https://example.com")
                .depth(0L)
                .extractionMode(true)
                .maxPages(1L)
                .prompt("prompt")
                .renderHeavyJs(true)
                .rules(
                    CrawlStartParams.Rules.builder().addExclude("string").sameDomain(true).build()
                )
                .schema(JsonValue.from(mapOf<String, Any>()))
                .sitemap(true)
                .build()

        val body = params._body()

        assertThat(body.url()).isEqualTo("https://example.com")
        assertThat(body.depth()).contains(0L)
        assertThat(body.extractionMode()).contains(true)
        assertThat(body.maxPages()).contains(1L)
        assertThat(body.prompt()).contains("prompt")
        assertThat(body.renderHeavyJs()).contains(true)
        assertThat(body.rules())
            .contains(
                CrawlStartParams.Rules.builder().addExclude("string").sameDomain(true).build()
            )
        assertThat(body._schema()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.sitemap()).contains(true)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = CrawlStartParams.builder().url("https://example.com").build()

        val body = params._body()

        assertThat(body.url()).isEqualTo("https://example.com")
    }
}
