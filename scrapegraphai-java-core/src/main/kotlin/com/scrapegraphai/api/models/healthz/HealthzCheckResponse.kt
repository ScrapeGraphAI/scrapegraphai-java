// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.healthz

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.scrapegraphai.api.core.ExcludeMissing
import com.scrapegraphai.api.core.JsonField
import com.scrapegraphai.api.core.JsonMissing
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.toImmutable
import com.scrapegraphai.api.errors.ScrapegraphaiInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class HealthzCheckResponse
private constructor(
    private val services: JsonField<Services>,
    private val status: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("services") @ExcludeMissing services: JsonField<Services> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
    ) : this(services, status, mutableMapOf())

    /**
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun services(): Optional<Services> = services.getOptional("services")

    /**
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * Returns the raw JSON value of [services].
     *
     * Unlike [services], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("services") @ExcludeMissing fun _services(): JsonField<Services> = services

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

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

        /** Returns a mutable builder for constructing an instance of [HealthzCheckResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [HealthzCheckResponse]. */
    class Builder internal constructor() {

        private var services: JsonField<Services> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(healthzCheckResponse: HealthzCheckResponse) = apply {
            services = healthzCheckResponse.services
            status = healthzCheckResponse.status
            additionalProperties = healthzCheckResponse.additionalProperties.toMutableMap()
        }

        fun services(services: Services) = services(JsonField.of(services))

        /**
         * Sets [Builder.services] to an arbitrary JSON value.
         *
         * You should usually call [Builder.services] with a well-typed [Services] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun services(services: JsonField<Services>) = apply { this.services = services }

        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

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
         * Returns an immutable instance of [HealthzCheckResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): HealthzCheckResponse =
            HealthzCheckResponse(services, status, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): HealthzCheckResponse = apply {
        if (validated) {
            return@apply
        }

        services().ifPresent { it.validate() }
        status()
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
        (services.asKnown().getOrNull()?.validity() ?: 0) +
            (if (status.asKnown().isPresent) 1 else 0)

    class Services
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

            /** Returns a mutable builder for constructing an instance of [Services]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Services]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(services: Services) = apply {
                additionalProperties = services.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Services].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Services = Services(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Services = apply {
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

            return /* spotless:off */ other is Services && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Services{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is HealthzCheckResponse && services == other.services && status == other.status && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(services, status, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "HealthzCheckResponse{services=$services, status=$status, additionalProperties=$additionalProperties}"
}
