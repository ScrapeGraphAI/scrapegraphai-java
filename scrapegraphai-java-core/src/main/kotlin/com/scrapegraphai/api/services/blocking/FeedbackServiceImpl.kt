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
import com.scrapegraphai.api.core.http.json
import com.scrapegraphai.api.core.http.parseable
import com.scrapegraphai.api.core.prepare
import com.scrapegraphai.api.models.feedback.FeedbackSubmitParams
import com.scrapegraphai.api.models.feedback.FeedbackSubmitResponse
import java.util.function.Consumer

class FeedbackServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    FeedbackService {

    private val withRawResponse: FeedbackService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FeedbackService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): FeedbackService =
        FeedbackServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun submit(
        params: FeedbackSubmitParams,
        requestOptions: RequestOptions,
    ): FeedbackSubmitResponse =
        // post /feedback
        withRawResponse().submit(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FeedbackService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FeedbackService.WithRawResponse =
            FeedbackServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val submitHandler: Handler<FeedbackSubmitResponse> =
            jsonHandler<FeedbackSubmitResponse>(clientOptions.jsonMapper)

        override fun submit(
            params: FeedbackSubmitParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FeedbackSubmitResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("feedback")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { submitHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
