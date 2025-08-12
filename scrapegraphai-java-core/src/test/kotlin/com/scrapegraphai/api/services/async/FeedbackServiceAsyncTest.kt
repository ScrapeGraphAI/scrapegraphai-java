// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.async

import com.scrapegraphai.api.TestServerExtension
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClientAsync
import com.scrapegraphai.api.models.feedback.FeedbackSubmitParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FeedbackServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun submit() {
        val client =
            ScrapegraphaiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val feedbackServiceAsync = client.feedback()

        val responseFuture =
            feedbackServiceAsync.submit(
                FeedbackSubmitParams.builder()
                    .rating(0L)
                    .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .feedbackText("feedback_text")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
