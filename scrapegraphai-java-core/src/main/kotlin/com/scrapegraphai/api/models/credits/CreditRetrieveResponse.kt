// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.credits

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.scrapegraphai.api.core.ExcludeMissing
import com.scrapegraphai.api.core.JsonField
import com.scrapegraphai.api.core.JsonMissing
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.errors.ScrapegraphaiInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

class CreditRetrieveResponse
private constructor(
    private val remainingCredits: JsonField<Long>,
    private val totalCreditsUsed: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("remaining_credits")
        @ExcludeMissing
        remainingCredits: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("total_credits_used")
        @ExcludeMissing
        totalCreditsUsed: JsonField<Long> = JsonMissing.of(),
    ) : this(remainingCredits, totalCreditsUsed, mutableMapOf())

    /**
     * Number of credits remaining
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun remainingCredits(): Optional<Long> = remainingCredits.getOptional("remaining_credits")

    /**
     * Total credits consumed
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun totalCreditsUsed(): Optional<Long> = totalCreditsUsed.getOptional("total_credits_used")

    /**
     * Returns the raw JSON value of [remainingCredits].
     *
     * Unlike [remainingCredits], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("remaining_credits")
    @ExcludeMissing
    fun _remainingCredits(): JsonField<Long> = remainingCredits

    /**
     * Returns the raw JSON value of [totalCreditsUsed].
     *
     * Unlike [totalCreditsUsed], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("total_credits_used")
    @ExcludeMissing
    fun _totalCreditsUsed(): JsonField<Long> = totalCreditsUsed

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

        /** Returns a mutable builder for constructing an instance of [CreditRetrieveResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CreditRetrieveResponse]. */
    class Builder internal constructor() {

        private var remainingCredits: JsonField<Long> = JsonMissing.of()
        private var totalCreditsUsed: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(creditRetrieveResponse: CreditRetrieveResponse) = apply {
            remainingCredits = creditRetrieveResponse.remainingCredits
            totalCreditsUsed = creditRetrieveResponse.totalCreditsUsed
            additionalProperties = creditRetrieveResponse.additionalProperties.toMutableMap()
        }

        /** Number of credits remaining */
        fun remainingCredits(remainingCredits: Long) =
            remainingCredits(JsonField.of(remainingCredits))

        /**
         * Sets [Builder.remainingCredits] to an arbitrary JSON value.
         *
         * You should usually call [Builder.remainingCredits] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun remainingCredits(remainingCredits: JsonField<Long>) = apply {
            this.remainingCredits = remainingCredits
        }

        /** Total credits consumed */
        fun totalCreditsUsed(totalCreditsUsed: Long) =
            totalCreditsUsed(JsonField.of(totalCreditsUsed))

        /**
         * Sets [Builder.totalCreditsUsed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalCreditsUsed] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun totalCreditsUsed(totalCreditsUsed: JsonField<Long>) = apply {
            this.totalCreditsUsed = totalCreditsUsed
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
         * Returns an immutable instance of [CreditRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CreditRetrieveResponse =
            CreditRetrieveResponse(
                remainingCredits,
                totalCreditsUsed,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CreditRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        remainingCredits()
        totalCreditsUsed()
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
        (if (remainingCredits.asKnown().isPresent) 1 else 0) +
            (if (totalCreditsUsed.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CreditRetrieveResponse &&
            remainingCredits == other.remainingCredits &&
            totalCreditsUsed == other.totalCreditsUsed &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(remainingCredits, totalCreditsUsed, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CreditRetrieveResponse{remainingCredits=$remainingCredits, totalCreditsUsed=$totalCreditsUsed, additionalProperties=$additionalProperties}"
}
