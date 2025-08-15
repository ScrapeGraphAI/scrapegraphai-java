// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.feedback

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.scrapegraphai.api.core.ExcludeMissing
import com.scrapegraphai.api.core.JsonField
import com.scrapegraphai.api.core.JsonMissing
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.errors.ScrapegraphaiInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional

class FeedbackSubmitResponse
private constructor(
    private val feedbackId: JsonField<String>,
    private val feedbackTimestamp: JsonField<OffsetDateTime>,
    private val message: JsonField<String>,
    private val requestId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("feedback_id")
        @ExcludeMissing
        feedbackId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("feedback_timestamp")
        @ExcludeMissing
        feedbackTimestamp: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        @JsonProperty("request_id") @ExcludeMissing requestId: JsonField<String> = JsonMissing.of(),
    ) : this(feedbackId, feedbackTimestamp, message, requestId, mutableMapOf())

    /**
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun feedbackId(): Optional<String> = feedbackId.getOptional("feedback_id")

    /**
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun feedbackTimestamp(): Optional<OffsetDateTime> =
        feedbackTimestamp.getOptional("feedback_timestamp")

    /**
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun message(): Optional<String> = message.getOptional("message")

    /**
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun requestId(): Optional<String> = requestId.getOptional("request_id")

    /**
     * Returns the raw JSON value of [feedbackId].
     *
     * Unlike [feedbackId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("feedback_id") @ExcludeMissing fun _feedbackId(): JsonField<String> = feedbackId

    /**
     * Returns the raw JSON value of [feedbackTimestamp].
     *
     * Unlike [feedbackTimestamp], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("feedback_timestamp")
    @ExcludeMissing
    fun _feedbackTimestamp(): JsonField<OffsetDateTime> = feedbackTimestamp

    /**
     * Returns the raw JSON value of [message].
     *
     * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

    /**
     * Returns the raw JSON value of [requestId].
     *
     * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("request_id") @ExcludeMissing fun _requestId(): JsonField<String> = requestId

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

        /** Returns a mutable builder for constructing an instance of [FeedbackSubmitResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FeedbackSubmitResponse]. */
    class Builder internal constructor() {

        private var feedbackId: JsonField<String> = JsonMissing.of()
        private var feedbackTimestamp: JsonField<OffsetDateTime> = JsonMissing.of()
        private var message: JsonField<String> = JsonMissing.of()
        private var requestId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(feedbackSubmitResponse: FeedbackSubmitResponse) = apply {
            feedbackId = feedbackSubmitResponse.feedbackId
            feedbackTimestamp = feedbackSubmitResponse.feedbackTimestamp
            message = feedbackSubmitResponse.message
            requestId = feedbackSubmitResponse.requestId
            additionalProperties = feedbackSubmitResponse.additionalProperties.toMutableMap()
        }

        fun feedbackId(feedbackId: String) = feedbackId(JsonField.of(feedbackId))

        /**
         * Sets [Builder.feedbackId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.feedbackId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun feedbackId(feedbackId: JsonField<String>) = apply { this.feedbackId = feedbackId }

        fun feedbackTimestamp(feedbackTimestamp: OffsetDateTime) =
            feedbackTimestamp(JsonField.of(feedbackTimestamp))

        /**
         * Sets [Builder.feedbackTimestamp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.feedbackTimestamp] with a well-typed [OffsetDateTime]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun feedbackTimestamp(feedbackTimestamp: JsonField<OffsetDateTime>) = apply {
            this.feedbackTimestamp = feedbackTimestamp
        }

        fun message(message: String) = message(JsonField.of(message))

        /**
         * Sets [Builder.message] to an arbitrary JSON value.
         *
         * You should usually call [Builder.message] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun message(message: JsonField<String>) = apply { this.message = message }

        fun requestId(requestId: String) = requestId(JsonField.of(requestId))

        /**
         * Sets [Builder.requestId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requestId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

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
         * Returns an immutable instance of [FeedbackSubmitResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): FeedbackSubmitResponse =
            FeedbackSubmitResponse(
                feedbackId,
                feedbackTimestamp,
                message,
                requestId,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): FeedbackSubmitResponse = apply {
        if (validated) {
            return@apply
        }

        feedbackId()
        feedbackTimestamp()
        message()
        requestId()
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
        (if (feedbackId.asKnown().isPresent) 1 else 0) +
            (if (feedbackTimestamp.asKnown().isPresent) 1 else 0) +
            (if (message.asKnown().isPresent) 1 else 0) +
            (if (requestId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FeedbackSubmitResponse &&
            feedbackId == other.feedbackId &&
            feedbackTimestamp == other.feedbackTimestamp &&
            message == other.message &&
            requestId == other.requestId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(feedbackId, feedbackTimestamp, message, requestId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FeedbackSubmitResponse{feedbackId=$feedbackId, feedbackTimestamp=$feedbackTimestamp, message=$message, requestId=$requestId, additionalProperties=$additionalProperties}"
}
