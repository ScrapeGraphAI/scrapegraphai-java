// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.crawl

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
 * Initiate comprehensive website crawling with sitemap support. Supports both AI extraction mode
 * and markdown conversion mode. Returns a task ID for async processing.
 */
class CrawlStartParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Starting URL for crawling
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun url(): String = body.url()

    /**
     * Maximum crawl depth from starting URL
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun depth(): Optional<Long> = body.depth()

    /**
     * Use AI extraction (true) or markdown conversion (false)
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun extractionMode(): Optional<Boolean> = body.extractionMode()

    /**
     * Maximum number of pages to crawl
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun maxPages(): Optional<Long> = body.maxPages()

    /**
     * Extraction prompt (required if extraction_mode is true)
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun prompt(): Optional<String> = body.prompt()

    /**
     * Enable heavy JavaScript rendering
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun renderHeavyJs(): Optional<Boolean> = body.renderHeavyJs()

    /**
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun rules(): Optional<Rules> = body.rules()

    /** Output schema for extraction */
    fun _schema(): JsonValue = body._schema()

    /**
     * Use sitemap for crawling
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun sitemap(): Optional<Boolean> = body.sitemap()

    /**
     * Returns the raw JSON value of [url].
     *
     * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _url(): JsonField<String> = body._url()

    /**
     * Returns the raw JSON value of [depth].
     *
     * Unlike [depth], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _depth(): JsonField<Long> = body._depth()

    /**
     * Returns the raw JSON value of [extractionMode].
     *
     * Unlike [extractionMode], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _extractionMode(): JsonField<Boolean> = body._extractionMode()

    /**
     * Returns the raw JSON value of [maxPages].
     *
     * Unlike [maxPages], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _maxPages(): JsonField<Long> = body._maxPages()

    /**
     * Returns the raw JSON value of [prompt].
     *
     * Unlike [prompt], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _prompt(): JsonField<String> = body._prompt()

    /**
     * Returns the raw JSON value of [renderHeavyJs].
     *
     * Unlike [renderHeavyJs], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _renderHeavyJs(): JsonField<Boolean> = body._renderHeavyJs()

    /**
     * Returns the raw JSON value of [rules].
     *
     * Unlike [rules], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _rules(): JsonField<Rules> = body._rules()

    /**
     * Returns the raw JSON value of [sitemap].
     *
     * Unlike [sitemap], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sitemap(): JsonField<Boolean> = body._sitemap()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CrawlStartParams].
         *
         * The following fields are required:
         * ```java
         * .url()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CrawlStartParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(crawlStartParams: CrawlStartParams) = apply {
            body = crawlStartParams.body.toBuilder()
            additionalHeaders = crawlStartParams.additionalHeaders.toBuilder()
            additionalQueryParams = crawlStartParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [url]
         * - [depth]
         * - [extractionMode]
         * - [maxPages]
         * - [prompt]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Starting URL for crawling */
        fun url(url: String) = apply { body.url(url) }

        /**
         * Sets [Builder.url] to an arbitrary JSON value.
         *
         * You should usually call [Builder.url] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun url(url: JsonField<String>) = apply { body.url(url) }

        /** Maximum crawl depth from starting URL */
        fun depth(depth: Long) = apply { body.depth(depth) }

        /**
         * Sets [Builder.depth] to an arbitrary JSON value.
         *
         * You should usually call [Builder.depth] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun depth(depth: JsonField<Long>) = apply { body.depth(depth) }

        /** Use AI extraction (true) or markdown conversion (false) */
        fun extractionMode(extractionMode: Boolean) = apply { body.extractionMode(extractionMode) }

        /**
         * Sets [Builder.extractionMode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.extractionMode] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun extractionMode(extractionMode: JsonField<Boolean>) = apply {
            body.extractionMode(extractionMode)
        }

        /** Maximum number of pages to crawl */
        fun maxPages(maxPages: Long) = apply { body.maxPages(maxPages) }

        /**
         * Sets [Builder.maxPages] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxPages] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun maxPages(maxPages: JsonField<Long>) = apply { body.maxPages(maxPages) }

        /** Extraction prompt (required if extraction_mode is true) */
        fun prompt(prompt: String?) = apply { body.prompt(prompt) }

        /** Alias for calling [Builder.prompt] with `prompt.orElse(null)`. */
        fun prompt(prompt: Optional<String>) = prompt(prompt.getOrNull())

        /**
         * Sets [Builder.prompt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.prompt] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun prompt(prompt: JsonField<String>) = apply { body.prompt(prompt) }

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

        fun rules(rules: Rules) = apply { body.rules(rules) }

        /**
         * Sets [Builder.rules] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rules] with a well-typed [Rules] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun rules(rules: JsonField<Rules>) = apply { body.rules(rules) }

        /** Output schema for extraction */
        fun schema(schema: JsonValue) = apply { body.schema(schema) }

        /** Use sitemap for crawling */
        fun sitemap(sitemap: Boolean) = apply { body.sitemap(sitemap) }

        /**
         * Sets [Builder.sitemap] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sitemap] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sitemap(sitemap: JsonField<Boolean>) = apply { body.sitemap(sitemap) }

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
         * Returns an immutable instance of [CrawlStartParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .url()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CrawlStartParams =
            CrawlStartParams(body.build(), additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val url: JsonField<String>,
        private val depth: JsonField<Long>,
        private val extractionMode: JsonField<Boolean>,
        private val maxPages: JsonField<Long>,
        private val prompt: JsonField<String>,
        private val renderHeavyJs: JsonField<Boolean>,
        private val rules: JsonField<Rules>,
        private val schema: JsonValue,
        private val sitemap: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("depth") @ExcludeMissing depth: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("extraction_mode")
            @ExcludeMissing
            extractionMode: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("max_pages") @ExcludeMissing maxPages: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("prompt") @ExcludeMissing prompt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("render_heavy_js")
            @ExcludeMissing
            renderHeavyJs: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("rules") @ExcludeMissing rules: JsonField<Rules> = JsonMissing.of(),
            @JsonProperty("schema") @ExcludeMissing schema: JsonValue = JsonMissing.of(),
            @JsonProperty("sitemap") @ExcludeMissing sitemap: JsonField<Boolean> = JsonMissing.of(),
        ) : this(
            url,
            depth,
            extractionMode,
            maxPages,
            prompt,
            renderHeavyJs,
            rules,
            schema,
            sitemap,
            mutableMapOf(),
        )

        /**
         * Starting URL for crawling
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun url(): String = url.getRequired("url")

        /**
         * Maximum crawl depth from starting URL
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun depth(): Optional<Long> = depth.getOptional("depth")

        /**
         * Use AI extraction (true) or markdown conversion (false)
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun extractionMode(): Optional<Boolean> = extractionMode.getOptional("extraction_mode")

        /**
         * Maximum number of pages to crawl
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun maxPages(): Optional<Long> = maxPages.getOptional("max_pages")

        /**
         * Extraction prompt (required if extraction_mode is true)
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun prompt(): Optional<String> = prompt.getOptional("prompt")

        /**
         * Enable heavy JavaScript rendering
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun renderHeavyJs(): Optional<Boolean> = renderHeavyJs.getOptional("render_heavy_js")

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun rules(): Optional<Rules> = rules.getOptional("rules")

        /** Output schema for extraction */
        @JsonProperty("schema") @ExcludeMissing fun _schema(): JsonValue = schema

        /**
         * Use sitemap for crawling
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun sitemap(): Optional<Boolean> = sitemap.getOptional("sitemap")

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [depth].
         *
         * Unlike [depth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("depth") @ExcludeMissing fun _depth(): JsonField<Long> = depth

        /**
         * Returns the raw JSON value of [extractionMode].
         *
         * Unlike [extractionMode], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("extraction_mode")
        @ExcludeMissing
        fun _extractionMode(): JsonField<Boolean> = extractionMode

        /**
         * Returns the raw JSON value of [maxPages].
         *
         * Unlike [maxPages], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("max_pages") @ExcludeMissing fun _maxPages(): JsonField<Long> = maxPages

        /**
         * Returns the raw JSON value of [prompt].
         *
         * Unlike [prompt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("prompt") @ExcludeMissing fun _prompt(): JsonField<String> = prompt

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
         * Returns the raw JSON value of [rules].
         *
         * Unlike [rules], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("rules") @ExcludeMissing fun _rules(): JsonField<Rules> = rules

        /**
         * Returns the raw JSON value of [sitemap].
         *
         * Unlike [sitemap], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sitemap") @ExcludeMissing fun _sitemap(): JsonField<Boolean> = sitemap

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
             * .url()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var url: JsonField<String>? = null
            private var depth: JsonField<Long> = JsonMissing.of()
            private var extractionMode: JsonField<Boolean> = JsonMissing.of()
            private var maxPages: JsonField<Long> = JsonMissing.of()
            private var prompt: JsonField<String> = JsonMissing.of()
            private var renderHeavyJs: JsonField<Boolean> = JsonMissing.of()
            private var rules: JsonField<Rules> = JsonMissing.of()
            private var schema: JsonValue = JsonMissing.of()
            private var sitemap: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                url = body.url
                depth = body.depth
                extractionMode = body.extractionMode
                maxPages = body.maxPages
                prompt = body.prompt
                renderHeavyJs = body.renderHeavyJs
                rules = body.rules
                schema = body.schema
                sitemap = body.sitemap
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Starting URL for crawling */
            fun url(url: String) = url(JsonField.of(url))

            /**
             * Sets [Builder.url] to an arbitrary JSON value.
             *
             * You should usually call [Builder.url] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun url(url: JsonField<String>) = apply { this.url = url }

            /** Maximum crawl depth from starting URL */
            fun depth(depth: Long) = depth(JsonField.of(depth))

            /**
             * Sets [Builder.depth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.depth] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun depth(depth: JsonField<Long>) = apply { this.depth = depth }

            /** Use AI extraction (true) or markdown conversion (false) */
            fun extractionMode(extractionMode: Boolean) =
                extractionMode(JsonField.of(extractionMode))

            /**
             * Sets [Builder.extractionMode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.extractionMode] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun extractionMode(extractionMode: JsonField<Boolean>) = apply {
                this.extractionMode = extractionMode
            }

            /** Maximum number of pages to crawl */
            fun maxPages(maxPages: Long) = maxPages(JsonField.of(maxPages))

            /**
             * Sets [Builder.maxPages] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxPages] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxPages(maxPages: JsonField<Long>) = apply { this.maxPages = maxPages }

            /** Extraction prompt (required if extraction_mode is true) */
            fun prompt(prompt: String?) = prompt(JsonField.ofNullable(prompt))

            /** Alias for calling [Builder.prompt] with `prompt.orElse(null)`. */
            fun prompt(prompt: Optional<String>) = prompt(prompt.getOrNull())

            /**
             * Sets [Builder.prompt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.prompt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun prompt(prompt: JsonField<String>) = apply { this.prompt = prompt }

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

            fun rules(rules: Rules) = rules(JsonField.of(rules))

            /**
             * Sets [Builder.rules] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rules] with a well-typed [Rules] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun rules(rules: JsonField<Rules>) = apply { this.rules = rules }

            /** Output schema for extraction */
            fun schema(schema: JsonValue) = apply { this.schema = schema }

            /** Use sitemap for crawling */
            fun sitemap(sitemap: Boolean) = sitemap(JsonField.of(sitemap))

            /**
             * Sets [Builder.sitemap] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sitemap] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sitemap(sitemap: JsonField<Boolean>) = apply { this.sitemap = sitemap }

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
             * .url()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("url", url),
                    depth,
                    extractionMode,
                    maxPages,
                    prompt,
                    renderHeavyJs,
                    rules,
                    schema,
                    sitemap,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            url()
            depth()
            extractionMode()
            maxPages()
            prompt()
            renderHeavyJs()
            rules().ifPresent { it.validate() }
            sitemap()
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
            (if (url.asKnown().isPresent) 1 else 0) +
                (if (depth.asKnown().isPresent) 1 else 0) +
                (if (extractionMode.asKnown().isPresent) 1 else 0) +
                (if (maxPages.asKnown().isPresent) 1 else 0) +
                (if (prompt.asKnown().isPresent) 1 else 0) +
                (if (renderHeavyJs.asKnown().isPresent) 1 else 0) +
                (rules.asKnown().getOrNull()?.validity() ?: 0) +
                (if (sitemap.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && url == other.url && depth == other.depth && extractionMode == other.extractionMode && maxPages == other.maxPages && prompt == other.prompt && renderHeavyJs == other.renderHeavyJs && rules == other.rules && schema == other.schema && sitemap == other.sitemap && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(url, depth, extractionMode, maxPages, prompt, renderHeavyJs, rules, schema, sitemap, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{url=$url, depth=$depth, extractionMode=$extractionMode, maxPages=$maxPages, prompt=$prompt, renderHeavyJs=$renderHeavyJs, rules=$rules, schema=$schema, sitemap=$sitemap, additionalProperties=$additionalProperties}"
    }

    class Rules
    private constructor(
        private val exclude: JsonField<List<String>>,
        private val sameDomain: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("exclude")
            @ExcludeMissing
            exclude: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("same_domain")
            @ExcludeMissing
            sameDomain: JsonField<Boolean> = JsonMissing.of(),
        ) : this(exclude, sameDomain, mutableMapOf())

        /**
         * URL patterns to exclude from crawling
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun exclude(): Optional<List<String>> = exclude.getOptional("exclude")

        /**
         * Restrict crawling to same domain
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun sameDomain(): Optional<Boolean> = sameDomain.getOptional("same_domain")

        /**
         * Returns the raw JSON value of [exclude].
         *
         * Unlike [exclude], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("exclude") @ExcludeMissing fun _exclude(): JsonField<List<String>> = exclude

        /**
         * Returns the raw JSON value of [sameDomain].
         *
         * Unlike [sameDomain], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("same_domain")
        @ExcludeMissing
        fun _sameDomain(): JsonField<Boolean> = sameDomain

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

            /** Returns a mutable builder for constructing an instance of [Rules]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Rules]. */
        class Builder internal constructor() {

            private var exclude: JsonField<MutableList<String>>? = null
            private var sameDomain: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(rules: Rules) = apply {
                exclude = rules.exclude.map { it.toMutableList() }
                sameDomain = rules.sameDomain
                additionalProperties = rules.additionalProperties.toMutableMap()
            }

            /** URL patterns to exclude from crawling */
            fun exclude(exclude: List<String>) = exclude(JsonField.of(exclude))

            /**
             * Sets [Builder.exclude] to an arbitrary JSON value.
             *
             * You should usually call [Builder.exclude] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun exclude(exclude: JsonField<List<String>>) = apply {
                this.exclude = exclude.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.exclude].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addExclude(exclude: String) = apply {
                this.exclude =
                    (this.exclude ?: JsonField.of(mutableListOf())).also {
                        checkKnown("exclude", it).add(exclude)
                    }
            }

            /** Restrict crawling to same domain */
            fun sameDomain(sameDomain: Boolean) = sameDomain(JsonField.of(sameDomain))

            /**
             * Sets [Builder.sameDomain] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sameDomain] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sameDomain(sameDomain: JsonField<Boolean>) = apply { this.sameDomain = sameDomain }

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
             * Returns an immutable instance of [Rules].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Rules =
                Rules(
                    (exclude ?: JsonMissing.of()).map { it.toImmutable() },
                    sameDomain,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Rules = apply {
            if (validated) {
                return@apply
            }

            exclude()
            sameDomain()
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
            (exclude.asKnown().getOrNull()?.size ?: 0) +
                (if (sameDomain.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Rules && exclude == other.exclude && sameDomain == other.sameDomain && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(exclude, sameDomain, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Rules{exclude=$exclude, sameDomain=$sameDomain, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CrawlStartParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "CrawlStartParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
