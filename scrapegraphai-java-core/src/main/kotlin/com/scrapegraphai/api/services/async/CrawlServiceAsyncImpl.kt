// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.async

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
import com.scrapegraphai.api.core.prepareAsync
import com.scrapegraphai.api.models.crawl.CrawlRetrieveResultsParams
import com.scrapegraphai.api.models.crawl.CrawlRetrieveResultsResponse
import com.scrapegraphai.api.models.crawl.CrawlStartParams
import com.scrapegraphai.api.models.crawl.CrawlStartResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class CrawlServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CrawlServiceAsync {

    private val withRawResponse: CrawlServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CrawlServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CrawlServiceAsync =
        CrawlServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieveResults(
        params: CrawlRetrieveResultsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CrawlRetrieveResultsResponse> =
        // get /crawl/{task_id}
        withRawResponse().retrieveResults(params, requestOptions).thenApply { it.parse() }

    override fun start(
        params: CrawlStartParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CrawlStartResponse> =
        // post /crawl
        withRawResponse().start(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CrawlServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CrawlServiceAsync.WithRawResponse =
            CrawlServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveResultsHandler: Handler<CrawlRetrieveResultsResponse> =
            jsonHandler<CrawlRetrieveResultsResponse>(clientOptions.jsonMapper)

        override fun retrieveResults(
            params: CrawlRetrieveResultsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CrawlRetrieveResultsResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("taskId", params.taskId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("crawl", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveResultsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val startHandler: Handler<CrawlStartResponse> =
            jsonHandler<CrawlStartResponse>(clientOptions.jsonMapper)

        override fun start(
            params: CrawlStartParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CrawlStartResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("crawl")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { startHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
