// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.blocking

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
import com.scrapegraphai.api.core.prepare
import com.scrapegraphai.api.models.credits.CreditRetrieveParams
import com.scrapegraphai.api.models.credits.CreditRetrieveResponse
import java.util.function.Consumer

class CreditServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CreditService {

    private val withRawResponse: CreditService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CreditService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CreditService =
        CreditServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: CreditRetrieveParams,
        requestOptions: RequestOptions,
    ): CreditRetrieveResponse =
        // get /credits
        withRawResponse().retrieve(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CreditService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CreditService.WithRawResponse =
            CreditServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<CreditRetrieveResponse> =
            jsonHandler<CreditRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: CreditRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CreditRetrieveResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("credits")
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
    }
}
