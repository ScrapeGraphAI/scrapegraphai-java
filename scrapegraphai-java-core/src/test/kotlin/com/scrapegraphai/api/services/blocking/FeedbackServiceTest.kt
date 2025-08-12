// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.blocking

import com.scrapegraphai.api.TestServerExtension
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClient
import com.scrapegraphai.api.models.feedback.FeedbackSubmitParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FeedbackServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun submit() {
        val client =
            ScrapegraphaiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val feedbackService = client.feedback()

        val response =
            feedbackService.submit(
                FeedbackSubmitParams.builder()
                    .rating(0L)
                    .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .feedbackText("feedback_text")
                    .build()
            )

        response.validate()
    }
}
