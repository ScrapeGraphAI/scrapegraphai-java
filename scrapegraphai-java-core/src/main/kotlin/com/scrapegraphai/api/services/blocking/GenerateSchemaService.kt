// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.models.generateschema.GenerateSchemaCreateParams
import com.scrapegraphai.api.models.generateschema.GenerateSchemaCreateResponse
import com.scrapegraphai.api.models.generateschema.GenerateSchemaRetrieveParams
import com.scrapegraphai.api.models.generateschema.GenerateSchemaRetrieveResponse
import java.util.function.Consumer

interface GenerateSchemaService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): GenerateSchemaService

    /**
     * Generate or modify JSON schemas based on natural language descriptions. Can create new
     * schemas or extend existing ones.
     */
    fun create(params: GenerateSchemaCreateParams): GenerateSchemaCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: GenerateSchemaCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GenerateSchemaCreateResponse

    /** Retrieve the status and results of a schema generation request */
    fun retrieve(requestId: String): GenerateSchemaRetrieveResponse =
        retrieve(requestId, GenerateSchemaRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        requestId: String,
        params: GenerateSchemaRetrieveParams = GenerateSchemaRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GenerateSchemaRetrieveResponse =
        retrieve(params.toBuilder().requestId(requestId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        requestId: String,
        params: GenerateSchemaRetrieveParams = GenerateSchemaRetrieveParams.none(),
    ): GenerateSchemaRetrieveResponse = retrieve(requestId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: GenerateSchemaRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GenerateSchemaRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: GenerateSchemaRetrieveParams): GenerateSchemaRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        requestId: String,
        requestOptions: RequestOptions,
    ): GenerateSchemaRetrieveResponse =
        retrieve(requestId, GenerateSchemaRetrieveParams.none(), requestOptions)

    /**
     * A view of [GenerateSchemaService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GenerateSchemaService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /generate_schema`, but is otherwise the same as
         * [GenerateSchemaService.create].
         */
        @MustBeClosed
        fun create(
            params: GenerateSchemaCreateParams
        ): HttpResponseFor<GenerateSchemaCreateResponse> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: GenerateSchemaCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GenerateSchemaCreateResponse>

        /**
         * Returns a raw HTTP response for `get /generate_schema/{request_id}`, but is otherwise the
         * same as [GenerateSchemaService.retrieve].
         */
        @MustBeClosed
        fun retrieve(requestId: String): HttpResponseFor<GenerateSchemaRetrieveResponse> =
            retrieve(requestId, GenerateSchemaRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            requestId: String,
            params: GenerateSchemaRetrieveParams = GenerateSchemaRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GenerateSchemaRetrieveResponse> =
            retrieve(params.toBuilder().requestId(requestId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            requestId: String,
            params: GenerateSchemaRetrieveParams = GenerateSchemaRetrieveParams.none(),
        ): HttpResponseFor<GenerateSchemaRetrieveResponse> =
            retrieve(requestId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: GenerateSchemaRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GenerateSchemaRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: GenerateSchemaRetrieveParams
        ): HttpResponseFor<GenerateSchemaRetrieveResponse> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            requestId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GenerateSchemaRetrieveResponse> =
            retrieve(requestId, GenerateSchemaRetrieveParams.none(), requestOptions)
    }
}
