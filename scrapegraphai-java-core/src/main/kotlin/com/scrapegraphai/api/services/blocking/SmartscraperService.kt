// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.models.smartscraper.CompletedSmartscraper
import com.scrapegraphai.api.models.smartscraper.SmartscraperCreateParams
import com.scrapegraphai.api.models.smartscraper.SmartscraperListParams
import com.scrapegraphai.api.models.smartscraper.SmartscraperListResponse
import com.scrapegraphai.api.models.smartscraper.SmartscraperRetrieveParams
import com.scrapegraphai.api.models.smartscraper.SmartscraperRetrieveResponse
import java.util.function.Consumer

interface SmartscraperService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SmartscraperService

    /**
     * Main scraping endpoint with LLM-powered content analysis. Supports various fetching
     * providers, infinite scrolling, pagination, and custom output schemas.
     */
    fun create(params: SmartscraperCreateParams): CompletedSmartscraper =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: SmartscraperCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletedSmartscraper

    /** Retrieve the status and results of a scraping operation */
    fun retrieve(requestId: String): SmartscraperRetrieveResponse =
        retrieve(requestId, SmartscraperRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        requestId: String,
        params: SmartscraperRetrieveParams = SmartscraperRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SmartscraperRetrieveResponse =
        retrieve(params.toBuilder().requestId(requestId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        requestId: String,
        params: SmartscraperRetrieveParams = SmartscraperRetrieveParams.none(),
    ): SmartscraperRetrieveResponse = retrieve(requestId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: SmartscraperRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SmartscraperRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: SmartscraperRetrieveParams): SmartscraperRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(requestId: String, requestOptions: RequestOptions): SmartscraperRetrieveResponse =
        retrieve(requestId, SmartscraperRetrieveParams.none(), requestOptions)

    /** Retrieve the status and results of a scraping operation */
    fun list(): SmartscraperListResponse = list(SmartscraperListParams.none())

    /** @see list */
    fun list(
        params: SmartscraperListParams = SmartscraperListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SmartscraperListResponse

    /** @see list */
    fun list(
        params: SmartscraperListParams = SmartscraperListParams.none()
    ): SmartscraperListResponse = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): SmartscraperListResponse =
        list(SmartscraperListParams.none(), requestOptions)

    /**
     * A view of [SmartscraperService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SmartscraperService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /smartscraper`, but is otherwise the same as
         * [SmartscraperService.create].
         */
        @MustBeClosed
        fun create(params: SmartscraperCreateParams): HttpResponseFor<CompletedSmartscraper> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: SmartscraperCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CompletedSmartscraper>

        /**
         * Returns a raw HTTP response for `get /smartscraper/{request_id}`, but is otherwise the
         * same as [SmartscraperService.retrieve].
         */
        @MustBeClosed
        fun retrieve(requestId: String): HttpResponseFor<SmartscraperRetrieveResponse> =
            retrieve(requestId, SmartscraperRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            requestId: String,
            params: SmartscraperRetrieveParams = SmartscraperRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SmartscraperRetrieveResponse> =
            retrieve(params.toBuilder().requestId(requestId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            requestId: String,
            params: SmartscraperRetrieveParams = SmartscraperRetrieveParams.none(),
        ): HttpResponseFor<SmartscraperRetrieveResponse> =
            retrieve(requestId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: SmartscraperRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SmartscraperRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: SmartscraperRetrieveParams
        ): HttpResponseFor<SmartscraperRetrieveResponse> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            requestId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SmartscraperRetrieveResponse> =
            retrieve(requestId, SmartscraperRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /smartscraper`, but is otherwise the same as
         * [SmartscraperService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<SmartscraperListResponse> = list(SmartscraperListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: SmartscraperListParams = SmartscraperListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SmartscraperListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: SmartscraperListParams = SmartscraperListParams.none()
        ): HttpResponseFor<SmartscraperListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<SmartscraperListResponse> =
            list(SmartscraperListParams.none(), requestOptions)
    }
}
