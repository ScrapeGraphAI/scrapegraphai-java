// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.crawl

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CrawlStartResponseTest {

    @Test
    fun create() {
        val crawlStartResponse = CrawlStartResponse.builder().taskId("task_id").build()

        assertThat(crawlStartResponse.taskId()).contains("task_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val crawlStartResponse = CrawlStartResponse.builder().taskId("task_id").build()

        val roundtrippedCrawlStartResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(crawlStartResponse),
                jacksonTypeRef<CrawlStartResponse>(),
            )

        assertThat(roundtrippedCrawlStartResponse).isEqualTo(crawlStartResponse)
    }
}
