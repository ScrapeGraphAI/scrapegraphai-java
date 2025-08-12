// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.async

import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.models.markdownify.CompletedMarkdownify
import com.scrapegraphai.api.models.markdownify.MarkdownifyConvertParams
import com.scrapegraphai.api.models.markdownify.MarkdownifyRetrieveStatusParams
import com.scrapegraphai.api.models.markdownify.MarkdownifyRetrieveStatusResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface MarkdownifyServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MarkdownifyServiceAsync

    /** Convert web page content to clean Markdown format */
    fun convert(params: MarkdownifyConvertParams): CompletableFuture<CompletedMarkdownify> =
        convert(params, RequestOptions.none())

    /** @see convert */
    fun convert(
        params: MarkdownifyConvertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CompletedMarkdownify>

    /** Retrieve the status and results of a markdown conversion */
    fun retrieveStatus(requestId: String): CompletableFuture<MarkdownifyRetrieveStatusResponse> =
        retrieveStatus(requestId, MarkdownifyRetrieveStatusParams.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        requestId: String,
        params: MarkdownifyRetrieveStatusParams = MarkdownifyRetrieveStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MarkdownifyRetrieveStatusResponse> =
        retrieveStatus(params.toBuilder().requestId(requestId).build(), requestOptions)

    /** @see retrieveStatus */
    fun retrieveStatus(
        requestId: String,
        params: MarkdownifyRetrieveStatusParams = MarkdownifyRetrieveStatusParams.none(),
    ): CompletableFuture<MarkdownifyRetrieveStatusResponse> =
        retrieveStatus(requestId, params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        params: MarkdownifyRetrieveStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MarkdownifyRetrieveStatusResponse>

    /** @see retrieveStatus */
    fun retrieveStatus(
        params: MarkdownifyRetrieveStatusParams
    ): CompletableFuture<MarkdownifyRetrieveStatusResponse> =
        retrieveStatus(params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        requestId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MarkdownifyRetrieveStatusResponse> =
        retrieveStatus(requestId, MarkdownifyRetrieveStatusParams.none(), requestOptions)

    /**
     * A view of [MarkdownifyServiceAsync] that provides access to raw HTTP responses for each
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
        ): MarkdownifyServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /markdownify`, but is otherwise the same as
         * [MarkdownifyServiceAsync.convert].
         */
        fun convert(
            params: MarkdownifyConvertParams
        ): CompletableFuture<HttpResponseFor<CompletedMarkdownify>> =
            convert(params, RequestOptions.none())

        /** @see convert */
        fun convert(
            params: MarkdownifyConvertParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CompletedMarkdownify>>

        /**
         * Returns a raw HTTP response for `get /markdownify/{request_id}`, but is otherwise the
         * same as [MarkdownifyServiceAsync.retrieveStatus].
         */
        fun retrieveStatus(
            requestId: String
        ): CompletableFuture<HttpResponseFor<MarkdownifyRetrieveStatusResponse>> =
            retrieveStatus(requestId, MarkdownifyRetrieveStatusParams.none())

        /** @see retrieveStatus */
        fun retrieveStatus(
            requestId: String,
            params: MarkdownifyRetrieveStatusParams = MarkdownifyRetrieveStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MarkdownifyRetrieveStatusResponse>> =
            retrieveStatus(params.toBuilder().requestId(requestId).build(), requestOptions)

        /** @see retrieveStatus */
        fun retrieveStatus(
            requestId: String,
            params: MarkdownifyRetrieveStatusParams = MarkdownifyRetrieveStatusParams.none(),
        ): CompletableFuture<HttpResponseFor<MarkdownifyRetrieveStatusResponse>> =
            retrieveStatus(requestId, params, RequestOptions.none())

        /** @see retrieveStatus */
        fun retrieveStatus(
            params: MarkdownifyRetrieveStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MarkdownifyRetrieveStatusResponse>>

        /** @see retrieveStatus */
        fun retrieveStatus(
            params: MarkdownifyRetrieveStatusParams
        ): CompletableFuture<HttpResponseFor<MarkdownifyRetrieveStatusResponse>> =
            retrieveStatus(params, RequestOptions.none())

        /** @see retrieveStatus */
        fun retrieveStatus(
            requestId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MarkdownifyRetrieveStatusResponse>> =
            retrieveStatus(requestId, MarkdownifyRetrieveStatusParams.none(), requestOptions)
    }
}
