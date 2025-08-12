// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.models.feedback.FeedbackSubmitParams
import com.scrapegraphai.api.models.feedback.FeedbackSubmitResponse
import java.util.function.Consumer

interface FeedbackService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FeedbackService

    /** Submit feedback for a specific request */
    fun submit(params: FeedbackSubmitParams): FeedbackSubmitResponse =
        submit(params, RequestOptions.none())

    /** @see submit */
    fun submit(
        params: FeedbackSubmitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeedbackSubmitResponse

    /** A view of [FeedbackService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FeedbackService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /feedback`, but is otherwise the same as
         * [FeedbackService.submit].
         */
        @MustBeClosed
        fun submit(params: FeedbackSubmitParams): HttpResponseFor<FeedbackSubmitResponse> =
            submit(params, RequestOptions.none())

        /** @see submit */
        @MustBeClosed
        fun submit(
            params: FeedbackSubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeedbackSubmitResponse>
    }
}
