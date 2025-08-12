// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.async

import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.models.crawl.CrawlRetrieveResultsParams
import com.scrapegraphai.api.models.crawl.CrawlRetrieveResultsResponse
import com.scrapegraphai.api.models.crawl.CrawlStartParams
import com.scrapegraphai.api.models.crawl.CrawlStartResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface CrawlServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CrawlServiceAsync

    /** Retrieve the status and results of a crawling job */
    fun retrieveResults(taskId: String): CompletableFuture<CrawlRetrieveResultsResponse> =
        retrieveResults(taskId, CrawlRetrieveResultsParams.none())

    /** @see retrieveResults */
    fun retrieveResults(
        taskId: String,
        params: CrawlRetrieveResultsParams = CrawlRetrieveResultsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CrawlRetrieveResultsResponse> =
        retrieveResults(params.toBuilder().taskId(taskId).build(), requestOptions)

    /** @see retrieveResults */
    fun retrieveResults(
        taskId: String,
        params: CrawlRetrieveResultsParams = CrawlRetrieveResultsParams.none(),
    ): CompletableFuture<CrawlRetrieveResultsResponse> =
        retrieveResults(taskId, params, RequestOptions.none())

    /** @see retrieveResults */
    fun retrieveResults(
        params: CrawlRetrieveResultsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CrawlRetrieveResultsResponse>

    /** @see retrieveResults */
    fun retrieveResults(
        params: CrawlRetrieveResultsParams
    ): CompletableFuture<CrawlRetrieveResultsResponse> =
        retrieveResults(params, RequestOptions.none())

    /** @see retrieveResults */
    fun retrieveResults(
        taskId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<CrawlRetrieveResultsResponse> =
        retrieveResults(taskId, CrawlRetrieveResultsParams.none(), requestOptions)

    /**
     * Initiate comprehensive website crawling with sitemap support. Supports both AI extraction
     * mode and markdown conversion mode. Returns a task ID for async processing.
     */
    fun start(params: CrawlStartParams): CompletableFuture<CrawlStartResponse> =
        start(params, RequestOptions.none())

    /** @see start */
    fun start(
        params: CrawlStartParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CrawlStartResponse>

    /** A view of [CrawlServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CrawlServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /crawl/{task_id}`, but is otherwise the same as
         * [CrawlServiceAsync.retrieveResults].
         */
        fun retrieveResults(
            taskId: String
        ): CompletableFuture<HttpResponseFor<CrawlRetrieveResultsResponse>> =
            retrieveResults(taskId, CrawlRetrieveResultsParams.none())

        /** @see retrieveResults */
        fun retrieveResults(
            taskId: String,
            params: CrawlRetrieveResultsParams = CrawlRetrieveResultsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CrawlRetrieveResultsResponse>> =
            retrieveResults(params.toBuilder().taskId(taskId).build(), requestOptions)

        /** @see retrieveResults */
        fun retrieveResults(
            taskId: String,
            params: CrawlRetrieveResultsParams = CrawlRetrieveResultsParams.none(),
        ): CompletableFuture<HttpResponseFor<CrawlRetrieveResultsResponse>> =
            retrieveResults(taskId, params, RequestOptions.none())

        /** @see retrieveResults */
        fun retrieveResults(
            params: CrawlRetrieveResultsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CrawlRetrieveResultsResponse>>

        /** @see retrieveResults */
        fun retrieveResults(
            params: CrawlRetrieveResultsParams
        ): CompletableFuture<HttpResponseFor<CrawlRetrieveResultsResponse>> =
            retrieveResults(params, RequestOptions.none())

        /** @see retrieveResults */
        fun retrieveResults(
            taskId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CrawlRetrieveResultsResponse>> =
            retrieveResults(taskId, CrawlRetrieveResultsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /crawl`, but is otherwise the same as
         * [CrawlServiceAsync.start].
         */
        fun start(
            params: CrawlStartParams
        ): CompletableFuture<HttpResponseFor<CrawlStartResponse>> =
            start(params, RequestOptions.none())

        /** @see start */
        fun start(
            params: CrawlStartParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CrawlStartResponse>>
    }
}
