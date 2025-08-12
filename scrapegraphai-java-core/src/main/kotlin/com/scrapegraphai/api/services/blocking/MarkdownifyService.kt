// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.models.markdownify.CompletedMarkdownify
import com.scrapegraphai.api.models.markdownify.MarkdownifyConvertParams
import com.scrapegraphai.api.models.markdownify.MarkdownifyRetrieveStatusParams
import com.scrapegraphai.api.models.markdownify.MarkdownifyRetrieveStatusResponse
import java.util.function.Consumer

interface MarkdownifyService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MarkdownifyService

    /** Convert web page content to clean Markdown format */
    fun convert(params: MarkdownifyConvertParams): CompletedMarkdownify =
        convert(params, RequestOptions.none())

    /** @see convert */
    fun convert(
        params: MarkdownifyConvertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletedMarkdownify

    /** Retrieve the status and results of a markdown conversion */
    fun retrieveStatus(requestId: String): MarkdownifyRetrieveStatusResponse =
        retrieveStatus(requestId, MarkdownifyRetrieveStatusParams.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        requestId: String,
        params: MarkdownifyRetrieveStatusParams = MarkdownifyRetrieveStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MarkdownifyRetrieveStatusResponse =
        retrieveStatus(params.toBuilder().requestId(requestId).build(), requestOptions)

    /** @see retrieveStatus */
    fun retrieveStatus(
        requestId: String,
        params: MarkdownifyRetrieveStatusParams = MarkdownifyRetrieveStatusParams.none(),
    ): MarkdownifyRetrieveStatusResponse = retrieveStatus(requestId, params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        params: MarkdownifyRetrieveStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MarkdownifyRetrieveStatusResponse

    /** @see retrieveStatus */
    fun retrieveStatus(params: MarkdownifyRetrieveStatusParams): MarkdownifyRetrieveStatusResponse =
        retrieveStatus(params, RequestOptions.none())

    /** @see retrieveStatus */
    fun retrieveStatus(
        requestId: String,
        requestOptions: RequestOptions,
    ): MarkdownifyRetrieveStatusResponse =
        retrieveStatus(requestId, MarkdownifyRetrieveStatusParams.none(), requestOptions)

    /**
     * A view of [MarkdownifyService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MarkdownifyService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /markdownify`, but is otherwise the same as
         * [MarkdownifyService.convert].
         */
        @MustBeClosed
        fun convert(params: MarkdownifyConvertParams): HttpResponseFor<CompletedMarkdownify> =
            convert(params, RequestOptions.none())

        /** @see convert */
        @MustBeClosed
        fun convert(
            params: MarkdownifyConvertParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CompletedMarkdownify>

        /**
         * Returns a raw HTTP response for `get /markdownify/{request_id}`, but is otherwise the
         * same as [MarkdownifyService.retrieveStatus].
         */
        @MustBeClosed
        fun retrieveStatus(requestId: String): HttpResponseFor<MarkdownifyRetrieveStatusResponse> =
            retrieveStatus(requestId, MarkdownifyRetrieveStatusParams.none())

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            requestId: String,
            params: MarkdownifyRetrieveStatusParams = MarkdownifyRetrieveStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MarkdownifyRetrieveStatusResponse> =
            retrieveStatus(params.toBuilder().requestId(requestId).build(), requestOptions)

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            requestId: String,
            params: MarkdownifyRetrieveStatusParams = MarkdownifyRetrieveStatusParams.none(),
        ): HttpResponseFor<MarkdownifyRetrieveStatusResponse> =
            retrieveStatus(requestId, params, RequestOptions.none())

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            params: MarkdownifyRetrieveStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MarkdownifyRetrieveStatusResponse>

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            params: MarkdownifyRetrieveStatusParams
        ): HttpResponseFor<MarkdownifyRetrieveStatusResponse> =
            retrieveStatus(params, RequestOptions.none())

        /** @see retrieveStatus */
        @MustBeClosed
        fun retrieveStatus(
            requestId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MarkdownifyRetrieveStatusResponse> =
            retrieveStatus(requestId, MarkdownifyRetrieveStatusParams.none(), requestOptions)
    }
}
