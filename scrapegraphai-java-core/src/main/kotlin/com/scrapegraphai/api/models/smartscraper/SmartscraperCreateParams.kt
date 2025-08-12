// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.smartscraper

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.scrapegraphai.api.core.ExcludeMissing
import com.scrapegraphai.api.core.JsonField
import com.scrapegraphai.api.core.JsonMissing
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.Params
import com.scrapegraphai.api.core.checkKnown
import com.scrapegraphai.api.core.checkRequired
import com.scrapegraphai.api.core.http.Headers
import com.scrapegraphai.api.core.http.QueryParams
import com.scrapegraphai.api.core.toImmutable
import com.scrapegraphai.api.errors.ScrapegraphaiInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Main scraping endpoint with LLM-powered content analysis. Supports various fetching providers,
 * infinite scrolling, pagination, and custom output schemas.
 */
class SmartscraperCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Extraction instruction for the LLM
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun userPrompt(): String = body.userPrompt()

    /**
     * Cookies to include in the request
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun cookies(): Optional<Cookies> = body.cookies()

    /**
     * HTTP headers to include in the request
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun headers(): Optional<Headers> = body.headers()

    /**
     * Number of infinite scroll operations to perform
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun numberOfScrolls(): Optional<Long> = body.numberOfScrolls()

    /** JSON schema defining the expected output structure */
    fun _outputSchema(): JsonValue = body._outputSchema()

    /**
     * Enable heavy JavaScript rendering
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun renderHeavyJs(): Optional<Boolean> = body.renderHeavyJs()

    /**
     * Website interaction steps (e.g., clicking buttons)
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun steps(): Optional<List<String>> = body.steps()

    /**
     * Number of pages to process for pagination
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun totalPages(): Optional<Long> = body.totalPages()

    /**
     * HTML content to process (max 2MB, mutually exclusive with website_url)
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun websiteHtml(): Optional<String> = body.websiteHtml()

    /**
     * URL to scrape (mutually exclusive with website_html)
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun websiteUrl(): Optional<String> = body.websiteUrl()

    /**
     * Returns the raw JSON value of [userPrompt].
     *
     * Unlike [userPrompt], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _userPrompt(): JsonField<String> = body._userPrompt()

    /**
     * Returns the raw JSON value of [cookies].
     *
     * Unlike [cookies], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _cookies(): JsonField<Cookies> = body._cookies()

    /**
     * Returns the raw JSON value of [headers].
     *
     * Unlike [headers], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _headers_(): JsonField<Headers> = body._headers_()

    /**
     * Returns the raw JSON value of [numberOfScrolls].
     *
     * Unlike [numberOfScrolls], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _numberOfScrolls(): JsonField<Long> = body._numberOfScrolls()

    /**
     * Returns the raw JSON value of [renderHeavyJs].
     *
     * Unlike [renderHeavyJs], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _renderHeavyJs(): JsonField<Boolean> = body._renderHeavyJs()

    /**
     * Returns the raw JSON value of [steps].
     *
     * Unlike [steps], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _steps(): JsonField<List<String>> = body._steps()

    /**
     * Returns the raw JSON value of [totalPages].
     *
     * Unlike [totalPages], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _totalPages(): JsonField<Long> = body._totalPages()

    /**
     * Returns the raw JSON value of [websiteHtml].
     *
     * Unlike [websiteHtml], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _websiteHtml(): JsonField<String> = body._websiteHtml()

    /**
     * Returns the raw JSON value of [websiteUrl].
     *
     * Unlike [websiteUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _websiteUrl(): JsonField<String> = body._websiteUrl()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SmartscraperCreateParams].
         *
         * The following fields are required:
         * ```java
         * .userPrompt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SmartscraperCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(smartscraperCreateParams: SmartscraperCreateParams) = apply {
            body = smartscraperCreateParams.body.toBuilder()
            additionalHeaders = smartscraperCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = smartscraperCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [userPrompt]
         * - [cookies]
         * - [headers]
         * - [numberOfScrolls]
         * - [outputSchema]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Extraction instruction for the LLM */
        fun userPrompt(userPrompt: String) = apply { body.userPrompt(userPrompt) }

        /**
         * Sets [Builder.userPrompt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.userPrompt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun userPrompt(userPrompt: JsonField<String>) = apply { body.userPrompt(userPrompt) }

        /** Cookies to include in the request */
        fun cookies(cookies: Cookies) = apply { body.cookies(cookies) }

        /**
         * Sets [Builder.cookies] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cookies] with a well-typed [Cookies] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cookies(cookies: JsonField<Cookies>) = apply { body.cookies(cookies) }

        /** HTTP headers to include in the request */
        fun headers(headers: Headers) = apply { body.headers(headers) }

        /**
         * Sets [Builder.headers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.headers] with a well-typed [Headers] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun headers(headers: JsonField<Headers>) = apply { body.headers(headers) }

        /** Number of infinite scroll operations to perform */
        fun numberOfScrolls(numberOfScrolls: Long) = apply { body.numberOfScrolls(numberOfScrolls) }

        /**
         * Sets [Builder.numberOfScrolls] to an arbitrary JSON value.
         *
         * You should usually call [Builder.numberOfScrolls] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun numberOfScrolls(numberOfScrolls: JsonField<Long>) = apply {
            body.numberOfScrolls(numberOfScrolls)
        }

        /** JSON schema defining the expected output structure */
        fun outputSchema(outputSchema: JsonValue) = apply { body.outputSchema(outputSchema) }

        /** Enable heavy JavaScript rendering */
        fun renderHeavyJs(renderHeavyJs: Boolean) = apply { body.renderHeavyJs(renderHeavyJs) }

        /**
         * Sets [Builder.renderHeavyJs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.renderHeavyJs] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun renderHeavyJs(renderHeavyJs: JsonField<Boolean>) = apply {
            body.renderHeavyJs(renderHeavyJs)
        }

        /** Website interaction steps (e.g., clicking buttons) */
        fun steps(steps: List<String>) = apply { body.steps(steps) }

        /**
         * Sets [Builder.steps] to an arbitrary JSON value.
         *
         * You should usually call [Builder.steps] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun steps(steps: JsonField<List<String>>) = apply { body.steps(steps) }

        /**
         * Adds a single [String] to [steps].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addStep(step: String) = apply { body.addStep(step) }

        /** Number of pages to process for pagination */
        fun totalPages(totalPages: Long) = apply { body.totalPages(totalPages) }

        /**
         * Sets [Builder.totalPages] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalPages] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun totalPages(totalPages: JsonField<Long>) = apply { body.totalPages(totalPages) }

        /** HTML content to process (max 2MB, mutually exclusive with website_url) */
        fun websiteHtml(websiteHtml: String) = apply { body.websiteHtml(websiteHtml) }

        /**
         * Sets [Builder.websiteHtml] to an arbitrary JSON value.
         *
         * You should usually call [Builder.websiteHtml] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun websiteHtml(websiteHtml: JsonField<String>) = apply { body.websiteHtml(websiteHtml) }

        /** URL to scrape (mutually exclusive with website_html) */
        fun websiteUrl(websiteUrl: String) = apply { body.websiteUrl(websiteUrl) }

        /**
         * Sets [Builder.websiteUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.websiteUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun websiteUrl(websiteUrl: JsonField<String>) = apply { body.websiteUrl(websiteUrl) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [SmartscraperCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .userPrompt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SmartscraperCreateParams =
            SmartscraperCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val userPrompt: JsonField<String>,
        private val cookies: JsonField<Cookies>,
        private val headers: JsonField<Headers>,
        private val numberOfScrolls: JsonField<Long>,
        private val outputSchema: JsonValue,
        private val renderHeavyJs: JsonField<Boolean>,
        private val steps: JsonField<List<String>>,
        private val totalPages: JsonField<Long>,
        private val websiteHtml: JsonField<String>,
        private val websiteUrl: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("user_prompt")
            @ExcludeMissing
            userPrompt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cookies") @ExcludeMissing cookies: JsonField<Cookies> = JsonMissing.of(),
            @JsonProperty("headers") @ExcludeMissing headers: JsonField<Headers> = JsonMissing.of(),
            @JsonProperty("number_of_scrolls")
            @ExcludeMissing
            numberOfScrolls: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("output_schema")
            @ExcludeMissing
            outputSchema: JsonValue = JsonMissing.of(),
            @JsonProperty("render_heavy_js")
            @ExcludeMissing
            renderHeavyJs: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("steps")
            @ExcludeMissing
            steps: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("total_pages")
            @ExcludeMissing
            totalPages: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("website_html")
            @ExcludeMissing
            websiteHtml: JsonField<String> = JsonMissing.of(),
            @JsonProperty("website_url")
            @ExcludeMissing
            websiteUrl: JsonField<String> = JsonMissing.of(),
        ) : this(
            userPrompt,
            cookies,
            headers,
            numberOfScrolls,
            outputSchema,
            renderHeavyJs,
            steps,
            totalPages,
            websiteHtml,
            websiteUrl,
            mutableMapOf(),
        )

        /**
         * Extraction instruction for the LLM
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun userPrompt(): String = userPrompt.getRequired("user_prompt")

        /**
         * Cookies to include in the request
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun cookies(): Optional<Cookies> = cookies.getOptional("cookies")

        /**
         * HTTP headers to include in the request
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun headers(): Optional<Headers> = headers.getOptional("headers")

        /**
         * Number of infinite scroll operations to perform
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun numberOfScrolls(): Optional<Long> = numberOfScrolls.getOptional("number_of_scrolls")

        /** JSON schema defining the expected output structure */
        @JsonProperty("output_schema") @ExcludeMissing fun _outputSchema(): JsonValue = outputSchema

        /**
         * Enable heavy JavaScript rendering
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun renderHeavyJs(): Optional<Boolean> = renderHeavyJs.getOptional("render_heavy_js")

        /**
         * Website interaction steps (e.g., clicking buttons)
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun steps(): Optional<List<String>> = steps.getOptional("steps")

        /**
         * Number of pages to process for pagination
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun totalPages(): Optional<Long> = totalPages.getOptional("total_pages")

        /**
         * HTML content to process (max 2MB, mutually exclusive with website_url)
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun websiteHtml(): Optional<String> = websiteHtml.getOptional("website_html")

        /**
         * URL to scrape (mutually exclusive with website_html)
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun websiteUrl(): Optional<String> = websiteUrl.getOptional("website_url")

        /**
         * Returns the raw JSON value of [userPrompt].
         *
         * Unlike [userPrompt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("user_prompt")
        @ExcludeMissing
        fun _userPrompt(): JsonField<String> = userPrompt

        /**
         * Returns the raw JSON value of [cookies].
         *
         * Unlike [cookies], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cookies") @ExcludeMissing fun _cookies(): JsonField<Cookies> = cookies

        /**
         * Returns the raw JSON value of [headers].
         *
         * Unlike [headers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("headers") @ExcludeMissing fun _headers_(): JsonField<Headers> = headers

        /**
         * Returns the raw JSON value of [numberOfScrolls].
         *
         * Unlike [numberOfScrolls], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("number_of_scrolls")
        @ExcludeMissing
        fun _numberOfScrolls(): JsonField<Long> = numberOfScrolls

        /**
         * Returns the raw JSON value of [renderHeavyJs].
         *
         * Unlike [renderHeavyJs], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("render_heavy_js")
        @ExcludeMissing
        fun _renderHeavyJs(): JsonField<Boolean> = renderHeavyJs

        /**
         * Returns the raw JSON value of [steps].
         *
         * Unlike [steps], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("steps") @ExcludeMissing fun _steps(): JsonField<List<String>> = steps

        /**
         * Returns the raw JSON value of [totalPages].
         *
         * Unlike [totalPages], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("total_pages") @ExcludeMissing fun _totalPages(): JsonField<Long> = totalPages

        /**
         * Returns the raw JSON value of [websiteHtml].
         *
         * Unlike [websiteHtml], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("website_html")
        @ExcludeMissing
        fun _websiteHtml(): JsonField<String> = websiteHtml

        /**
         * Returns the raw JSON value of [websiteUrl].
         *
         * Unlike [websiteUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("website_url")
        @ExcludeMissing
        fun _websiteUrl(): JsonField<String> = websiteUrl

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .userPrompt()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var userPrompt: JsonField<String>? = null
            private var cookies: JsonField<Cookies> = JsonMissing.of()
            private var headers: JsonField<Headers> = JsonMissing.of()
            private var numberOfScrolls: JsonField<Long> = JsonMissing.of()
            private var outputSchema: JsonValue = JsonMissing.of()
            private var renderHeavyJs: JsonField<Boolean> = JsonMissing.of()
            private var steps: JsonField<MutableList<String>>? = null
            private var totalPages: JsonField<Long> = JsonMissing.of()
            private var websiteHtml: JsonField<String> = JsonMissing.of()
            private var websiteUrl: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                userPrompt = body.userPrompt
                cookies = body.cookies
                headers = body.headers
                numberOfScrolls = body.numberOfScrolls
                outputSchema = body.outputSchema
                renderHeavyJs = body.renderHeavyJs
                steps = body.steps.map { it.toMutableList() }
                totalPages = body.totalPages
                websiteHtml = body.websiteHtml
                websiteUrl = body.websiteUrl
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Extraction instruction for the LLM */
            fun userPrompt(userPrompt: String) = userPrompt(JsonField.of(userPrompt))

            /**
             * Sets [Builder.userPrompt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.userPrompt] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun userPrompt(userPrompt: JsonField<String>) = apply { this.userPrompt = userPrompt }

            /** Cookies to include in the request */
            fun cookies(cookies: Cookies) = cookies(JsonField.of(cookies))

            /**
             * Sets [Builder.cookies] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cookies] with a well-typed [Cookies] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cookies(cookies: JsonField<Cookies>) = apply { this.cookies = cookies }

            /** HTTP headers to include in the request */
            fun headers(headers: Headers) = headers(JsonField.of(headers))

            /**
             * Sets [Builder.headers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.headers] with a well-typed [Headers] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun headers(headers: JsonField<Headers>) = apply { this.headers = headers }

            /** Number of infinite scroll operations to perform */
            fun numberOfScrolls(numberOfScrolls: Long) =
                numberOfScrolls(JsonField.of(numberOfScrolls))

            /**
             * Sets [Builder.numberOfScrolls] to an arbitrary JSON value.
             *
             * You should usually call [Builder.numberOfScrolls] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun numberOfScrolls(numberOfScrolls: JsonField<Long>) = apply {
                this.numberOfScrolls = numberOfScrolls
            }

            /** JSON schema defining the expected output structure */
            fun outputSchema(outputSchema: JsonValue) = apply { this.outputSchema = outputSchema }

            /** Enable heavy JavaScript rendering */
            fun renderHeavyJs(renderHeavyJs: Boolean) = renderHeavyJs(JsonField.of(renderHeavyJs))

            /**
             * Sets [Builder.renderHeavyJs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.renderHeavyJs] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun renderHeavyJs(renderHeavyJs: JsonField<Boolean>) = apply {
                this.renderHeavyJs = renderHeavyJs
            }

            /** Website interaction steps (e.g., clicking buttons) */
            fun steps(steps: List<String>) = steps(JsonField.of(steps))

            /**
             * Sets [Builder.steps] to an arbitrary JSON value.
             *
             * You should usually call [Builder.steps] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun steps(steps: JsonField<List<String>>) = apply {
                this.steps = steps.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [steps].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addStep(step: String) = apply {
                steps =
                    (steps ?: JsonField.of(mutableListOf())).also {
                        checkKnown("steps", it).add(step)
                    }
            }

            /** Number of pages to process for pagination */
            fun totalPages(totalPages: Long) = totalPages(JsonField.of(totalPages))

            /**
             * Sets [Builder.totalPages] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalPages] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalPages(totalPages: JsonField<Long>) = apply { this.totalPages = totalPages }

            /** HTML content to process (max 2MB, mutually exclusive with website_url) */
            fun websiteHtml(websiteHtml: String) = websiteHtml(JsonField.of(websiteHtml))

            /**
             * Sets [Builder.websiteHtml] to an arbitrary JSON value.
             *
             * You should usually call [Builder.websiteHtml] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun websiteHtml(websiteHtml: JsonField<String>) = apply {
                this.websiteHtml = websiteHtml
            }

            /** URL to scrape (mutually exclusive with website_html) */
            fun websiteUrl(websiteUrl: String) = websiteUrl(JsonField.of(websiteUrl))

            /**
             * Sets [Builder.websiteUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.websiteUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun websiteUrl(websiteUrl: JsonField<String>) = apply { this.websiteUrl = websiteUrl }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .userPrompt()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("userPrompt", userPrompt),
                    cookies,
                    headers,
                    numberOfScrolls,
                    outputSchema,
                    renderHeavyJs,
                    (steps ?: JsonMissing.of()).map { it.toImmutable() },
                    totalPages,
                    websiteHtml,
                    websiteUrl,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            userPrompt()
            cookies().ifPresent { it.validate() }
            headers().ifPresent { it.validate() }
            numberOfScrolls()
            renderHeavyJs()
            steps()
            totalPages()
            websiteHtml()
            websiteUrl()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ScrapegraphaiInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (userPrompt.asKnown().isPresent) 1 else 0) +
                (cookies.asKnown().getOrNull()?.validity() ?: 0) +
                (headers.asKnown().getOrNull()?.validity() ?: 0) +
                (if (numberOfScrolls.asKnown().isPresent) 1 else 0) +
                (if (renderHeavyJs.asKnown().isPresent) 1 else 0) +
                (steps.asKnown().getOrNull()?.size ?: 0) +
                (if (totalPages.asKnown().isPresent) 1 else 0) +
                (if (websiteHtml.asKnown().isPresent) 1 else 0) +
                (if (websiteUrl.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && userPrompt == other.userPrompt && cookies == other.cookies && headers == other.headers && numberOfScrolls == other.numberOfScrolls && outputSchema == other.outputSchema && renderHeavyJs == other.renderHeavyJs && steps == other.steps && totalPages == other.totalPages && websiteHtml == other.websiteHtml && websiteUrl == other.websiteUrl && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(userPrompt, cookies, headers, numberOfScrolls, outputSchema, renderHeavyJs, steps, totalPages, websiteHtml, websiteUrl, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{userPrompt=$userPrompt, cookies=$cookies, headers=$headers, numberOfScrolls=$numberOfScrolls, outputSchema=$outputSchema, renderHeavyJs=$renderHeavyJs, steps=$steps, totalPages=$totalPages, websiteHtml=$websiteHtml, websiteUrl=$websiteUrl, additionalProperties=$additionalProperties}"
    }

    /** Cookies to include in the request */
    class Cookies
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Cookies]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Cookies]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(cookies: Cookies) = apply {
                additionalProperties = cookies.additionalProperties.toMutableMap()
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Cookies].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Cookies = Cookies(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Cookies = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ScrapegraphaiInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Cookies && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Cookies{additionalProperties=$additionalProperties}"
    }

    /** HTTP headers to include in the request */
    class Headers
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Headers]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Headers]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(headers: Headers) = apply {
                additionalProperties = headers.additionalProperties.toMutableMap()
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Headers].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Headers = Headers(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Headers = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ScrapegraphaiInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Headers && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Headers{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is SmartscraperCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "SmartscraperCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
