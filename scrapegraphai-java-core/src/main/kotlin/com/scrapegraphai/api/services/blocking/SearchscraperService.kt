// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.models.searchscraper.CompletedSearchScraper
import com.scrapegraphai.api.models.searchscraper.SearchscraperCreateParams
import com.scrapegraphai.api.models.searchscraper.SearchscraperRetrieveStatusParams
import com.scrapegraphai.api.models.searchscraper.SearchscraperRetrieveStatusResponse
import java.util.function.Consumer

interface SearchscraperService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SearchscraperService

    /**
     * Performs web search, selects relevant URLs, and extracts structured data from multiple
     * websites. Uses LLM to refine search queries and merge results from different sources.
     */
    fun create(params: SearchscraperCreateParams): CompletedSearchScraper =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: SearchscraperCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletedSearchScraper

    /** Retrieve the status and results of a search scraping operation */
    fun retrieveStatus(requestId: String): SearchscraperRetrieveStatusResponse =
        retrieveStatus(requestId, SearchscraperRetrieveStatusParams.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        requestId: String,
        params: SearchscraperRetrieveStatusParams = SearchscraperRetrieveStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SearchscraperRetrieveStatusResponse =
        retrieveStatus(params.toBuilder().requestId(requestId).build(), requestOptions)

    /** @see retrieveStatus */
    fun retrieveStatus(
        requestId: String,
        params: SearchscraperRetrieveStatusParams = SearchscraperRetrieveStatusParams.none(),
    ): SearchscraperRetrieveStatusResponse =
        retrieveStatus(requestId, params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        params: SearchscraperRetrieveStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SearchscraperRetrieveStatusResponse

    /** @see retrieveStatus */
    fun retrieveStatus(
        params: SearchscraperRetrieveStatusParams
    ): SearchscraperRetrieveStatusResponse = retrieveStatus(params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        requestId: String,
        requestOptions: RequestOptions,
    ): SearchscraperRetrieveStatusResponse =
        retrieveStatus(requestId, SearchscraperRetrieveStatusParams.none(), requestOptions)

    /**
     * A view of [SearchscraperService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SearchscraperService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /searchscraper`, but is otherwise the same as
         * [SearchscraperService.create].
         */
        @MustBeClosed
        fun create(params: SearchscraperCreateParams): HttpResponseFor<CompletedSearchScraper> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: SearchscraperCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CompletedSearchScraper>

        /**
         * Returns a raw HTTP response for `get /searchscraper/{request_id}`, but is otherwise the
         * same as [SearchscraperService.retrieveStatus].
         */
        @MustBeClosed
        fun retrieveStatus(
            requestId: String
        ): HttpResponseFor<SearchscraperRetrieveStatusResponse> =
            retrieveStatus(requestId, SearchscraperRetrieveStatusParams.none())

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            requestId: String,
            params: SearchscraperRetrieveStatusParams = SearchscraperRetrieveStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SearchscraperRetrieveStatusResponse> =
            retrieveStatus(params.toBuilder().requestId(requestId).build(), requestOptions)

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            requestId: String,
            params: SearchscraperRetrieveStatusParams = SearchscraperRetrieveStatusParams.none(),
        ): HttpResponseFor<SearchscraperRetrieveStatusResponse> =
            retrieveStatus(requestId, params, RequestOptions.none())

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            params: SearchscraperRetrieveStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SearchscraperRetrieveStatusResponse>

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            params: SearchscraperRetrieveStatusParams
        ): HttpResponseFor<SearchscraperRetrieveStatusResponse> =
            retrieveStatus(params, RequestOptions.none())

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            requestId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SearchscraperRetrieveStatusResponse> =
            retrieveStatus(requestId, SearchscraperRetrieveStatusParams.none(), requestOptions)
    }
}
