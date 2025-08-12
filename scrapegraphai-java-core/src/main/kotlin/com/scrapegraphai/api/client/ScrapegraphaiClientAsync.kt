// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.client

import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.services.async.CrawlServiceAsync
import com.scrapegraphai.api.services.async.CreditServiceAsync
import com.scrapegraphai.api.services.async.FeedbackServiceAsync
import com.scrapegraphai.api.services.async.GenerateSchemaServiceAsync
import com.scrapegraphai.api.services.async.HealthzServiceAsync
import com.scrapegraphai.api.services.async.MarkdownifyServiceAsync
import com.scrapegraphai.api.services.async.SearchscraperServiceAsync
import com.scrapegraphai.api.services.async.SmartscraperServiceAsync
import com.scrapegraphai.api.services.async.ValidateServiceAsync
import java.util.function.Consumer

/**
 * A client for interacting with the Scrapegraphai REST API asynchronously. You can also switch to
 * synchronous execution via the [sync] method.
 *
 * This client performs best when you create a single instance and reuse it for all interactions
 * with the REST API. This is because each client holds its own connection pool and thread pools.
 * Reusing connections and threads reduces latency and saves memory. The client also handles rate
 * limiting per client. This means that creating and using multiple instances at the same time will
 * not respect rate limits.
 *
 * The threads and connections that are held will be released automatically if they remain idle. But
 * if you are writing an application that needs to aggressively release unused resources, then you
 * may call [close].
 */
interface ScrapegraphaiClientAsync {

    /**
     * Returns a version of this client that uses synchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun sync(): ScrapegraphaiClient

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ScrapegraphaiClientAsync

    fun smartscraper(): SmartscraperServiceAsync

    fun markdownify(): MarkdownifyServiceAsync

    fun searchscraper(): SearchscraperServiceAsync

    fun generateSchema(): GenerateSchemaServiceAsync

    fun crawl(): CrawlServiceAsync

    fun credits(): CreditServiceAsync

    fun validate(): ValidateServiceAsync

    fun feedback(): FeedbackServiceAsync

    fun healthz(): HealthzServiceAsync

    /**
     * Closes this client, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client is long-lived and
     * usually should not be synchronously closed via try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default HTTP client
     * automatically releases threads and connections if they remain idle, but if you are writing an
     * application that needs to aggressively release unused resources, then you may call this
     * method.
     */
    fun close()

    /**
     * A view of [ScrapegraphaiClientAsync] that provides access to raw HTTP responses for each
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
        ): ScrapegraphaiClientAsync.WithRawResponse

        fun smartscraper(): SmartscraperServiceAsync.WithRawResponse

        fun markdownify(): MarkdownifyServiceAsync.WithRawResponse

        fun searchscraper(): SearchscraperServiceAsync.WithRawResponse

        fun generateSchema(): GenerateSchemaServiceAsync.WithRawResponse

        fun crawl(): CrawlServiceAsync.WithRawResponse

        fun credits(): CreditServiceAsync.WithRawResponse

        fun validate(): ValidateServiceAsync.WithRawResponse

        fun feedback(): FeedbackServiceAsync.WithRawResponse

        fun healthz(): HealthzServiceAsync.WithRawResponse
    }
}
