// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.async

import com.scrapegraphai.api.TestServerExtension
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class HealthzServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun check() {
        val client =
            ScrapegraphaiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val healthzServiceAsync = client.healthz()

        val responseFuture = healthzServiceAsync.check()

        val response = responseFuture.get()
        response.validate()
    }
}
