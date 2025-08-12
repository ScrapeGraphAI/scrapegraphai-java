// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.async

import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.models.generateschema.GenerateSchemaCreateParams
import com.scrapegraphai.api.models.generateschema.GenerateSchemaCreateResponse
import com.scrapegraphai.api.models.generateschema.GenerateSchemaRetrieveParams
import com.scrapegraphai.api.models.generateschema.GenerateSchemaRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface GenerateSchemaServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): GenerateSchemaServiceAsync

    /**
     * Generate or modify JSON schemas based on natural language descriptions. Can create new
     * schemas or extend existing ones.
     */
    fun create(
        params: GenerateSchemaCreateParams
    ): CompletableFuture<GenerateSchemaCreateResponse> = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: GenerateSchemaCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GenerateSchemaCreateResponse>

    /** Retrieve the status and results of a schema generation request */
    fun retrieve(requestId: String): CompletableFuture<GenerateSchemaRetrieveResponse> =
        retrieve(requestId, GenerateSchemaRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        requestId: String,
        params: GenerateSchemaRetrieveParams = GenerateSchemaRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GenerateSchemaRetrieveResponse> =
        retrieve(params.toBuilder().requestId(requestId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        requestId: String,
        params: GenerateSchemaRetrieveParams = GenerateSchemaRetrieveParams.none(),
    ): CompletableFuture<GenerateSchemaRetrieveResponse> =
        retrieve(requestId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: GenerateSchemaRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GenerateSchemaRetrieveResponse>

    /** @see retrieve */
    fun retrieve(
        params: GenerateSchemaRetrieveParams
    ): CompletableFuture<GenerateSchemaRetrieveResponse> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        requestId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<GenerateSchemaRetrieveResponse> =
        retrieve(requestId, GenerateSchemaRetrieveParams.none(), requestOptions)

    /**
     * A view of [GenerateSchemaServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GenerateSchemaServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /generate_schema`, but is otherwise the same as
         * [GenerateSchemaServiceAsync.create].
         */
        fun create(
            params: GenerateSchemaCreateParams
        ): CompletableFuture<HttpResponseFor<GenerateSchemaCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: GenerateSchemaCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GenerateSchemaCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /generate_schema/{request_id}`, but is otherwise the
         * same as [GenerateSchemaServiceAsync.retrieve].
         */
        fun retrieve(
            requestId: String
        ): CompletableFuture<HttpResponseFor<GenerateSchemaRetrieveResponse>> =
            retrieve(requestId, GenerateSchemaRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            requestId: String,
            params: GenerateSchemaRetrieveParams = GenerateSchemaRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GenerateSchemaRetrieveResponse>> =
            retrieve(params.toBuilder().requestId(requestId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            requestId: String,
            params: GenerateSchemaRetrieveParams = GenerateSchemaRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<GenerateSchemaRetrieveResponse>> =
            retrieve(requestId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: GenerateSchemaRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GenerateSchemaRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: GenerateSchemaRetrieveParams
        ): CompletableFuture<HttpResponseFor<GenerateSchemaRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            requestId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GenerateSchemaRetrieveResponse>> =
            retrieve(requestId, GenerateSchemaRetrieveParams.none(), requestOptions)
    }
}
