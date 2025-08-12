// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.feedback

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FeedbackSubmitParamsTest {

    @Test
    fun create() {
        FeedbackSubmitParams.builder()
            .rating(0L)
            .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .feedbackText("feedback_text")
            .build()
    }

    @Test
    fun body() {
        val params =
            FeedbackSubmitParams.builder()
                .rating(0L)
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .feedbackText("feedback_text")
                .build()

        val body = params._body()

        assertThat(body.rating()).isEqualTo(0L)
        assertThat(body.requestId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body.feedbackText()).contains("feedback_text")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            FeedbackSubmitParams.builder()
                .rating(0L)
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val body = params._body()

        assertThat(body.rating()).isEqualTo(0L)
        assertThat(body.requestId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }
}
