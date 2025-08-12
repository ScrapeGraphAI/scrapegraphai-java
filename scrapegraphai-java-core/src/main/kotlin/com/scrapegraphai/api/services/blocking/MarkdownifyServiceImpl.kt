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
import com.scrapegraphai.api.models.markdownify.CompletedMarkdownify
import com.scrapegraphai.api.models.markdownify.MarkdownifyConvertParams
import com.scrapegraphai.api.models.markdownify.MarkdownifyRetrieveStatusParams
import com.scrapegraphai.api.models.markdownify.MarkdownifyRetrieveStatusResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class MarkdownifyServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MarkdownifyService {

    private val withRawResponse: MarkdownifyService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MarkdownifyService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MarkdownifyService =
        MarkdownifyServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun convert(
        params: MarkdownifyConvertParams,
        requestOptions: RequestOptions,
    ): CompletedMarkdownify =
        // post /markdownify
        withRawResponse().convert(params, requestOptions).parse()

    override fun retrieveStatus(
        params: MarkdownifyRetrieveStatusParams,
        requestOptions: RequestOptions,
    ): MarkdownifyRetrieveStatusResponse =
        // get /markdownify/{request_id}
        withRawResponse().retrieveStatus(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MarkdownifyService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MarkdownifyService.WithRawResponse =
            MarkdownifyServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val convertHandler: Handler<CompletedMarkdownify> =
            jsonHandler<CompletedMarkdownify>(clientOptions.jsonMapper)

        override fun convert(
            params: MarkdownifyConvertParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CompletedMarkdownify> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("markdownify")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { convertHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveStatusHandler: Handler<MarkdownifyRetrieveStatusResponse> =
            jsonHandler<MarkdownifyRetrieveStatusResponse>(clientOptions.jsonMapper)

        override fun retrieveStatus(
            params: MarkdownifyRetrieveStatusParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MarkdownifyRetrieveStatusResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("requestId", params.requestId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("markdownify", params._pathParam(0))
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
