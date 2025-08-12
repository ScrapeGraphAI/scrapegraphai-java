// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.crawl

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CrawlRetrieveResultsResponseTest {

    @Test
    fun create() {
        val crawlRetrieveResultsResponse =
            CrawlRetrieveResultsResponse.builder()
                .result(JsonValue.from(mapOf<String, Any>()))
                .status(CrawlRetrieveResultsResponse.Status.PENDING)
                .taskId("task_id")
                .traceback("traceback")
                .build()

        assertThat(crawlRetrieveResultsResponse.result())
            .contains(
                CrawlRetrieveResultsResponse.Result.ofJsonValue(
                    JsonValue.from(mapOf<String, Any>())
                )
            )
        assertThat(crawlRetrieveResultsResponse.status())
            .contains(CrawlRetrieveResultsResponse.Status.PENDING)
        assertThat(crawlRetrieveResultsResponse.taskId()).contains("task_id")
        assertThat(crawlRetrieveResultsResponse.traceback()).contains("traceback")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val crawlRetrieveResultsResponse =
            CrawlRetrieveResultsResponse.builder()
                .result(JsonValue.from(mapOf<String, Any>()))
                .status(CrawlRetrieveResultsResponse.Status.PENDING)
                .taskId("task_id")
                .traceback("traceback")
                .build()

        val roundtrippedCrawlRetrieveResultsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(crawlRetrieveResultsResponse),
                jacksonTypeRef<CrawlRetrieveResultsResponse>(),
            )

        assertThat(roundtrippedCrawlRetrieveResultsResponse).isEqualTo(crawlRetrieveResultsResponse)
    }
}
