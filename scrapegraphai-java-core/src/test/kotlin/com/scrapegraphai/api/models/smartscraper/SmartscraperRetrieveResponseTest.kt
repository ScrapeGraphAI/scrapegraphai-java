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

internal class SmartscraperRetrieveResponseTest {

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

        val smartscraperRetrieveResponse =
            SmartscraperRetrieveResponse.ofCompletedSmartscraper(completedSmartscraper)

        assertThat(smartscraperRetrieveResponse.completedSmartscraper())
            .contains(completedSmartscraper)
        assertThat(smartscraperRetrieveResponse.failedSmartscraper()).isEmpty
    }

    @Test
    fun ofCompletedSmartscraperRoundtrip() {
        val jsonMapper = jsonMapper()
        val smartscraperRetrieveResponse =
            SmartscraperRetrieveResponse.ofCompletedSmartscraper(
                CompletedSmartscraper.builder()
                    .error("error")
                    .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .result(JsonValue.from(mapOf<String, Any>()))
                    .status(CompletedSmartscraper.Status.QUEUED)
                    .userPrompt("user_prompt")
                    .websiteUrl("https://example.com")
                    .build()
            )

        val roundtrippedSmartscraperRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(smartscraperRetrieveResponse),
                jacksonTypeRef<SmartscraperRetrieveResponse>(),
            )

        assertThat(roundtrippedSmartscraperRetrieveResponse).isEqualTo(smartscraperRetrieveResponse)
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

        val smartscraperRetrieveResponse =
            SmartscraperRetrieveResponse.ofFailedSmartscraper(failedSmartscraper)

        assertThat(smartscraperRetrieveResponse.completedSmartscraper()).isEmpty
        assertThat(smartscraperRetrieveResponse.failedSmartscraper()).contains(failedSmartscraper)
    }

    @Test
    fun ofFailedSmartscraperRoundtrip() {
        val jsonMapper = jsonMapper()
        val smartscraperRetrieveResponse =
            SmartscraperRetrieveResponse.ofFailedSmartscraper(
                FailedSmartscraper.builder()
                    .error("error")
                    .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .result(JsonValue.from(mapOf<String, Any>()))
                    .status(FailedSmartscraper.Status.FAILED)
                    .userPrompt("user_prompt")
                    .websiteUrl("https://example.com")
                    .build()
            )

        val roundtrippedSmartscraperRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(smartscraperRetrieveResponse),
                jacksonTypeRef<SmartscraperRetrieveResponse>(),
            )

        assertThat(roundtrippedSmartscraperRetrieveResponse).isEqualTo(smartscraperRetrieveResponse)
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
        val smartscraperRetrieveResponse =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<SmartscraperRetrieveResponse>())

        val e =
            assertThrows<ScrapegraphaiInvalidDataException> {
                smartscraperRetrieveResponse.validate()
            }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
