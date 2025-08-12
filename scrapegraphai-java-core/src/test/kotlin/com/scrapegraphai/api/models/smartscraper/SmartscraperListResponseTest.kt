// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.smartscraper

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.jsonMapper
import com.scrapegraphai.api.errors.ScrapegraphaiInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class SmartscraperListResponseTest {

    @Test
    fun ofCompletedSmartscraper() {
        val completedSmartscraper =
            CompletedSmartscraper.builder()
                .error("error")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .result(JsonValue.from(mapOf<String, Any>()))
                .status(CompletedSmartscraper.Status.QUEUED)
                .userPrompt("user_prompt")
                .websiteUrl("https://example.com")
                .build()

        val smartscraperListResponse =
            SmartscraperListResponse.ofCompletedSmartscraper(completedSmartscraper)

        assertThat(smartscraperListResponse.completedSmartscraper()).contains(completedSmartscraper)
        assertThat(smartscraperListResponse.failedSmartscraper()).isEmpty
    }

    @Test
    fun ofCompletedSmartscraperRoundtrip() {
        val jsonMapper = jsonMapper()
        val smartscraperListResponse =
            SmartscraperListResponse.ofCompletedSmartscraper(
                CompletedSmartscraper.builder()
                    .error("error")
                    .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .result(JsonValue.from(mapOf<String, Any>()))
                    .status(CompletedSmartscraper.Status.QUEUED)
                    .userPrompt("user_prompt")
                    .websiteUrl("https://example.com")
                    .build()
            )

        val roundtrippedSmartscraperListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(smartscraperListResponse),
                jacksonTypeRef<SmartscraperListResponse>(),
            )

        assertThat(roundtrippedSmartscraperListResponse).isEqualTo(smartscraperListResponse)
    }

    @Test
    fun ofFailedSmartscraper() {
        val failedSmartscraper =
            FailedSmartscraper.builder()
                .error("error")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .result(JsonValue.from(mapOf<String, Any>()))
                .status(FailedSmartscraper.Status.FAILED)
                .userPrompt("user_prompt")
                .websiteUrl("https://example.com")
                .build()

        val smartscraperListResponse =
            SmartscraperListResponse.ofFailedSmartscraper(failedSmartscraper)

        assertThat(smartscraperListResponse.completedSmartscraper()).isEmpty
        assertThat(smartscraperListResponse.failedSmartscraper()).contains(failedSmartscraper)
    }

    @Test
    fun ofFailedSmartscraperRoundtrip() {
        val jsonMapper = jsonMapper()
        val smartscraperListResponse =
            SmartscraperListResponse.ofFailedSmartscraper(
                FailedSmartscraper.builder()
                    .error("error")
                    .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .result(JsonValue.from(mapOf<String, Any>()))
                    .status(FailedSmartscraper.Status.FAILED)
                    .userPrompt("user_prompt")
                    .websiteUrl("https://example.com")
                    .build()
            )

        val roundtrippedSmartscraperListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(smartscraperListResponse),
                jacksonTypeRef<SmartscraperListResponse>(),
            )

        assertThat(roundtrippedSmartscraperListResponse).isEqualTo(smartscraperListResponse)
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
        val smartscraperListResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<SmartscraperListResponse>())

        val e =
            assertThrows<ScrapegraphaiInvalidDataException> { smartscraperListResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
