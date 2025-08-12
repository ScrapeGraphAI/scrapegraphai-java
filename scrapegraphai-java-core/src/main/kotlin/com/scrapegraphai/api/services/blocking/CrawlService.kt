// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.models.crawl.CrawlRetrieveResultsParams
import com.scrapegraphai.api.models.crawl.CrawlRetrieveResultsResponse
import com.scrapegraphai.api.models.crawl.CrawlStartParams
import com.scrapegraphai.api.models.crawl.CrawlStartResponse
import java.util.function.Consumer

interface CrawlService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CrawlService

    /** Retrieve the status and results of a crawling job */
    fun retrieveResults(taskId: String): CrawlRetrieveResultsResponse =
        retrieveResults(taskId, CrawlRetrieveResultsParams.none())

    /** @see retrieveResults */
    fun retrieveResults(
        taskId: String,
        params: CrawlRetrieveResultsParams = CrawlRetrieveResultsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CrawlRetrieveResultsResponse =
        retrieveResults(params.toBuilder().taskId(taskId).build(), requestOptions)

    /** @see retrieveResults */
    fun retrieveResults(
        taskId: String,
        params: CrawlRetrieveResultsParams = CrawlRetrieveResultsParams.none(),
    ): CrawlRetrieveResultsResponse = retrieveResults(taskId, params, RequestOptions.none())

    /** @see retrieveResults */
    fun retrieveResults(
        params: CrawlRetrieveResultsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CrawlRetrieveResultsResponse

    /** @see retrieveResults */
    fun retrieveResults(params: CrawlRetrieveResultsParams): CrawlRetrieveResultsResponse =
        retrieveResults(params, RequestOptions.none())

    /** @see retrieveResults */
    fun retrieveResults(
        taskId: String,
        requestOptions: RequestOptions,
    ): CrawlRetrieveResultsResponse =
        retrieveResults(taskId, CrawlRetrieveResultsParams.none(), requestOptions)

    /**
     * Initiate comprehensive website crawling with sitemap support. Supports both AI extraction
     * mode and markdown conversion mode. Returns a task ID for async processing.
     */
    fun start(params: CrawlStartParams): CrawlStartResponse = start(params, RequestOptions.none())

    /** @see start */
    fun start(
        params: CrawlStartParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CrawlStartResponse

    /** A view of [CrawlService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): CrawlService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /crawl/{task_id}`, but is otherwise the same as
         * [CrawlService.retrieveResults].
         */
        @MustBeClosed
        fun retrieveResults(taskId: String): HttpResponseFor<CrawlRetrieveResultsResponse> =
            retrieveResults(taskId, CrawlRetrieveResultsParams.none())

        /** @see retrieveResults */
        @MustBeClosed
        fun retrieveResults(
            taskId: String,
            params: CrawlRetrieveResultsParams = CrawlRetrieveResultsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CrawlRetrieveResultsResponse> =
            retrieveResults(params.toBuilder().taskId(taskId).build(), requestOptions)

        /** @see retrieveResults */
        @MustBeClosed
        fun retrieveResults(
            taskId: String,
            params: CrawlRetrieveResultsParams = CrawlRetrieveResultsParams.none(),
        ): HttpResponseFor<CrawlRetrieveResultsResponse> =
            retrieveResults(taskId, params, RequestOptions.none())

        /** @see retrieveResults */
        @MustBeClosed
        fun retrieveResults(
            params: CrawlRetrieveResultsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CrawlRetrieveResultsResponse>

        /** @see retrieveResults */
        @MustBeClosed
        fun retrieveResults(
            params: CrawlRetrieveResultsParams
        ): HttpResponseFor<CrawlRetrieveResultsResponse> =
            retrieveResults(params, RequestOptions.none())

        /** @see retrieveResults */
        @MustBeClosed
        fun retrieveResults(
            taskId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CrawlRetrieveResultsResponse> =
            retrieveResults(taskId, CrawlRetrieveResultsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /crawl`, but is otherwise the same as
         * [CrawlService.start].
         */
        @MustBeClosed
        fun start(params: CrawlStartParams): HttpResponseFor<CrawlStartResponse> =
            start(params, RequestOptions.none())

        /** @see start */
        @MustBeClosed
        fun start(
            params: CrawlStartParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CrawlStartResponse>
    }
}
