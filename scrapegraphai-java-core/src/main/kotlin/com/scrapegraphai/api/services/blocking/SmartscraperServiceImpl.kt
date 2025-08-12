// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.blocking

import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.checkRequired
import com.scrapegraphai.api.core.handlers.errorBodyHandler
import com.scrapegraphai.api.core.handlers.errorHandler
import com.scrapegraphai.api.core.handlers.jsonHandler
import com.scrapegraphai.api.core.http.HttpMethod
import com.scrapegraphai.api.core.http.HttpRequest
import com.scrapegraphai.api.core.http.HttpResponse
import com.scrapegraphai.api.core.http.HttpResponse.Handler
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.core.http.json
import com.scrapegraphai.api.core.http.parseable
import com.scrapegraphai.api.core.prepare
import com.scrapegraphai.api.models.smartscraper.CompletedSmartscraper
import com.scrapegraphai.api.models.smartscraper.SmartscraperCreateParams
import com.scrapegraphai.api.models.smartscraper.SmartscraperListParams
import com.scrapegraphai.api.models.smartscraper.SmartscraperListResponse
import com.scrapegraphai.api.models.smartscraper.SmartscraperRetrieveParams
import com.scrapegraphai.api.models.smartscraper.SmartscraperRetrieveResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class SmartscraperServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SmartscraperService {

    private val withRawResponse: SmartscraperService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SmartscraperService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SmartscraperService =
        SmartscraperServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: SmartscraperCreateParams,
        requestOptions: RequestOptions,
    ): CompletedSmartscraper =
        // post /smartscraper
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: SmartscraperRetrieveParams,
        requestOptions: RequestOptions,
    ): SmartscraperRetrieveResponse =
        // get /smartscraper/{request_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(
        params: SmartscraperListParams,
        requestOptions: RequestOptions,
    ): SmartscraperListResponse =
        // get /smartscraper
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SmartscraperService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SmartscraperService.WithRawResponse =
            SmartscraperServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<CompletedSmartscraper> =
            jsonHandler<CompletedSmartscraper>(clientOptions.jsonMapper)

        override fun create(
            params: SmartscraperCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CompletedSmartscraper> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("smartscraper")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<SmartscraperRetrieveResponse> =
            jsonHandler<SmartscraperRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: SmartscraperRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SmartscraperRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("requestId", params.requestId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("smartscraper", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<SmartscraperListResponse> =
            jsonHandler<SmartscraperListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: SmartscraperListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SmartscraperListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("smartscraper")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
