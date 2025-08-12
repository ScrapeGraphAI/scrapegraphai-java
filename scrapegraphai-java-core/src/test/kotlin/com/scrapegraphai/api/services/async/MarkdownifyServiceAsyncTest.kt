// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.async

import com.scrapegraphai.api.TestServerExtension
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClientAsync
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.models.markdownify.MarkdownifyConvertParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MarkdownifyServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun convert() {
        val client =
            ScrapegraphaiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val markdownifyServiceAsync = client.markdownify()

        val completedMarkdownifyFuture =
            markdownifyServiceAsync.convert(
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

        val completedMarkdownify = completedMarkdownifyFuture.get()
        completedMarkdownify.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveStatus() {
        val client =
            ScrapegraphaiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val markdownifyServiceAsync = client.markdownify()

        val responseFuture =
            markdownifyServiceAsync.retrieveStatus("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        val response = responseFuture.get()
        response.validate()
    }
}
