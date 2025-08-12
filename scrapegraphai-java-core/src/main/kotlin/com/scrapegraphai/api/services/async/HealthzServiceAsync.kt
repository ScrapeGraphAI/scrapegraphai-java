// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.async

import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.models.healthz.HealthzCheckParams
import com.scrapegraphai.api.models.healthz.HealthzCheckResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface HealthzServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): HealthzServiceAsync

    /** Check the health status of the service */
    fun check(): CompletableFuture<HealthzCheckResponse> = check(HealthzCheckParams.none())

    /** @see check */
    fun check(
        params: HealthzCheckParams = HealthzCheckParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HealthzCheckResponse>

    /** @see check */
    fun check(
        params: HealthzCheckParams = HealthzCheckParams.none()
    ): CompletableFuture<HealthzCheckResponse> = check(params, RequestOptions.none())

    /** @see check */
    fun check(requestOptions: RequestOptions): CompletableFuture<HealthzCheckResponse> =
        check(HealthzCheckParams.none(), requestOptions)

    /**
     * A view of [HealthzServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): HealthzServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /healthz`, but is otherwise the same as
         * [HealthzServiceAsync.check].
         */
        fun check(): CompletableFuture<HttpResponseFor<HealthzCheckResponse>> =
            check(HealthzCheckParams.none())

        /** @see check */
        fun check(
            params: HealthzCheckParams = HealthzCheckParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<HealthzCheckResponse>>

        /** @see check */
        fun check(
            params: HealthzCheckParams = HealthzCheckParams.none()
        ): CompletableFuture<HttpResponseFor<HealthzCheckResponse>> =
            check(params, RequestOptions.none())

        /** @see check */
        fun check(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<HealthzCheckResponse>> =
            check(HealthzCheckParams.none(), requestOptions)
    }
}
