// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.feedback

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FeedbackSubmitResponseTest {

    @Test
    fun create() {
        val feedbackSubmitResponse =
            FeedbackSubmitResponse.builder()
                .feedbackId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .feedbackTimestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .message("message")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(feedbackSubmitResponse.feedbackId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(feedbackSubmitResponse.feedbackTimestamp())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(feedbackSubmitResponse.message()).contains("message")
        assertThat(feedbackSubmitResponse.requestId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val feedbackSubmitResponse =
            FeedbackSubmitResponse.builder()
                .feedbackId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .feedbackTimestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .message("message")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val roundtrippedFeedbackSubmitResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(feedbackSubmitResponse),
                jacksonTypeRef<FeedbackSubmitResponse>(),
            )

        assertThat(roundtrippedFeedbackSubmitResponse).isEqualTo(feedbackSubmitResponse)
    }
}
