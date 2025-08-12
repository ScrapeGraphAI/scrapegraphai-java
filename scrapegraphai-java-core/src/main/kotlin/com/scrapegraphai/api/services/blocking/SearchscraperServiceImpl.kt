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
import com.scrapegraphai.api.models.searchscraper.CompletedSearchScraper
import com.scrapegraphai.api.models.searchscraper.SearchscraperCreateParams
import com.scrapegraphai.api.models.searchscraper.SearchscraperRetrieveStatusParams
import com.scrapegraphai.api.models.searchscraper.SearchscraperRetrieveStatusResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class SearchscraperServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SearchscraperService {

    private val withRawResponse: SearchscraperService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SearchscraperService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SearchscraperService =
        SearchscraperServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: SearchscraperCreateParams,
        requestOptions: RequestOptions,
    ): CompletedSearchScraper =
        // post /searchscraper
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieveStatus(
        params: SearchscraperRetrieveStatusParams,
        requestOptions: RequestOptions,
    ): SearchscraperRetrieveStatusResponse =
        // get /searchscraper/{request_id}
        withRawResponse().retrieveStatus(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SearchscraperService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SearchscraperService.WithRawResponse =
            SearchscraperServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<CompletedSearchScraper> =
            jsonHandler<CompletedSearchScraper>(clientOptions.jsonMapper)

        override fun create(
            params: SearchscraperCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CompletedSearchScraper> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("searchscraper")
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

        private val retrieveStatusHandler: Handler<SearchscraperRetrieveStatusResponse> =
            jsonHandler<SearchscraperRetrieveStatusResponse>(clientOptions.jsonMapper)

        override fun retrieveStatus(
            params: SearchscraperRetrieveStatusParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SearchscraperRetrieveStatusResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("requestId", params.requestId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("searchscraper", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveStatusHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
