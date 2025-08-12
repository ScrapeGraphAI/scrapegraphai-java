// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.scrapegraphai.api.client.ScrapegraphaiClient
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClient
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.models.smartscraper.SmartscraperCreateParams
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ServiceParamsTest {

    private lateinit var client: ScrapegraphaiClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            ScrapegraphaiOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val smartscraperService = client.smartscraper()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

        smartscraperService.create(
            SmartscraperCreateParams.builder()
                .userPrompt("Extract the product name, price, and description")
                .cookies(
                    SmartscraperCreateParams.Cookies.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .headers(
                    SmartscraperCreateParams.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .numberOfScrolls(0L)
                .outputSchema(JsonValue.from(mapOf<String, Any>()))
                .renderHeavyJs(true)
                .addStep("string")
                .totalPages(1L)
                .websiteHtml("website_html")
                .websiteUrl("https://example.com/product")
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }
}
