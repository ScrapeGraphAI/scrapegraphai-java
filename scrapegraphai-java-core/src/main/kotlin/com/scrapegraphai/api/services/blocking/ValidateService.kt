// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.models.validate.ValidateApiKeyParams
import com.scrapegraphai.api.models.validate.ValidateApiKeyResponse
import java.util.function.Consumer

interface ValidateService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ValidateService

    /** Validate the API key and retrieve associated user email */
    fun apiKey(): ValidateApiKeyResponse = apiKey(ValidateApiKeyParams.none())

    /** @see apiKey */
    fun apiKey(
        params: ValidateApiKeyParams = ValidateApiKeyParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ValidateApiKeyResponse

    /** @see apiKey */
    fun apiKey(params: ValidateApiKeyParams = ValidateApiKeyParams.none()): ValidateApiKeyResponse =
        apiKey(params, RequestOptions.none())

    /** @see apiKey */
    fun apiKey(requestOptions: RequestOptions): ValidateApiKeyResponse =
        apiKey(ValidateApiKeyParams.none(), requestOptions)

    /** A view of [ValidateService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ValidateService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /validate`, but is otherwise the same as
         * [ValidateService.apiKey].
         */
        @MustBeClosed
        fun apiKey(): HttpResponseFor<ValidateApiKeyResponse> = apiKey(ValidateApiKeyParams.none())

        /** @see apiKey */
        @MustBeClosed
        fun apiKey(
            params: ValidateApiKeyParams = ValidateApiKeyParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ValidateApiKeyResponse>

        /** @see apiKey */
        @MustBeClosed
        fun apiKey(
            params: ValidateApiKeyParams = ValidateApiKeyParams.none()
        ): HttpResponseFor<ValidateApiKeyResponse> = apiKey(params, RequestOptions.none())

        /** @see apiKey */
        @MustBeClosed
        fun apiKey(requestOptions: RequestOptions): HttpResponseFor<ValidateApiKeyResponse> =
            apiKey(ValidateApiKeyParams.none(), requestOptions)
    }
}
