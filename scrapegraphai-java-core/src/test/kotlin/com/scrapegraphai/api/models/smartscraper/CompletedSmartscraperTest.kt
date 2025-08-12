// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.smartscraper

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CompletedSmartscraperTest {

    @Test
    fun create() {
        val completedSmartscraper =
            CompletedSmartscraper.builder()
                .error("error")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .result(JsonValue.from(mapOf<String, Any>()))
                .status(CompletedSmartscraper.Status.QUEUED)
                .userPrompt("user_prompt")
                .websiteUrl("https://example.com")
                .build()

        assertThat(completedSmartscraper.error()).contains("error")
        assertThat(completedSmartscraper.requestId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(completedSmartscraper._result()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(completedSmartscraper.status()).contains(CompletedSmartscraper.Status.QUEUED)
        assertThat(completedSmartscraper.userPrompt()).contains("user_prompt")
        assertThat(completedSmartscraper.websiteUrl()).contains("https://example.com")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val completedSmartscraper =
            CompletedSmartscraper.builder()
                .error("error")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .result(JsonValue.from(mapOf<String, Any>()))
                .status(CompletedSmartscraper.Status.QUEUED)
                .userPrompt("user_prompt")
                .websiteUrl("https://example.com")
                .build()

        val roundtrippedCompletedSmartscraper =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(completedSmartscraper),
                jacksonTypeRef<CompletedSmartscraper>(),
            )

        assertThat(roundtrippedCompletedSmartscraper).isEqualTo(completedSmartscraper)
    }
}
