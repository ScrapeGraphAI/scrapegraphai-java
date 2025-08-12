// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.blocking

import com.scrapegraphai.api.TestServerExtension
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClient
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.models.markdownify.MarkdownifyConvertParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MarkdownifyServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun convert() {
        val client =
            ScrapegraphaiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val markdownifyService = client.markdownify()

        val completedMarkdownify =
            markdownifyService.convert(
                MarkdownifyConvertParams.builder()
                    .websiteUrl("https://example.com")
                    .headers(
                        MarkdownifyConvertParams.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .addStep("string")
                    .build()
            )

        completedMarkdownify.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveStatus() {
        val client =
            ScrapegraphaiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val markdownifyService = client.markdownify()

        val response = markdownifyService.retrieveStatus("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        response.validate()
    }
}
