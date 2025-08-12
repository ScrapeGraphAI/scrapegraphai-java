// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.scrapegraphai.api.client.ScrapegraphaiClient
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClient
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.http.Headers
import com.scrapegraphai.api.core.jsonMapper
import com.scrapegraphai.api.errors.BadRequestException
import com.scrapegraphai.api.errors.InternalServerException
import com.scrapegraphai.api.errors.NotFoundException
import com.scrapegraphai.api.errors.PermissionDeniedException
import com.scrapegraphai.api.errors.RateLimitException
import com.scrapegraphai.api.errors.ScrapegraphaiException
import com.scrapegraphai.api.errors.UnauthorizedException
import com.scrapegraphai.api.errors.UnexpectedStatusCodeException
import com.scrapegraphai.api.errors.UnprocessableEntityException
import com.scrapegraphai.api.models.smartscraper.SmartscraperCreateParams
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

    private lateinit var client: ScrapegraphaiClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            ScrapegraphaiOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun smartscraperCreate400() {
        val smartscraperService = client.smartscraper()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun smartscraperCreate400WithRawResponse() {
        val smartscraperService = client.smartscraper().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun smartscraperCreate401() {
        val smartscraperService = client.smartscraper()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun smartscraperCreate401WithRawResponse() {
        val smartscraperService = client.smartscraper().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun smartscraperCreate403() {
        val smartscraperService = client.smartscraper()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun smartscraperCreate403WithRawResponse() {
        val smartscraperService = client.smartscraper().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun smartscraperCreate404() {
        val smartscraperService = client.smartscraper()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun smartscraperCreate404WithRawResponse() {
        val smartscraperService = client.smartscraper().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun smartscraperCreate422() {
        val smartscraperService = client.smartscraper()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun smartscraperCreate422WithRawResponse() {
        val smartscraperService = client.smartscraper().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun smartscraperCreate429() {
        val smartscraperService = client.smartscraper()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun smartscraperCreate429WithRawResponse() {
        val smartscraperService = client.smartscraper().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun smartscraperCreate500() {
        val smartscraperService = client.smartscraper()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun smartscraperCreate500WithRawResponse() {
        val smartscraperService = client.smartscraper().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun smartscraperCreate999() {
        val smartscraperService = client.smartscraper()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun smartscraperCreate999WithRawResponse() {
        val smartscraperService = client.smartscraper().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun smartscraperCreateInvalidJsonBody() {
        val smartscraperService = client.smartscraper()
        stubFor(
            post(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<ScrapegraphaiException> {
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
                        .build()
                )
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
