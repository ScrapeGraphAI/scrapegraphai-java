// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.markdownify

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
import com.scrapegraphai.api.core.getOrThrow
import com.scrapegraphai.api.errors.ScrapegraphaiInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@JsonDeserialize(using = MarkdownifyRetrieveStatusResponse.Deserializer::class)
@JsonSerialize(using = MarkdownifyRetrieveStatusResponse.Serializer::class)
class MarkdownifyRetrieveStatusResponse
private constructor(
    private val completedMarkdownify: CompletedMarkdownify? = null,
    private val failedMarkdownify: FailedMarkdownifyResponse? = null,
    private val _json: JsonValue? = null,
) {

    fun completedMarkdownify(): Optional<CompletedMarkdownify> =
        Optional.ofNullable(completedMarkdownify)

    fun failedMarkdownify(): Optional<FailedMarkdownifyResponse> =
        Optional.ofNullable(failedMarkdownify)

    fun isCompletedMarkdownify(): Boolean = completedMarkdownify != null

    fun isFailedMarkdownify(): Boolean = failedMarkdownify != null

    fun asCompletedMarkdownify(): CompletedMarkdownify =
        completedMarkdownify.getOrThrow("completedMarkdownify")

    fun asFailedMarkdownify(): FailedMarkdownifyResponse =
        failedMarkdownify.getOrThrow("failedMarkdownify")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            completedMarkdownify != null -> visitor.visitCompletedMarkdownify(completedMarkdownify)
            failedMarkdownify != null -> visitor.visitFailedMarkdownify(failedMarkdownify)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): MarkdownifyRetrieveStatusResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitCompletedMarkdownify(completedMarkdownify: CompletedMarkdownify) {
                    completedMarkdownify.validate()
                }

                override fun visitFailedMarkdownify(failedMarkdownify: FailedMarkdownifyResponse) {
                    failedMarkdownify.validate()
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
                override fun visitCompletedMarkdownify(completedMarkdownify: CompletedMarkdownify) =
                    completedMarkdownify.validity()

                override fun visitFailedMarkdownify(failedMarkdownify: FailedMarkdownifyResponse) =
                    failedMarkdownify.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MarkdownifyRetrieveStatusResponse && completedMarkdownify == other.completedMarkdownify && failedMarkdownify == other.failedMarkdownify /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(completedMarkdownify, failedMarkdownify) /* spotless:on */

    override fun toString(): String =
        when {
            completedMarkdownify != null ->
                "MarkdownifyRetrieveStatusResponse{completedMarkdownify=$completedMarkdownify}"
            failedMarkdownify != null ->
                "MarkdownifyRetrieveStatusResponse{failedMarkdownify=$failedMarkdownify}"
            _json != null -> "MarkdownifyRetrieveStatusResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid MarkdownifyRetrieveStatusResponse")
        }

    companion object {

        @JvmStatic
        fun ofCompletedMarkdownify(completedMarkdownify: CompletedMarkdownify) =
            MarkdownifyRetrieveStatusResponse(completedMarkdownify = completedMarkdownify)

        @JvmStatic
        fun ofFailedMarkdownify(failedMarkdownify: FailedMarkdownifyResponse) =
            MarkdownifyRetrieveStatusResponse(failedMarkdownify = failedMarkdownify)
    }

    /**
     * An interface that defines how to map each variant of [MarkdownifyRetrieveStatusResponse] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        fun visitCompletedMarkdownify(completedMarkdownify: CompletedMarkdownify): T

        fun visitFailedMarkdownify(failedMarkdownify: FailedMarkdownifyResponse): T

        /**
         * Maps an unknown variant of [MarkdownifyRetrieveStatusResponse] to a value of type [T].
         *
         * An instance of [MarkdownifyRetrieveStatusResponse] can contain an unknown variant if it
         * was deserialized from data that doesn't match any known variant. For example, if the SDK
         * is on an older version than the API, then the API may respond with new variants that the
         * SDK is unaware of.
         *
         * @throws ScrapegraphaiInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw ScrapegraphaiInvalidDataException(
                "Unknown MarkdownifyRetrieveStatusResponse: $json"
            )
        }
    }

    internal class Deserializer :
        BaseDeserializer<MarkdownifyRetrieveStatusResponse>(
            MarkdownifyRetrieveStatusResponse::class
        ) {

        override fun ObjectCodec.deserialize(node: JsonNode): MarkdownifyRetrieveStatusResponse {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<CompletedMarkdownify>())?.let {
                            MarkdownifyRetrieveStatusResponse(
                                completedMarkdownify = it,
                                _json = json,
                            )
                        },
                        tryDeserialize(node, jacksonTypeRef<FailedMarkdownifyResponse>())?.let {
                            MarkdownifyRetrieveStatusResponse(failedMarkdownify = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> MarkdownifyRetrieveStatusResponse(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<MarkdownifyRetrieveStatusResponse>(
            MarkdownifyRetrieveStatusResponse::class
        ) {

        override fun serialize(
            value: MarkdownifyRetrieveStatusResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.completedMarkdownify != null ->
                    generator.writeObject(value.completedMarkdownify)
                value.failedMarkdownify != null -> generator.writeObject(value.failedMarkdownify)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid MarkdownifyRetrieveStatusResponse")
            }
        }
    }

    class FailedMarkdownifyResponse
    private constructor(
        private val error: JsonField<String>,
        private val requestId: JsonField<String>,
        private val result: JsonField<String>,
        private val status: JsonField<Status>,
        private val websiteUrl: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("error") @ExcludeMissing error: JsonField<String> = JsonMissing.of(),
            @JsonProperty("request_id")
            @ExcludeMissing
            requestId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("result") @ExcludeMissing result: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("website_url")
            @ExcludeMissing
            websiteUrl: JsonField<String> = JsonMissing.of(),
        ) : this(error, requestId, result, status, websiteUrl, mutableMapOf())

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun error(): Optional<String> = error.getOptional("error")

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun requestId(): Optional<String> = requestId.getOptional("request_id")

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun result(): Optional<String> = result.getOptional("result")

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun status(): Optional<Status> = status.getOptional("status")

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun websiteUrl(): Optional<String> = websiteUrl.getOptional("website_url")

        /**
         * Returns the raw JSON value of [error].
         *
         * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<String> = error

        /**
         * Returns the raw JSON value of [requestId].
         *
         * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("request_id") @ExcludeMissing fun _requestId(): JsonField<String> = requestId

        /**
         * Returns the raw JSON value of [result].
         *
         * Unlike [result], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("result") @ExcludeMissing fun _result(): JsonField<String> = result

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
             * Returns a mutable builder for constructing an instance of
             * [FailedMarkdownifyResponse].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FailedMarkdownifyResponse]. */
        class Builder internal constructor() {

            private var error: JsonField<String> = JsonMissing.of()
            private var requestId: JsonField<String> = JsonMissing.of()
            private var result: JsonField<String> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var websiteUrl: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(failedMarkdownifyResponse: FailedMarkdownifyResponse) = apply {
                error = failedMarkdownifyResponse.error
                requestId = failedMarkdownifyResponse.requestId
                result = failedMarkdownifyResponse.result
                status = failedMarkdownifyResponse.status
                websiteUrl = failedMarkdownifyResponse.websiteUrl
                additionalProperties = failedMarkdownifyResponse.additionalProperties.toMutableMap()
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

            fun requestId(requestId: String) = requestId(JsonField.of(requestId))

            /**
             * Sets [Builder.requestId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

            fun result(result: String?) = result(JsonField.ofNullable(result))

            /** Alias for calling [Builder.result] with `result.orElse(null)`. */
            fun result(result: Optional<String>) = result(result.getOrNull())

            /**
             * Sets [Builder.result] to an arbitrary JSON value.
             *
             * You should usually call [Builder.result] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun result(result: JsonField<String>) = apply { this.result = result }

            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

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
             * Returns an immutable instance of [FailedMarkdownifyResponse].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): FailedMarkdownifyResponse =
                FailedMarkdownifyResponse(
                    error,
                    requestId,
                    result,
                    status,
                    websiteUrl,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): FailedMarkdownifyResponse = apply {
            if (validated) {
                return@apply
            }

            error()
            requestId()
            result()
            status().ifPresent { it.validate() }
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
            (if (error.asKnown().isPresent) 1 else 0) +
                (if (requestId.asKnown().isPresent) 1 else 0) +
                (if (result.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (websiteUrl.asKnown().isPresent) 1 else 0)

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

            return /* spotless:off */ other is FailedMarkdownifyResponse && error == other.error && requestId == other.requestId && result == other.result && status == other.status && websiteUrl == other.websiteUrl && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(error, requestId, result, status, websiteUrl, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FailedMarkdownifyResponse{error=$error, requestId=$requestId, result=$result, status=$status, websiteUrl=$websiteUrl, additionalProperties=$additionalProperties}"
    }
}
