// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.models.healthz.HealthzCheckParams
import com.scrapegraphai.api.models.healthz.HealthzCheckResponse
import java.util.function.Consumer

interface HealthzService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): HealthzService

    /** Check the health status of the service */
    fun check(): HealthzCheckResponse = check(HealthzCheckParams.none())

    /** @see check */
    fun check(
        params: HealthzCheckParams = HealthzCheckParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HealthzCheckResponse

    /** @see check */
    fun check(params: HealthzCheckParams = HealthzCheckParams.none()): HealthzCheckResponse =
        check(params, RequestOptions.none())

    /** @see check */
    fun check(requestOptions: RequestOptions): HealthzCheckResponse =
        check(HealthzCheckParams.none(), requestOptions)

    /** A view of [HealthzService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): HealthzService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /healthz`, but is otherwise the same as
         * [HealthzService.check].
         */
        @MustBeClosed
        fun check(): HttpResponseFor<HealthzCheckResponse> = check(HealthzCheckParams.none())

        /** @see check */
        @MustBeClosed
        fun check(
            params: HealthzCheckParams = HealthzCheckParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<HealthzCheckResponse>

        /** @see check */
        @MustBeClosed
        fun check(
            params: HealthzCheckParams = HealthzCheckParams.none()
        ): HttpResponseFor<HealthzCheckResponse> = check(params, RequestOptions.none())

        /** @see check */
        @MustBeClosed
        fun check(requestOptions: RequestOptions): HttpResponseFor<HealthzCheckResponse> =
            check(HealthzCheckParams.none(), requestOptions)
    }
}
