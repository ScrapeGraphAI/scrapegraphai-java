// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.markdownify

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CompletedMarkdownifyTest {

    @Test
    fun create() {
        val completedMarkdownify =
            CompletedMarkdownify.builder()
                .error("error")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .result("result")
                .status(CompletedMarkdownify.Status.QUEUED)
                .websiteUrl("https://example.com")
                .build()

        assertThat(completedMarkdownify.error()).contains("error")
        assertThat(completedMarkdownify.requestId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(completedMarkdownify.result()).contains("result")
        assertThat(completedMarkdownify.status()).contains(CompletedMarkdownify.Status.QUEUED)
        assertThat(completedMarkdownify.websiteUrl()).contains("https://example.com")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val completedMarkdownify =
            CompletedMarkdownify.builder()
                .error("error")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .result("result")
                .status(CompletedMarkdownify.Status.QUEUED)
                .websiteUrl("https://example.com")
                .build()

        val roundtrippedCompletedMarkdownify =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(completedMarkdownify),
                jacksonTypeRef<CompletedMarkdownify>(),
            )

        assertThat(roundtrippedCompletedMarkdownify).isEqualTo(completedMarkdownify)
    }
}
