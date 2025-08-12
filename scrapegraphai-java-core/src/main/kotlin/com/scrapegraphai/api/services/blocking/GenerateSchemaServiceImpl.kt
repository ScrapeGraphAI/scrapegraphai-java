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
import com.scrapegraphai.api.models.generateschema.GenerateSchemaCreateParams
import com.scrapegraphai.api.models.generateschema.GenerateSchemaCreateResponse
import com.scrapegraphai.api.models.generateschema.GenerateSchemaRetrieveParams
import com.scrapegraphai.api.models.generateschema.GenerateSchemaRetrieveResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class GenerateSchemaServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    GenerateSchemaService {

    private val withRawResponse: GenerateSchemaService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): GenerateSchemaService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): GenerateSchemaService =
        GenerateSchemaServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: GenerateSchemaCreateParams,
        requestOptions: RequestOptions,
    ): GenerateSchemaCreateResponse =
        // post /generate_schema
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: GenerateSchemaRetrieveParams,
        requestOptions: RequestOptions,
    ): GenerateSchemaRetrieveResponse =
        // get /generate_schema/{request_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GenerateSchemaService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GenerateSchemaService.WithRawResponse =
            GenerateSchemaServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<GenerateSchemaCreateResponse> =
            jsonHandler<GenerateSchemaCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: GenerateSchemaCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GenerateSchemaCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("generate_schema")
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

        private val retrieveHandler: Handler<GenerateSchemaRetrieveResponse> =
            jsonHandler<GenerateSchemaRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: GenerateSchemaRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GenerateSchemaRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("requestId", params.requestId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("generate_schema", params._pathParam(0))
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
