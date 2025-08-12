// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.async

import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.handlers.errorBodyHandler
import com.scrapegraphai.api.core.handlers.errorHandler
import com.scrapegraphai.api.core.handlers.jsonHandler
import com.scrapegraphai.api.core.http.HttpMethod
import com.scrapegraphai.api.core.http.HttpRequest
import com.scrapegraphai.api.core.http.HttpResponse
import com.scrapegraphai.api.core.http.HttpResponse.Handler
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.core.http.parseable
import com.scrapegraphai.api.core.prepareAsync
import com.scrapegraphai.api.models.credits.CreditRetrieveParams
import com.scrapegraphai.api.models.credits.CreditRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class CreditServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CreditServiceAsync {

    private val withRawResponse: CreditServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CreditServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CreditServiceAsync =
        CreditServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: CreditRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CreditRetrieveResponse> =
        // get /credits
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CreditServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CreditServiceAsync.WithRawResponse =
            CreditServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<CreditRetrieveResponse> =
            jsonHandler<CreditRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: CreditRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CreditRetrieveResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("credits")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveHandler.handle(it) }
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
