// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.async

import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.models.credits.CreditRetrieveParams
import com.scrapegraphai.api.models.credits.CreditRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface CreditServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CreditServiceAsync

    /** Retrieve the current credit balance and usage for the authenticated user */
    fun retrieve(): CompletableFuture<CreditRetrieveResponse> =
        retrieve(CreditRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        params: CreditRetrieveParams = CreditRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CreditRetrieveResponse>

    /** @see retrieve */
    fun retrieve(
        params: CreditRetrieveParams = CreditRetrieveParams.none()
    ): CompletableFuture<CreditRetrieveResponse> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(requestOptions: RequestOptions): CompletableFuture<CreditRetrieveResponse> =
        retrieve(CreditRetrieveParams.none(), requestOptions)

    /**
     * A view of [CreditServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CreditServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /credits`, but is otherwise the same as
         * [CreditServiceAsync.retrieve].
         */
        fun retrieve(): CompletableFuture<HttpResponseFor<CreditRetrieveResponse>> =
            retrieve(CreditRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            params: CreditRetrieveParams = CreditRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CreditRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: CreditRetrieveParams = CreditRetrieveParams.none()
        ): CompletableFuture<HttpResponseFor<CreditRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<CreditRetrieveResponse>> =
            retrieve(CreditRetrieveParams.none(), requestOptions)
    }
}
