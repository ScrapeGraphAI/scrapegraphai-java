// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.searchscraper

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.scrapegraphai.api.core.Enum
import com.scrapegraphai.api.core.ExcludeMissing
import com.scrapegraphai.api.core.JsonField
import com.scrapegraphai.api.core.JsonMissing
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.checkKnown
import com.scrapegraphai.api.core.toImmutable
import com.scrapegraphai.api.errors.ScrapegraphaiInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class CompletedSearchScraper
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
        @JsonProperty("num_results") @ExcludeMissing numResults: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("reference_urls")
        @ExcludeMissing
        referenceUrls: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("request_id") @ExcludeMissing requestId: JsonField<String> = JsonMissing.of(),
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
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun error(): Optional<String> = error.getOptional("error")

    /**
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun numResults(): Optional<Long> = numResults.getOptional("num_results")

    /**
     * URLs of sources used
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun referenceUrls(): Optional<List<String>> = referenceUrls.getOptional("reference_urls")

    /**
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun requestId(): Optional<String> = requestId.getOptional("request_id")

    /** Merged results from all scraped websites */
    @JsonProperty("result") @ExcludeMissing fun _result(): JsonValue = result

    /**
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun status(): Optional<Status> = status.getOptional("status")

    /**
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
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
     * Unlike [referenceUrls], this method doesn't throw if the JSON field has an unexpected type.
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
    @JsonProperty("user_prompt") @ExcludeMissing fun _userPrompt(): JsonField<String> = userPrompt

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

        /** Returns a mutable builder for constructing an instance of [CompletedSearchScraper]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CompletedSearchScraper]. */
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
        internal fun from(completedSearchScraper: CompletedSearchScraper) = apply {
            error = completedSearchScraper.error
            numResults = completedSearchScraper.numResults
            referenceUrls = completedSearchScraper.referenceUrls.map { it.toMutableList() }
            requestId = completedSearchScraper.requestId
            result = completedSearchScraper.result
            status = completedSearchScraper.status
            userPrompt = completedSearchScraper.userPrompt
            additionalProperties = completedSearchScraper.additionalProperties.toMutableMap()
        }

        fun error(error: String?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<String>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun error(error: JsonField<String>) = apply { this.error = error }

        fun numResults(numResults: Long) = numResults(JsonField.of(numResults))

        /**
         * Sets [Builder.numResults] to an arbitrary JSON value.
         *
         * You should usually call [Builder.numResults] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun numResults(numResults: JsonField<Long>) = apply { this.numResults = numResults }

        /** URLs of sources used */
        fun referenceUrls(referenceUrls: List<String>) = referenceUrls(JsonField.of(referenceUrls))

        /**
         * Sets [Builder.referenceUrls] to an arbitrary JSON value.
         *
         * You should usually call [Builder.referenceUrls] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
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
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

        /** Merged results from all scraped websites */
        fun result(result: JsonValue) = apply { this.result = result }

        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        fun userPrompt(userPrompt: String) = userPrompt(JsonField.of(userPrompt))

        /**
         * Sets [Builder.userPrompt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.userPrompt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Returns an immutable instance of [CompletedSearchScraper].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CompletedSearchScraper =
            CompletedSearchScraper(
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

    fun validate(): CompletedSearchScraper = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
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
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val QUEUED = of("queued")

            @JvmField val PROCESSING = of("processing")

            @JvmField val COMPLETED = of("completed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            QUEUED,
            PROCESSING,
            COMPLETED,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            QUEUED,
            PROCESSING,
            COMPLETED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                QUEUED -> Value.QUEUED
                PROCESSING -> Value.PROCESSING
                COMPLETED -> Value.COMPLETED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ScrapegraphaiInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                QUEUED -> Known.QUEUED
                PROCESSING -> Known.PROCESSING
                COMPLETED -> Known.COMPLETED
                else -> throw ScrapegraphaiInvalidDataException("Unknown Status: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws ScrapegraphaiInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
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

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CompletedSearchScraper &&
            error == other.error &&
            numResults == other.numResults &&
            referenceUrls == other.referenceUrls &&
            requestId == other.requestId &&
            result == other.result &&
            status == other.status &&
            userPrompt == other.userPrompt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            error,
            numResults,
            referenceUrls,
            requestId,
            result,
            status,
            userPrompt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CompletedSearchScraper{error=$error, numResults=$numResults, referenceUrls=$referenceUrls, requestId=$requestId, result=$result, status=$status, userPrompt=$userPrompt, additionalProperties=$additionalProperties}"
}
