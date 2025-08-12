// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.async

import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.models.validate.ValidateApiKeyParams
import com.scrapegraphai.api.models.validate.ValidateApiKeyResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ValidateServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ValidateServiceAsync

    /** Validate the API key and retrieve associated user email */
    fun apiKey(): CompletableFuture<ValidateApiKeyResponse> = apiKey(ValidateApiKeyParams.none())

    /** @see apiKey */
    fun apiKey(
        params: ValidateApiKeyParams = ValidateApiKeyParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ValidateApiKeyResponse>

    /** @see apiKey */
    fun apiKey(
        params: ValidateApiKeyParams = ValidateApiKeyParams.none()
    ): CompletableFuture<ValidateApiKeyResponse> = apiKey(params, RequestOptions.none())

    /** @see apiKey */
    fun apiKey(requestOptions: RequestOptions): CompletableFuture<ValidateApiKeyResponse> =
        apiKey(ValidateApiKeyParams.none(), requestOptions)

    /**
     * A view of [ValidateServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ValidateServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /validate`, but is otherwise the same as
         * [ValidateServiceAsync.apiKey].
         */
        fun apiKey(): CompletableFuture<HttpResponseFor<ValidateApiKeyResponse>> =
            apiKey(ValidateApiKeyParams.none())

        /** @see apiKey */
        fun apiKey(
            params: ValidateApiKeyParams = ValidateApiKeyParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ValidateApiKeyResponse>>

        /** @see apiKey */
        fun apiKey(
            params: ValidateApiKeyParams = ValidateApiKeyParams.none()
        ): CompletableFuture<HttpResponseFor<ValidateApiKeyResponse>> =
            apiKey(params, RequestOptions.none())

        /** @see apiKey */
        fun apiKey(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ValidateApiKeyResponse>> =
            apiKey(ValidateApiKeyParams.none(), requestOptions)
    }
}
