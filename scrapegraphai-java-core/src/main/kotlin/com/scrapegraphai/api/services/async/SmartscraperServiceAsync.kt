// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.async

import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.models.smartscraper.CompletedSmartscraper
import com.scrapegraphai.api.models.smartscraper.SmartscraperCreateParams
import com.scrapegraphai.api.models.smartscraper.SmartscraperListParams
import com.scrapegraphai.api.models.smartscraper.SmartscraperListResponse
import com.scrapegraphai.api.models.smartscraper.SmartscraperRetrieveParams
import com.scrapegraphai.api.models.smartscraper.SmartscraperRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface SmartscraperServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SmartscraperServiceAsync

    /**
     * Main scraping endpoint with LLM-powered content analysis. Supports various fetching
     * providers, infinite scrolling, pagination, and custom output schemas.
     */
    fun create(params: SmartscraperCreateParams): CompletableFuture<CompletedSmartscraper> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: SmartscraperCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CompletedSmartscraper>

    /** Retrieve the status and results of a scraping operation */
    fun retrieve(requestId: String): CompletableFuture<SmartscraperRetrieveResponse> =
        retrieve(requestId, SmartscraperRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        requestId: String,
        params: SmartscraperRetrieveParams = SmartscraperRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SmartscraperRetrieveResponse> =
        retrieve(params.toBuilder().requestId(requestId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        requestId: String,
        params: SmartscraperRetrieveParams = SmartscraperRetrieveParams.none(),
    ): CompletableFuture<SmartscraperRetrieveResponse> =
        retrieve(requestId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: SmartscraperRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SmartscraperRetrieveResponse>

    /** @see retrieve */
    fun retrieve(
        params: SmartscraperRetrieveParams
    ): CompletableFuture<SmartscraperRetrieveResponse> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        requestId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<SmartscraperRetrieveResponse> =
        retrieve(requestId, SmartscraperRetrieveParams.none(), requestOptions)

    /** Retrieve the status and results of a scraping operation */
    fun list(): CompletableFuture<SmartscraperListResponse> = list(SmartscraperListParams.none())

    /** @see list */
    fun list(
        params: SmartscraperListParams = SmartscraperListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SmartscraperListResponse>

    /** @see list */
    fun list(
        params: SmartscraperListParams = SmartscraperListParams.none()
    ): CompletableFuture<SmartscraperListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<SmartscraperListResponse> =
        list(SmartscraperListParams.none(), requestOptions)

    /**
     * A view of [SmartscraperServiceAsync] that provides access to raw HTTP responses for each
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
        ): SmartscraperServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /smartscraper`, but is otherwise the same as
         * [SmartscraperServiceAsync.create].
         */
        fun create(
            params: SmartscraperCreateParams
        ): CompletableFuture<HttpResponseFor<CompletedSmartscraper>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: SmartscraperCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CompletedSmartscraper>>

        /**
         * Returns a raw HTTP response for `get /smartscraper/{request_id}`, but is otherwise the
         * same as [SmartscraperServiceAsync.retrieve].
         */
        fun retrieve(
            requestId: String
        ): CompletableFuture<HttpResponseFor<SmartscraperRetrieveResponse>> =
            retrieve(requestId, SmartscraperRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            requestId: String,
            params: SmartscraperRetrieveParams = SmartscraperRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SmartscraperRetrieveResponse>> =
            retrieve(params.toBuilder().requestId(requestId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            requestId: String,
            params: SmartscraperRetrieveParams = SmartscraperRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<SmartscraperRetrieveResponse>> =
            retrieve(requestId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: SmartscraperRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SmartscraperRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: SmartscraperRetrieveParams
        ): CompletableFuture<HttpResponseFor<SmartscraperRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            requestId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SmartscraperRetrieveResponse>> =
            retrieve(requestId, SmartscraperRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /smartscraper`, but is otherwise the same as
         * [SmartscraperServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<SmartscraperListResponse>> =
            list(SmartscraperListParams.none())

        /** @see list */
        fun list(
            params: SmartscraperListParams = SmartscraperListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SmartscraperListResponse>>

        /** @see list */
        fun list(
            params: SmartscraperListParams = SmartscraperListParams.none()
        ): CompletableFuture<HttpResponseFor<SmartscraperListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<SmartscraperListResponse>> =
            list(SmartscraperListParams.none(), requestOptions)
    }
}
