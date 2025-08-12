// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.smartscraper

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FailedSmartscraperTest {

    @Test
    fun create() {
        val failedSmartscraper =
            FailedSmartscraper.builder()
                .error("error")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .result(JsonValue.from(mapOf<String, Any>()))
                .status(FailedSmartscraper.Status.FAILED)
                .userPrompt("user_prompt")
                .websiteUrl("https://example.com")
                .build()

        assertThat(failedSmartscraper.error()).contains("error")
        assertThat(failedSmartscraper.requestId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(failedSmartscraper._result()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(failedSmartscraper.status()).contains(FailedSmartscraper.Status.FAILED)
        assertThat(failedSmartscraper.userPrompt()).contains("user_prompt")
        assertThat(failedSmartscraper.websiteUrl()).contains("https://example.com")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val failedSmartscraper =
            FailedSmartscraper.builder()
                .error("error")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .result(JsonValue.from(mapOf<String, Any>()))
                .status(FailedSmartscraper.Status.FAILED)
                .userPrompt("user_prompt")
                .websiteUrl("https://example.com")
                .build()

        val roundtrippedFailedSmartscraper =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(failedSmartscraper),
                jacksonTypeRef<FailedSmartscraper>(),
            )

        assertThat(roundtrippedFailedSmartscraper).isEqualTo(failedSmartscraper)
    }
}
