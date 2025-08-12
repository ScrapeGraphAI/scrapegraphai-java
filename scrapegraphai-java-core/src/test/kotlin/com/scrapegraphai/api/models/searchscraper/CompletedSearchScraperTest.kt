// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.searchscraper

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CompletedSearchScraperTest {

    @Test
    fun create() {
        val completedSearchScraper =
            CompletedSearchScraper.builder()
                .error("error")
                .numResults(0L)
                .addReferenceUrl("https://example.com")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .result(JsonValue.from(mapOf<String, Any>()))
                .status(CompletedSearchScraper.Status.QUEUED)
                .userPrompt("user_prompt")
                .build()

        assertThat(completedSearchScraper.error()).contains("error")
        assertThat(completedSearchScraper.numResults()).contains(0L)
        assertThat(completedSearchScraper.referenceUrls().getOrNull())
            .containsExactly("https://example.com")
        assertThat(completedSearchScraper.requestId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(completedSearchScraper._result()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(completedSearchScraper.status()).contains(CompletedSearchScraper.Status.QUEUED)
        assertThat(completedSearchScraper.userPrompt()).contains("user_prompt")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val completedSearchScraper =
            CompletedSearchScraper.builder()
                .error("error")
                .numResults(0L)
                .addReferenceUrl("https://example.com")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .result(JsonValue.from(mapOf<String, Any>()))
                .status(CompletedSearchScraper.Status.QUEUED)
                .userPrompt("user_prompt")
                .build()

        val roundtrippedCompletedSearchScraper =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(completedSearchScraper),
                jacksonTypeRef<CompletedSearchScraper>(),
            )

        assertThat(roundtrippedCompletedSearchScraper).isEqualTo(completedSearchScraper)
    }
}
