// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.searchscraper

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.scrapegraphai.api.core.ExcludeMissing
import com.scrapegraphai.api.core.JsonField
import com.scrapegraphai.api.core.JsonMissing
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.Params
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
 * Performs web search, selects relevant URLs, and extracts structured data from multiple websites.
 * Uses LLM to refine search queries and merge results from different sources.
 */
class SearchscraperCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Search query and extraction instruction
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun userPrompt(): String = body.userPrompt()

    /**
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun headers(): Optional<Headers> = body.headers()

    /**
     * Number of websites to scrape from search results
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun numResults(): Optional<Long> = body.numResults()

    /** JSON schema for structured output */
    fun _outputSchema(): JsonValue = body._outputSchema()

    /**
     * Returns the raw JSON value of [userPrompt].
     *
     * Unlike [userPrompt], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _userPrompt(): JsonField<String> = body._userPrompt()

    /**
     * Returns the raw JSON value of [headers].
     *
     * Unlike [headers], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _headers_(): JsonField<Headers> = body._headers_()

    /**
     * Returns the raw JSON value of [numResults].
     *
     * Unlike [numResults], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _numResults(): JsonField<Long> = body._numResults()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SearchscraperCreateParams].
         *
         * The following fields are required:
         * ```java
         * .userPrompt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SearchscraperCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(searchscraperCreateParams: SearchscraperCreateParams) = apply {
            body = searchscraperCreateParams.body.toBuilder()
            additionalHeaders = searchscraperCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = searchscraperCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [userPrompt]
         * - [headers]
         * - [numResults]
         * - [outputSchema]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Search query and extraction instruction */
        fun userPrompt(userPrompt: String) = apply { body.userPrompt(userPrompt) }

        /**
         * Sets [Builder.userPrompt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.userPrompt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun userPrompt(userPrompt: JsonField<String>) = apply { body.userPrompt(userPrompt) }

        fun headers(headers: Headers) = apply { body.headers(headers) }

        /**
         * Sets [Builder.headers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.headers] with a well-typed [Headers] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun headers(headers: JsonField<Headers>) = apply { body.headers(headers) }

        /** Number of websites to scrape from search results */
        fun numResults(numResults: Long) = apply { body.numResults(numResults) }

        /**
         * Sets [Builder.numResults] to an arbitrary JSON value.
         *
         * You should usually call [Builder.numResults] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun numResults(numResults: JsonField<Long>) = apply { body.numResults(numResults) }

        /** JSON schema for structured output */
        fun outputSchema(outputSchema: JsonValue) = apply { body.outputSchema(outputSchema) }

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
         * Returns an immutable instance of [SearchscraperCreateParams].
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
        fun build(): SearchscraperCreateParams =
            SearchscraperCreateParams(
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
        private val headers: JsonField<Headers>,
        private val numResults: JsonField<Long>,
        private val outputSchema: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("user_prompt")
            @ExcludeMissing
            userPrompt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("headers") @ExcludeMissing headers: JsonField<Headers> = JsonMissing.of(),
            @JsonProperty("num_results")
            @ExcludeMissing
            numResults: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("output_schema")
            @ExcludeMissing
            outputSchema: JsonValue = JsonMissing.of(),
        ) : this(userPrompt, headers, numResults, outputSchema, mutableMapOf())

        /**
         * Search query and extraction instruction
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun userPrompt(): String = userPrompt.getRequired("user_prompt")

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun headers(): Optional<Headers> = headers.getOptional("headers")

        /**
         * Number of websites to scrape from search results
         *
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun numResults(): Optional<Long> = numResults.getOptional("num_results")

        /** JSON schema for structured output */
        @JsonProperty("output_schema") @ExcludeMissing fun _outputSchema(): JsonValue = outputSchema

        /**
         * Returns the raw JSON value of [userPrompt].
         *
         * Unlike [userPrompt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("user_prompt")
        @ExcludeMissing
        fun _userPrompt(): JsonField<String> = userPrompt

        /**
         * Returns the raw JSON value of [headers].
         *
         * Unlike [headers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("headers") @ExcludeMissing fun _headers_(): JsonField<Headers> = headers

        /**
         * Returns the raw JSON value of [numResults].
         *
         * Unlike [numResults], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("num_results") @ExcludeMissing fun _numResults(): JsonField<Long> = numResults

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
            private var headers: JsonField<Headers> = JsonMissing.of()
            private var numResults: JsonField<Long> = JsonMissing.of()
            private var outputSchema: JsonValue = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                userPrompt = body.userPrompt
                headers = body.headers
                numResults = body.numResults
                outputSchema = body.outputSchema
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Search query and extraction instruction */
            fun userPrompt(userPrompt: String) = userPrompt(JsonField.of(userPrompt))

            /**
             * Sets [Builder.userPrompt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.userPrompt] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun userPrompt(userPrompt: JsonField<String>) = apply { this.userPrompt = userPrompt }

            fun headers(headers: Headers) = headers(JsonField.of(headers))

            /**
             * Sets [Builder.headers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.headers] with a well-typed [Headers] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun headers(headers: JsonField<Headers>) = apply { this.headers = headers }

            /** Number of websites to scrape from search results */
            fun numResults(numResults: Long) = numResults(JsonField.of(numResults))

            /**
             * Sets [Builder.numResults] to an arbitrary JSON value.
             *
             * You should usually call [Builder.numResults] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun numResults(numResults: JsonField<Long>) = apply { this.numResults = numResults }

            /** JSON schema for structured output */
            fun outputSchema(outputSchema: JsonValue) = apply { this.outputSchema = outputSchema }

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
                    headers,
                    numResults,
                    outputSchema,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            userPrompt()
            headers().ifPresent { it.validate() }
            numResults()
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
                (headers.asKnown().getOrNull()?.validity() ?: 0) +
                (if (numResults.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && userPrompt == other.userPrompt && headers == other.headers && numResults == other.numResults && outputSchema == other.outputSchema && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(userPrompt, headers, numResults, outputSchema, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{userPrompt=$userPrompt, headers=$headers, numResults=$numResults, outputSchema=$outputSchema, additionalProperties=$additionalProperties}"
    }

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

        return /* spotless:off */ other is SearchscraperCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "SearchscraperCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
