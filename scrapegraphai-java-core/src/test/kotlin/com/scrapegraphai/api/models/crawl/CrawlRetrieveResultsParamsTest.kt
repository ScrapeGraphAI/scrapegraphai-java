// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.crawl

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CrawlRetrieveResultsParamsTest {

    @Test
    fun create() {
        CrawlRetrieveResultsParams.builder().taskId("task_id").build()
    }

    @Test
    fun pathParams() {
        val params = CrawlRetrieveResultsParams.builder().taskId("task_id").build()

        assertThat(params._pathParam(0)).isEqualTo("task_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
