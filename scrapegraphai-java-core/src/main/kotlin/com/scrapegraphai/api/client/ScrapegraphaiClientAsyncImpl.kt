// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.client

import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.getPackageVersion
import com.scrapegraphai.api.services.async.CrawlServiceAsync
import com.scrapegraphai.api.services.async.CrawlServiceAsyncImpl
import com.scrapegraphai.api.services.async.CreditServiceAsync
import com.scrapegraphai.api.services.async.CreditServiceAsyncImpl
import com.scrapegraphai.api.services.async.FeedbackServiceAsync
import com.scrapegraphai.api.services.async.FeedbackServiceAsyncImpl
import com.scrapegraphai.api.services.async.GenerateSchemaServiceAsync
import com.scrapegraphai.api.services.async.GenerateSchemaServiceAsyncImpl
import com.scrapegraphai.api.services.async.HealthzServiceAsync
import com.scrapegraphai.api.services.async.HealthzServiceAsyncImpl
import com.scrapegraphai.api.services.async.MarkdownifyServiceAsync
import com.scrapegraphai.api.services.async.MarkdownifyServiceAsyncImpl
import com.scrapegraphai.api.services.async.SearchscraperServiceAsync
import com.scrapegraphai.api.services.async.SearchscraperServiceAsyncImpl
import com.scrapegraphai.api.services.async.SmartscraperServiceAsync
import com.scrapegraphai.api.services.async.SmartscraperServiceAsyncImpl
import com.scrapegraphai.api.services.async.ValidateServiceAsync
import com.scrapegraphai.api.services.async.ValidateServiceAsyncImpl
import java.util.function.Consumer

class ScrapegraphaiClientAsyncImpl(private val clientOptions: ClientOptions) :
    ScrapegraphaiClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: ScrapegraphaiClient by lazy { ScrapegraphaiClientImpl(clientOptions) }

    private val withRawResponse: ScrapegraphaiClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val smartscraper: SmartscraperServiceAsync by lazy {
        SmartscraperServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val markdownify: MarkdownifyServiceAsync by lazy {
        MarkdownifyServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val searchscraper: SearchscraperServiceAsync by lazy {
        SearchscraperServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val generateSchema: GenerateSchemaServiceAsync by lazy {
        GenerateSchemaServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val crawl: CrawlServiceAsync by lazy {
        CrawlServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val credits: CreditServiceAsync by lazy {
        CreditServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val validate: ValidateServiceAsync by lazy {
        ValidateServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val feedback: FeedbackServiceAsync by lazy {
        FeedbackServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val healthz: HealthzServiceAsync by lazy {
        HealthzServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): ScrapegraphaiClient = sync

    override fun withRawResponse(): ScrapegraphaiClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ScrapegraphaiClientAsync =
        ScrapegraphaiClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun smartscraper(): SmartscraperServiceAsync = smartscraper

    override fun markdownify(): MarkdownifyServiceAsync = markdownify

    override fun searchscraper(): SearchscraperServiceAsync = searchscraper

    override fun generateSchema(): GenerateSchemaServiceAsync = generateSchema

    override fun crawl(): CrawlServiceAsync = crawl

    override fun credits(): CreditServiceAsync = credits

    override fun validate(): ValidateServiceAsync = validate

    override fun feedback(): FeedbackServiceAsync = feedback

    override fun healthz(): HealthzServiceAsync = healthz

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ScrapegraphaiClientAsync.WithRawResponse {

        private val smartscraper: SmartscraperServiceAsync.WithRawResponse by lazy {
            SmartscraperServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val markdownify: MarkdownifyServiceAsync.WithRawResponse by lazy {
            MarkdownifyServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val searchscraper: SearchscraperServiceAsync.WithRawResponse by lazy {
            SearchscraperServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val generateSchema: GenerateSchemaServiceAsync.WithRawResponse by lazy {
            GenerateSchemaServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val crawl: CrawlServiceAsync.WithRawResponse by lazy {
            CrawlServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val credits: CreditServiceAsync.WithRawResponse by lazy {
            CreditServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val validate: ValidateServiceAsync.WithRawResponse by lazy {
            ValidateServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val feedback: FeedbackServiceAsync.WithRawResponse by lazy {
            FeedbackServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val healthz: HealthzServiceAsync.WithRawResponse by lazy {
            HealthzServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ScrapegraphaiClientAsync.WithRawResponse =
            ScrapegraphaiClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun smartscraper(): SmartscraperServiceAsync.WithRawResponse = smartscraper

        override fun markdownify(): MarkdownifyServiceAsync.WithRawResponse = markdownify

        override fun searchscraper(): SearchscraperServiceAsync.WithRawResponse = searchscraper

        override fun generateSchema(): GenerateSchemaServiceAsync.WithRawResponse = generateSchema

        override fun crawl(): CrawlServiceAsync.WithRawResponse = crawl

        override fun credits(): CreditServiceAsync.WithRawResponse = credits

        override fun validate(): ValidateServiceAsync.WithRawResponse = validate

        override fun feedback(): FeedbackServiceAsync.WithRawResponse = feedback

        override fun healthz(): HealthzServiceAsync.WithRawResponse = healthz
    }
}
