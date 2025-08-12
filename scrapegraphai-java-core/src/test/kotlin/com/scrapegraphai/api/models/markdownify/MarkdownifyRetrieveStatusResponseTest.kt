// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.markdownify

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.jsonMapper
import com.scrapegraphai.api.errors.ScrapegraphaiInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class MarkdownifyRetrieveStatusResponseTest {

    @Test
    fun ofCompletedMarkdownify() {
        val completedMarkdownify =
            CompletedMarkdownify.builder()
                .error("error")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .result("result")
                .status(CompletedMarkdownify.Status.QUEUED)
                .websiteUrl("https://example.com")
                .build()

        val markdownifyRetrieveStatusResponse =
            MarkdownifyRetrieveStatusResponse.ofCompletedMarkdownify(completedMarkdownify)

        assertThat(markdownifyRetrieveStatusResponse.completedMarkdownify())
            .contains(completedMarkdownify)
        assertThat(markdownifyRetrieveStatusResponse.failedMarkdownify()).isEmpty
    }

    @Test
    fun ofCompletedMarkdownifyRoundtrip() {
        val jsonMapper = jsonMapper()
        val markdownifyRetrieveStatusResponse =
            MarkdownifyRetrieveStatusResponse.ofCompletedMarkdownify(
                CompletedMarkdownify.builder()
                    .error("error")
                    .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .result("result")
                    .status(CompletedMarkdownify.Status.QUEUED)
                    .websiteUrl("https://example.com")
                    .build()
            )

        val roundtrippedMarkdownifyRetrieveStatusResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(markdownifyRetrieveStatusResponse),
                jacksonTypeRef<MarkdownifyRetrieveStatusResponse>(),
            )

        assertThat(roundtrippedMarkdownifyRetrieveStatusResponse)
            .isEqualTo(markdownifyRetrieveStatusResponse)
    }

    @Test
    fun ofFailedMarkdownify() {
        val failedMarkdownify =
            MarkdownifyRetrieveStatusResponse.FailedMarkdownifyResponse.builder()
                .error("error")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .result("result")
                .status(MarkdownifyRetrieveStatusResponse.FailedMarkdownifyResponse.Status.FAILED)
                .websiteUrl("https://example.com")
                .build()

        val markdownifyRetrieveStatusResponse =
            MarkdownifyRetrieveStatusResponse.ofFailedMarkdownify(failedMarkdownify)

        assertThat(markdownifyRetrieveStatusResponse.completedMarkdownify()).isEmpty
        assertThat(markdownifyRetrieveStatusResponse.failedMarkdownify())
            .contains(failedMarkdownify)
    }

    @Test
    fun ofFailedMarkdownifyRoundtrip() {
        val jsonMapper = jsonMapper()
        val markdownifyRetrieveStatusResponse =
            MarkdownifyRetrieveStatusResponse.ofFailedMarkdownify(
                MarkdownifyRetrieveStatusResponse.FailedMarkdownifyResponse.builder()
                    .error("error")
                    .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .result("result")
                    .status(
                        MarkdownifyRetrieveStatusResponse.FailedMarkdownifyResponse.Status.FAILED
                    )
                    .websiteUrl("https://example.com")
                    .build()
            )

        val roundtrippedMarkdownifyRetrieveStatusResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(markdownifyRetrieveStatusResponse),
                jacksonTypeRef<MarkdownifyRetrieveStatusResponse>(),
            )

        assertThat(roundtrippedMarkdownifyRetrieveStatusResponse)
            .isEqualTo(markdownifyRetrieveStatusResponse)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val markdownifyRetrieveStatusResponse =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<MarkdownifyRetrieveStatusResponse>())

        val e =
            assertThrows<ScrapegraphaiInvalidDataException> {
                markdownifyRetrieveStatusResponse.validate()
            }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
