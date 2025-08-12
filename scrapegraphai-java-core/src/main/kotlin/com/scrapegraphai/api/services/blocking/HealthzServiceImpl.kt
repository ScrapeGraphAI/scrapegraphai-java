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
import com.scrapegraphai.api.models.healthz.HealthzCheckParams
import com.scrapegraphai.api.models.healthz.HealthzCheckResponse
import java.util.function.Consumer

class HealthzServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    HealthzService {

    private val withRawResponse: HealthzService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): HealthzService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): HealthzService =
        HealthzServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun check(
        params: HealthzCheckParams,
        requestOptions: RequestOptions,
    ): HealthzCheckResponse =
        // get /healthz
        withRawResponse().check(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        HealthzService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): HealthzService.WithRawResponse =
            HealthzServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val checkHandler: Handler<HealthzCheckResponse> =
            jsonHandler<HealthzCheckResponse>(clientOptions.jsonMapper)

        override fun check(
            params: HealthzCheckParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<HealthzCheckResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("healthz")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { checkHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
