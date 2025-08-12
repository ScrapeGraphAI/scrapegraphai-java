// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.searchscraper

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.core.BaseDeserializer
import com.scrapegraphai.api.core.BaseSerializer
import com.scrapegraphai.api.core.Enum
import com.scrapegraphai.api.core.ExcludeMissing
import com.scrapegraphai.api.core.JsonField
import com.scrapegraphai.api.core.JsonMissing
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.allMaxBy
import com.scrapegraphai.api.core.checkKnown
import com.scrapegraphai.api.core.getOrThrow
import com.scrapegraphai.api.core.toImmutable
import com.scrapegraphai.api.errors.ScrapegraphaiInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@JsonDeserialize(using = SearchscraperRetrieveStatusResponse.Deserializer::class)
@JsonSerialize(using = SearchscraperRetrieveStatusResponse.Serializer::class)
class SearchscraperRetrieveStatusResponse
private constructor(
    private val completedSearchScraper: CompletedSearchScraper? = null,
    private val failedSearchScraper: FailedSearchScraperResponse? = null,
    private val _json: JsonValue? = null,
) {

    fun completedSearchScraper(): Optional<CompletedSearchScraper> =
        Optional.ofNullable(completedSearchScraper)

    fun failedSearchScraper(): Optional<FailedSearchScraperResponse> =
        Optional.ofNullable(failedSearchScraper)

    fun isCompletedSearchScraper(): Boolean = completedSearchScraper != null

    fun isFailedSearchScraper(): Boolean = failedSearchScraper != null

    fun asCompletedSearchScraper(): CompletedSearchScraper =
        completedSearchScraper.getOrThrow("completedSearchScraper")

    fun asFailedSearchScraper(): FailedSearchScraperResponse =
        failedSearchScraper.getOrThrow("failedSearchScraper")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            completedSearchScraper != null ->
                visitor.visitCompletedSearchScraper(completedSearchScraper)
            failedSearchScraper != null -> visitor.visitFailedSearchScraper(failedSearchScraper)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): SearchscraperRetrieveStatusResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitCompletedSearchScraper(
                    completedSearchScraper: CompletedSearchScraper
                ) {
                    completedSearchScraper.validate()
                }

                override fun visitFailedSearchScraper(
                    failedSearchScraper: FailedSearchScraperResponse
                ) {
                    failedSearchScraper.validate()
                }
            }
        )
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitCompletedSearchScraper(
                    completedSearchScraper: CompletedSearchScraper
                ) = completedSearchScraper.validity()

                override fun visitFailedSearchScraper(
                    failedSearchScraper: FailedSearchScraperResponse
                ) = failedSearchScraper.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is SearchscraperRetrieveStatusResponse && completedSearchScraper == other.completedSearchScraper && failedSearchScraper == other.failedSearchScraper /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(completedSearchScraper, failedSearchScraper) /* spotless:on */

    override fun toString(): String =
        when {
            completedSearchScraper != null ->
                "SearchscraperRetrieveStatusResponse{completedSearchScraper=$completedSearchScraper}"
            failedSearchScraper != null ->
                "SearchscraperRetrieveStatusResponse{failedSearchScraper=$failedSearchScraper}"
            _json != null -> "SearchscraperRetrieveStatusResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid SearchscraperRetrieveStatusResponse")
        }

    companion object {

        @JvmStatic
        fun ofCompletedSearchScraper(completedSearchScraper: CompletedSearchScraper) =
            SearchscraperRetrieveStatusResponse(completedSearchScraper = completedSearchScraper)

        @JvmStatic
        fun ofFailedSearchScraper(failedSearchScraper: FailedSearchScraperResponse) =
            SearchscraperRetrieveStatusResponse(failedSearchScraper = failedSearchScraper)
    }

    /**
     * An interface that defines how to map each variant of [SearchscraperRetrieveStatusResponse] to
     * a value of type [T].
     */
    interface Visitor<out T> {

        fun visitCompletedSearchScraper(completedSearchScraper: CompletedSearchScraper): T

        fun visitFailedSearchScraper(failedSearchScraper: FailedSearchScraperResponse): T

        /**
         * Maps an unknown variant of [SearchscraperRetrieveStatusResponse] to a value of type [T].
         *
         * An instance of [SearchscraperRetrieveStatusResponse] can contain an unknown variant if it
         * was deserialized from data that doesn't match any known variant. For example, if the SDK
         * is on an older version than the API, then the API may respond with new variants that the
         * SDK is unaware of.
         *
         * @throws ScrapegraphaiInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw ScrapegraphaiInvalidDataException(
                "Unknown SearchscraperRetrieveStatusResponse: $json"
            )
        }
    }

    internal class Deserializer :
        BaseDeserializer<SearchscraperRetrieveStatusResponse>(
            SearchscraperRetrieveStatusResponse::class
        ) {

        override fun ObjectCodec.deserialize(node: JsonNode): SearchscraperRetrieveStatusResponse {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<CompletedSearchScraper>())?.let {
                            SearchscraperRetrieveStatusResponse(
                                completedSearchScraper = it,
                                _json = json,
                            )
                        },
                        tryDeserialize(node, jacksonTypeRef<FailedSearchScraperResponse>())?.let {
                            SearchscraperRetrieveStatusResponse(
                                failedSearchScraper = it,
                                _json = json,
                            )
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> SearchscraperRetrieveStatusResponse(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<SearchscraperRetrieveStatusResponse>(
            SearchscraperRetrieveStatusResponse::class
        ) {

        override fun serialize(
            value: SearchscraperRetrieveStatusResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.completedSearchScraper != null ->
                    generator.writeObject(value.completedSearchScraper)
                value.failedSearchScraper != null ->
                    generator.writeObject(value.failedSearchScraper)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid SearchscraperRetrieveStatusResponse")
            }
        }
    }

    class FailedSearchScraperResponse
    private constructor(
        private val error: JsonField<String>,
        private val numResults: JsonField<Long>,
        private val referenceUrls: JsonField<List<String>>,
        private val requestId: JsonField<String>,
        private val result: JsonValue,
        private val status: JsonField<Status>,
        private val userPrompt: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("error") @ExcludeMissing error: JsonField<String> = JsonMissing.of(),
            @JsonProperty("num_results")
            @ExcludeMissing
            numResults: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("reference_urls")
            @ExcludeMissing
            referenceUrls: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("request_id")
            @ExcludeMissing
            requestId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("result") @ExcludeMissing result: JsonValue = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("user_prompt")
            @ExcludeMissing
            userPrompt: JsonField<String> = JsonMissing.of(),
        ) : this(
            error,
            numResults,
            referenceUrls,
            requestId,
            result,
            status,
            userPrompt,
            mutableMapOf(),
        )

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun error(): Optional<String> = error.getOptional("error")

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun numResults(): Optional<Long> = numResults.getOptional("num_results")

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun referenceUrls(): Optional<List<String>> = referenceUrls.getOptional("reference_urls")

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun requestId(): Optional<String> = requestId.getOptional("request_id")

        @JsonProperty("result") @ExcludeMissing fun _result(): JsonValue = result

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun status(): Optional<Status> = status.getOptional("status")

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun userPrompt(): Optional<String> = userPrompt.getOptional("user_prompt")

        /**
         * Returns the raw JSON value of [error].
         *
         * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<String> = error

        /**
         * Returns the raw JSON value of [numResults].
         *
         * Unlike [numResults], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("num_results") @ExcludeMissing fun _numResults(): JsonField<Long> = numResults

        /**
         * Returns the raw JSON value of [referenceUrls].
         *
         * Unlike [referenceUrls], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("reference_urls")
        @ExcludeMissing
        fun _referenceUrls(): JsonField<List<String>> = referenceUrls

        /**
         * Returns the raw JSON value of [requestId].
         *
         * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("request_id") @ExcludeMissing fun _requestId(): JsonField<String> = requestId

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [userPrompt].
         *
         * Unlike [userPrompt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("user_prompt")
        @ExcludeMissing
        fun _userPrompt(): JsonField<String> = userPrompt

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
             * Returns a mutable builder for constructing an instance of
             * [FailedSearchScraperResponse].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FailedSearchScraperResponse]. */
        class Builder internal constructor() {

            private var error: JsonField<String> = JsonMissing.of()
            private var numResults: JsonField<Long> = JsonMissing.of()
            private var referenceUrls: JsonField<MutableList<String>>? = null
            private var requestId: JsonField<String> = JsonMissing.of()
            private var result: JsonValue = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var userPrompt: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(failedSearchScraperResponse: FailedSearchScraperResponse) = apply {
                error = failedSearchScraperResponse.error
                numResults = failedSearchScraperResponse.numResults
                referenceUrls = failedSearchScraperResponse.referenceUrls.map { it.toMutableList() }
                requestId = failedSearchScraperResponse.requestId
                result = failedSearchScraperResponse.result
                status = failedSearchScraperResponse.status
                userPrompt = failedSearchScraperResponse.userPrompt
                additionalProperties =
                    failedSearchScraperResponse.additionalProperties.toMutableMap()
            }

            fun error(error: String) = error(JsonField.of(error))

            /**
             * Sets [Builder.error] to an arbitrary JSON value.
             *
             * You should usually call [Builder.error] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun error(error: JsonField<String>) = apply { this.error = error }

            fun numResults(numResults: Long) = numResults(JsonField.of(numResults))

            /**
             * Sets [Builder.numResults] to an arbitrary JSON value.
             *
             * You should usually call [Builder.numResults] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun numResults(numResults: JsonField<Long>) = apply { this.numResults = numResults }

            fun referenceUrls(referenceUrls: List<String>) =
                referenceUrls(JsonField.of(referenceUrls))

            /**
             * Sets [Builder.referenceUrls] to an arbitrary JSON value.
             *
             * You should usually call [Builder.referenceUrls] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun referenceUrls(referenceUrls: JsonField<List<String>>) = apply {
                this.referenceUrls = referenceUrls.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [referenceUrls].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addReferenceUrl(referenceUrl: String) = apply {
                referenceUrls =
                    (referenceUrls ?: JsonField.of(mutableListOf())).also {
                        checkKnown("referenceUrls", it).add(referenceUrl)
                    }
            }

            fun requestId(requestId: String) = requestId(JsonField.of(requestId))

            /**
             * Sets [Builder.requestId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

            fun result(result: JsonValue) = apply { this.result = result }

            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            fun userPrompt(userPrompt: String) = userPrompt(JsonField.of(userPrompt))

            /**
             * Sets [Builder.userPrompt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.userPrompt] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun userPrompt(userPrompt: JsonField<String>) = apply { this.userPrompt = userPrompt }

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
             * Returns an immutable instance of [FailedSearchScraperResponse].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): FailedSearchScraperResponse =
                FailedSearchScraperResponse(
                    error,
                    numResults,
                    (referenceUrls ?: JsonMissing.of()).map { it.toImmutable() },
                    requestId,
                    result,
                    status,
                    userPrompt,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): FailedSearchScraperResponse = apply {
            if (validated) {
                return@apply
            }

            error()
            numResults()
            referenceUrls()
            requestId()
            status().ifPresent { it.validate() }
            userPrompt()
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
            (if (error.asKnown().isPresent) 1 else 0) +
                (if (numResults.asKnown().isPresent) 1 else 0) +
                (referenceUrls.asKnown().getOrNull()?.size ?: 0) +
                (if (requestId.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (userPrompt.asKnown().isPresent) 1 else 0)

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val FAILED = of("failed")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                FAILED
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                FAILED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    FAILED -> Value.FAILED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws ScrapegraphaiInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    FAILED -> Known.FAILED
                    else -> throw ScrapegraphaiInvalidDataException("Unknown Status: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws ScrapegraphaiInvalidDataException if this class instance's value does not
             *   have the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    ScrapegraphaiInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): Status = apply {
                if (validated) {
                    return@apply
                }

                known()
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
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Status && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is FailedSearchScraperResponse && error == other.error && numResults == other.numResults && referenceUrls == other.referenceUrls && requestId == other.requestId && result == other.result && status == other.status && userPrompt == other.userPrompt && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(error, numResults, referenceUrls, requestId, result, status, userPrompt, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FailedSearchScraperResponse{error=$error, numResults=$numResults, referenceUrls=$referenceUrls, requestId=$requestId, result=$result, status=$status, userPrompt=$userPrompt, additionalProperties=$additionalProperties}"
    }
}
