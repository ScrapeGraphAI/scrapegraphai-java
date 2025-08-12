// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.async

import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.models.feedback.FeedbackSubmitParams
import com.scrapegraphai.api.models.feedback.FeedbackSubmitResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface FeedbackServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FeedbackServiceAsync

    /** Submit feedback for a specific request */
    fun submit(params: FeedbackSubmitParams): CompletableFuture<FeedbackSubmitResponse> =
        submit(params, RequestOptions.none())

    /** @see submit */
    fun submit(
        params: FeedbackSubmitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FeedbackSubmitResponse>

    /**
     * A view of [FeedbackServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FeedbackServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /feedback`, but is otherwise the same as
         * [FeedbackServiceAsync.submit].
         */
        fun submit(
            params: FeedbackSubmitParams
        ): CompletableFuture<HttpResponseFor<FeedbackSubmitResponse>> =
            submit(params, RequestOptions.none())

        /** @see submit */
        fun submit(
            params: FeedbackSubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FeedbackSubmitResponse>>
    }
}
