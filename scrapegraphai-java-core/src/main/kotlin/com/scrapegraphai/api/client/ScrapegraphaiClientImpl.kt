// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.client

import com.scrapegraphai.api.core.ClientOptions
import com.scrapegraphai.api.core.getPackageVersion
import com.scrapegraphai.api.services.blocking.CrawlService
import com.scrapegraphai.api.services.blocking.CrawlServiceImpl
import com.scrapegraphai.api.services.blocking.CreditService
import com.scrapegraphai.api.services.blocking.CreditServiceImpl
import com.scrapegraphai.api.services.blocking.FeedbackService
import com.scrapegraphai.api.services.blocking.FeedbackServiceImpl
import com.scrapegraphai.api.services.blocking.GenerateSchemaService
import com.scrapegraphai.api.services.blocking.GenerateSchemaServiceImpl
import com.scrapegraphai.api.services.blocking.HealthzService
import com.scrapegraphai.api.services.blocking.HealthzServiceImpl
import com.scrapegraphai.api.services.blocking.MarkdownifyService
import com.scrapegraphai.api.services.blocking.MarkdownifyServiceImpl
import com.scrapegraphai.api.services.blocking.SearchscraperService
import com.scrapegraphai.api.services.blocking.SearchscraperServiceImpl
import com.scrapegraphai.api.services.blocking.SmartscraperService
import com.scrapegraphai.api.services.blocking.SmartscraperServiceImpl
import com.scrapegraphai.api.services.blocking.ValidateService
import com.scrapegraphai.api.services.blocking.ValidateServiceImpl
import java.util.function.Consumer

class ScrapegraphaiClientImpl(private val clientOptions: ClientOptions) : ScrapegraphaiClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: ScrapegraphaiClientAsync by lazy {
        ScrapegraphaiClientAsyncImpl(clientOptions)
    }

    private val withRawResponse: ScrapegraphaiClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val smartscraper: SmartscraperService by lazy {
        SmartscraperServiceImpl(clientOptionsWithUserAgent)
    }

    private val markdownify: MarkdownifyService by lazy {
        MarkdownifyServiceImpl(clientOptionsWithUserAgent)
    }

    private val searchscraper: SearchscraperService by lazy {
        SearchscraperServiceImpl(clientOptionsWithUserAgent)
    }

    private val generateSchema: GenerateSchemaService by lazy {
        GenerateSchemaServiceImpl(clientOptionsWithUserAgent)
    }

    private val crawl: CrawlService by lazy { CrawlServiceImpl(clientOptionsWithUserAgent) }

    private val credits: CreditService by lazy { CreditServiceImpl(clientOptionsWithUserAgent) }

    private val validate: ValidateService by lazy {
        ValidateServiceImpl(clientOptionsWithUserAgent)
    }

    private val feedback: FeedbackService by lazy {
        FeedbackServiceImpl(clientOptionsWithUserAgent)
    }

    private val healthz: HealthzService by lazy { HealthzServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): ScrapegraphaiClientAsync = async

    override fun withRawResponse(): ScrapegraphaiClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ScrapegraphaiClient =
        ScrapegraphaiClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun smartscraper(): SmartscraperService = smartscraper

    override fun markdownify(): MarkdownifyService = markdownify

    override fun searchscraper(): SearchscraperService = searchscraper

    override fun generateSchema(): GenerateSchemaService = generateSchema

    override fun crawl(): CrawlService = crawl

    override fun credits(): CreditService = credits

    override fun validate(): ValidateService = validate

    override fun feedback(): FeedbackService = feedback

    override fun healthz(): HealthzService = healthz

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ScrapegraphaiClient.WithRawResponse {

        private val smartscraper: SmartscraperService.WithRawResponse by lazy {
            SmartscraperServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val markdownify: MarkdownifyService.WithRawResponse by lazy {
            MarkdownifyServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val searchscraper: SearchscraperService.WithRawResponse by lazy {
            SearchscraperServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val generateSchema: GenerateSchemaService.WithRawResponse by lazy {
            GenerateSchemaServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val crawl: CrawlService.WithRawResponse by lazy {
            CrawlServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val credits: CreditService.WithRawResponse by lazy {
            CreditServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val validate: ValidateService.WithRawResponse by lazy {
            ValidateServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val feedback: FeedbackService.WithRawResponse by lazy {
            FeedbackServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val healthz: HealthzService.WithRawResponse by lazy {
            HealthzServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ScrapegraphaiClient.WithRawResponse =
            ScrapegraphaiClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun smartscraper(): SmartscraperService.WithRawResponse = smartscraper

        override fun markdownify(): MarkdownifyService.WithRawResponse = markdownify

        override fun searchscraper(): SearchscraperService.WithRawResponse = searchscraper

        override fun generateSchema(): GenerateSchemaService.WithRawResponse = generateSchema

        override fun crawl(): CrawlService.WithRawResponse = crawl

        override fun credits(): CreditService.WithRawResponse = credits

        override fun validate(): ValidateService.WithRawResponse = validate

        override fun feedback(): FeedbackService.WithRawResponse = feedback

        override fun healthz(): HealthzService.WithRawResponse = healthz
    }
}
