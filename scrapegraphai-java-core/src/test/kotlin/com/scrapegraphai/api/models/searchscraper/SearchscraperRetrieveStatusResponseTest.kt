// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.searchscraper

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.jsonMapper
import com.scrapegraphai.api.errors.ScrapegraphaiInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class SearchscraperRetrieveStatusResponseTest {

    @Test
    fun ofCompletedSearchScraper() {
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

        val searchscraperRetrieveStatusResponse =
            SearchscraperRetrieveStatusResponse.ofCompletedSearchScraper(completedSearchScraper)

        assertThat(searchscraperRetrieveStatusResponse.completedSearchScraper())
            .contains(completedSearchScraper)
        assertThat(searchscraperRetrieveStatusResponse.failedSearchScraper()).isEmpty
    }

    @Test
    fun ofCompletedSearchScraperRoundtrip() {
        val jsonMapper = jsonMapper()
        val searchscraperRetrieveStatusResponse =
            SearchscraperRetrieveStatusResponse.ofCompletedSearchScraper(
                CompletedSearchScraper.builder()
                    .error("error")
                    .numResults(0L)
                    .addReferenceUrl("https://example.com")
                    .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .result(JsonValue.from(mapOf<String, Any>()))
                    .status(CompletedSearchScraper.Status.QUEUED)
                    .userPrompt("user_prompt")
                    .build()
            )

        val roundtrippedSearchscraperRetrieveStatusResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(searchscraperRetrieveStatusResponse),
                jacksonTypeRef<SearchscraperRetrieveStatusResponse>(),
            )

        assertThat(roundtrippedSearchscraperRetrieveStatusResponse)
            .isEqualTo(searchscraperRetrieveStatusResponse)
    }

    @Test
    fun ofFailedSearchScraper() {
        val failedSearchScraper =
            SearchscraperRetrieveStatusResponse.FailedSearchScraperResponse.builder()
                .error("error")
                .numResults(0L)
                .addReferenceUrl("string")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .result(JsonValue.from(mapOf<String, Any>()))
                .status(
                    SearchscraperRetrieveStatusResponse.FailedSearchScraperResponse.Status.FAILED
                )
                .userPrompt("user_prompt")
                .build()

        val searchscraperRetrieveStatusResponse =
            SearchscraperRetrieveStatusResponse.ofFailedSearchScraper(failedSearchScraper)

        assertThat(searchscraperRetrieveStatusResponse.completedSearchScraper()).isEmpty
        assertThat(searchscraperRetrieveStatusResponse.failedSearchScraper())
            .contains(failedSearchScraper)
    }

    @Test
    fun ofFailedSearchScraperRoundtrip() {
        val jsonMapper = jsonMapper()
        val searchscraperRetrieveStatusResponse =
            SearchscraperRetrieveStatusResponse.ofFailedSearchScraper(
                SearchscraperRetrieveStatusResponse.FailedSearchScraperResponse.builder()
                    .error("error")
                    .numResults(0L)
                    .addReferenceUrl("string")
                    .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .result(JsonValue.from(mapOf<String, Any>()))
                    .status(
                        SearchscraperRetrieveStatusResponse.FailedSearchScraperResponse.Status
                            .FAILED
                    )
                    .userPrompt("user_prompt")
                    .build()
            )

        val roundtrippedSearchscraperRetrieveStatusResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(searchscraperRetrieveStatusResponse),
                jacksonTypeRef<SearchscraperRetrieveStatusResponse>(),
            )

        assertThat(roundtrippedSearchscraperRetrieveStatusResponse)
            .isEqualTo(searchscraperRetrieveStatusResponse)
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
        val searchscraperRetrieveStatusResponse =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<SearchscraperRetrieveStatusResponse>())

        val e =
            assertThrows<ScrapegraphaiInvalidDataException> {
                searchscraperRetrieveStatusResponse.validate()
            }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
