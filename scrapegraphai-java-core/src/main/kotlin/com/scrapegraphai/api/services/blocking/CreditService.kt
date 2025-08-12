// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.RequestOptions
import com.scrapegraphai.api.core.http.HttpResponseFor
import com.scrapegraphai.api.models.credits.CreditRetrieveParams
import com.scrapegraphai.api.models.credits.CreditRetrieveResponse
import java.util.function.Consumer

interface CreditService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CreditService

    /** Retrieve the current credit balance and usage for the authenticated user */
    fun retrieve(): CreditRetrieveResponse = retrieve(CreditRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        params: CreditRetrieveParams = CreditRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CreditRetrieveResponse

    /** @see retrieve */
    fun retrieve(
        params: CreditRetrieveParams = CreditRetrieveParams.none()
    ): CreditRetrieveResponse = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(requestOptions: RequestOptions): CreditRetrieveResponse =
        retrieve(CreditRetrieveParams.none(), requestOptions)

    /** A view of [CreditService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): CreditService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /credits`, but is otherwise the same as
         * [CreditService.retrieve].
         */
        @MustBeClosed
        fun retrieve(): HttpResponseFor<CreditRetrieveResponse> =
            retrieve(CreditRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: CreditRetrieveParams = CreditRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CreditRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: CreditRetrieveParams = CreditRetrieveParams.none()
        ): HttpResponseFor<CreditRetrieveResponse> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(requestOptions: RequestOptions): HttpResponseFor<CreditRetrieveResponse> =
            retrieve(CreditRetrieveParams.none(), requestOptions)
    }
}
