// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.generateschema

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

@JsonDeserialize(using = GenerateSchemaRetrieveResponse.Deserializer::class)
@JsonSerialize(using = GenerateSchemaRetrieveResponse.Serializer::class)
class GenerateSchemaRetrieveResponse
private constructor(
    private val completedSchemaGeneration: CompletedSchemaGenerationResponse? = null,
    private val failedSchemaGeneration: FailedSchemaGenerationResponse? = null,
    private val _json: JsonValue? = null,
) {

    fun completedSchemaGeneration(): Optional<CompletedSchemaGenerationResponse> =
        Optional.ofNullable(completedSchemaGeneration)

    fun failedSchemaGeneration(): Optional<FailedSchemaGenerationResponse> =
        Optional.ofNullable(failedSchemaGeneration)

    fun isCompletedSchemaGeneration(): Boolean = completedSchemaGeneration != null

    fun isFailedSchemaGeneration(): Boolean = failedSchemaGeneration != null

    fun asCompletedSchemaGeneration(): CompletedSchemaGenerationResponse =
        completedSchemaGeneration.getOrThrow("completedSchemaGeneration")

    fun asFailedSchemaGeneration(): FailedSchemaGenerationResponse =
        failedSchemaGeneration.getOrThrow("failedSchemaGeneration")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            completedSchemaGeneration != null ->
                visitor.visitCompletedSchemaGeneration(completedSchemaGeneration)
            failedSchemaGeneration != null ->
                visitor.visitFailedSchemaGeneration(failedSchemaGeneration)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): GenerateSchemaRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitCompletedSchemaGeneration(
                    completedSchemaGeneration: CompletedSchemaGenerationResponse
                ) {
                    completedSchemaGeneration.validate()
                }

                override fun visitFailedSchemaGeneration(
                    failedSchemaGeneration: FailedSchemaGenerationResponse
                ) {
                    failedSchemaGeneration.validate()
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
                override fun visitCompletedSchemaGeneration(
                    completedSchemaGeneration: CompletedSchemaGenerationResponse
                ) = completedSchemaGeneration.validity()

                override fun visitFailedSchemaGeneration(
                    failedSchemaGeneration: FailedSchemaGenerationResponse
                ) = failedSchemaGeneration.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is GenerateSchemaRetrieveResponse && completedSchemaGeneration == other.completedSchemaGeneration && failedSchemaGeneration == other.failedSchemaGeneration /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(completedSchemaGeneration, failedSchemaGeneration) /* spotless:on */

    override fun toString(): String =
        when {
            completedSchemaGeneration != null ->
                "GenerateSchemaRetrieveResponse{completedSchemaGeneration=$completedSchemaGeneration}"
            failedSchemaGeneration != null ->
                "GenerateSchemaRetrieveResponse{failedSchemaGeneration=$failedSchemaGeneration}"
            _json != null -> "GenerateSchemaRetrieveResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid GenerateSchemaRetrieveResponse")
        }

    companion object {

        @JvmStatic
        fun ofCompletedSchemaGeneration(
            completedSchemaGeneration: CompletedSchemaGenerationResponse
        ) = GenerateSchemaRetrieveResponse(completedSchemaGeneration = completedSchemaGeneration)

        @JvmStatic
        fun ofFailedSchemaGeneration(failedSchemaGeneration: FailedSchemaGenerationResponse) =
            GenerateSchemaRetrieveResponse(failedSchemaGeneration = failedSchemaGeneration)
    }

    /**
     * An interface that defines how to map each variant of [GenerateSchemaRetrieveResponse] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        fun visitCompletedSchemaGeneration(
            completedSchemaGeneration: CompletedSchemaGenerationResponse
        ): T

        fun visitFailedSchemaGeneration(failedSchemaGeneration: FailedSchemaGenerationResponse): T

        /**
         * Maps an unknown variant of [GenerateSchemaRetrieveResponse] to a value of type [T].
         *
         * An instance of [GenerateSchemaRetrieveResponse] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws ScrapegraphaiInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw ScrapegraphaiInvalidDataException("Unknown GenerateSchemaRetrieveResponse: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<GenerateSchemaRetrieveResponse>(GenerateSchemaRetrieveResponse::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): GenerateSchemaRetrieveResponse {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<CompletedSchemaGenerationResponse>())
                            ?.let {
                                GenerateSchemaRetrieveResponse(
                                    completedSchemaGeneration = it,
                                    _json = json,
                                )
                            },
                        tryDeserialize(node, jacksonTypeRef<FailedSchemaGenerationResponse>())
                            ?.let {
                                GenerateSchemaRetrieveResponse(
                                    failedSchemaGeneration = it,
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
                0 -> GenerateSchemaRetrieveResponse(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<GenerateSchemaRetrieveResponse>(GenerateSchemaRetrieveResponse::class) {

        override fun serialize(
            value: GenerateSchemaRetrieveResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.completedSchemaGeneration != null ->
                    generator.writeObject(value.completedSchemaGeneration)
                value.failedSchemaGeneration != null ->
                    generator.writeObject(value.failedSchemaGeneration)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid GenerateSchemaRetrieveResponse")
            }
        }
    }

    class CompletedSchemaGenerationResponse
    private constructor(
        private val error: JsonField<String>,
        private val generatedSchema: JsonValue,
        private val refinedPrompt: JsonField<String>,
        private val requestId: JsonField<String>,
        private val status: JsonField<Status>,
        private val userPrompt: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("error") @ExcludeMissing error: JsonField<String> = JsonMissing.of(),
            @JsonProperty("generated_schema")
            @ExcludeMissing
            generatedSchema: JsonValue = JsonMissing.of(),
            @JsonProperty("refined_prompt")
            @ExcludeMissing
            refinedPrompt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("request_id")
            @ExcludeMissing
            requestId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("user_prompt")
            @ExcludeMissing
            userPrompt: JsonField<String> = JsonMissing.of(),
        ) : this(
            error,
            generatedSchema,
            refinedPrompt,
            requestId,
            status,
            userPrompt,
            mutableMapOf(),
        )

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun error(): Optional<String> = error.getOptional("error")

        @JsonProperty("generated_schema")
        @ExcludeMissing
        fun _generatedSchema(): JsonValue = generatedSchema

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun refinedPrompt(): Optional<String> = refinedPrompt.getOptional("refined_prompt")

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun requestId(): Optional<String> = requestId.getOptional("request_id")

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
         * Returns the raw JSON value of [refinedPrompt].
         *
         * Unlike [refinedPrompt], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("refined_prompt")
        @ExcludeMissing
        fun _refinedPrompt(): JsonField<String> = refinedPrompt

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
             * [CompletedSchemaGenerationResponse].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CompletedSchemaGenerationResponse]. */
        class Builder internal constructor() {

            private var error: JsonField<String> = JsonMissing.of()
            private var generatedSchema: JsonValue = JsonMissing.of()
            private var refinedPrompt: JsonField<String> = JsonMissing.of()
            private var requestId: JsonField<String> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var userPrompt: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                completedSchemaGenerationResponse: CompletedSchemaGenerationResponse
            ) = apply {
                error = completedSchemaGenerationResponse.error
                generatedSchema = completedSchemaGenerationResponse.generatedSchema
                refinedPrompt = completedSchemaGenerationResponse.refinedPrompt
                requestId = completedSchemaGenerationResponse.requestId
                status = completedSchemaGenerationResponse.status
                userPrompt = completedSchemaGenerationResponse.userPrompt
                additionalProperties =
                    completedSchemaGenerationResponse.additionalProperties.toMutableMap()
            }

            fun error(error: String?) = error(JsonField.ofNullable(error))

            /** Alias for calling [Builder.error] with `error.orElse(null)`. */
            fun error(error: Optional<String>) = error(error.getOrNull())

            /**
             * Sets [Builder.error] to an arbitrary JSON value.
             *
             * You should usually call [Builder.error] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun error(error: JsonField<String>) = apply { this.error = error }

            fun generatedSchema(generatedSchema: JsonValue) = apply {
                this.generatedSchema = generatedSchema
            }

            fun refinedPrompt(refinedPrompt: String) = refinedPrompt(JsonField.of(refinedPrompt))

            /**
             * Sets [Builder.refinedPrompt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.refinedPrompt] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun refinedPrompt(refinedPrompt: JsonField<String>) = apply {
                this.refinedPrompt = refinedPrompt
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
             * Returns an immutable instance of [CompletedSchemaGenerationResponse].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): CompletedSchemaGenerationResponse =
                CompletedSchemaGenerationResponse(
                    error,
                    generatedSchema,
                    refinedPrompt,
                    requestId,
                    status,
                    userPrompt,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): CompletedSchemaGenerationResponse = apply {
            if (validated) {
                return@apply
            }

            error()
            refinedPrompt()
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
                (if (refinedPrompt.asKnown().isPresent) 1 else 0) +
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

                @JvmField val COMPLETED = of("completed")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                COMPLETED
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
                COMPLETED,
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
                    COMPLETED -> Value.COMPLETED
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
                    COMPLETED -> Known.COMPLETED
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

            return /* spotless:off */ other is CompletedSchemaGenerationResponse && error == other.error && generatedSchema == other.generatedSchema && refinedPrompt == other.refinedPrompt && requestId == other.requestId && status == other.status && userPrompt == other.userPrompt && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(error, generatedSchema, refinedPrompt, requestId, status, userPrompt, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CompletedSchemaGenerationResponse{error=$error, generatedSchema=$generatedSchema, refinedPrompt=$refinedPrompt, requestId=$requestId, status=$status, userPrompt=$userPrompt, additionalProperties=$additionalProperties}"
    }

    class FailedSchemaGenerationResponse
    private constructor(
        private val error: JsonField<String>,
        private val generatedSchema: JsonValue,
        private val refinedPrompt: JsonField<String>,
        private val requestId: JsonField<String>,
        private val status: JsonField<Status>,
        private val userPrompt: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("error") @ExcludeMissing error: JsonField<String> = JsonMissing.of(),
            @JsonProperty("generated_schema")
            @ExcludeMissing
            generatedSchema: JsonValue = JsonMissing.of(),
            @JsonProperty("refined_prompt")
            @ExcludeMissing
            refinedPrompt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("request_id")
            @ExcludeMissing
            requestId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("user_prompt")
            @ExcludeMissing
            userPrompt: JsonField<String> = JsonMissing.of(),
        ) : this(
            error,
            generatedSchema,
            refinedPrompt,
            requestId,
            status,
            userPrompt,
            mutableMapOf(),
        )

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun error(): Optional<String> = error.getOptional("error")

        @JsonProperty("generated_schema")
        @ExcludeMissing
        fun _generatedSchema(): JsonValue = generatedSchema

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun refinedPrompt(): Optional<String> = refinedPrompt.getOptional("refined_prompt")

        /**
         * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g.
         *   if the server responded with an unexpected value).
         */
        fun requestId(): Optional<String> = requestId.getOptional("request_id")

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
         * Returns the raw JSON value of [refinedPrompt].
         *
         * Unlike [refinedPrompt], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("refined_prompt")
        @ExcludeMissing
        fun _refinedPrompt(): JsonField<String> = refinedPrompt

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
             * [FailedSchemaGenerationResponse].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FailedSchemaGenerationResponse]. */
        class Builder internal constructor() {

            private var error: JsonField<String> = JsonMissing.of()
            private var generatedSchema: JsonValue = JsonMissing.of()
            private var refinedPrompt: JsonField<String> = JsonMissing.of()
            private var requestId: JsonField<String> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var userPrompt: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(failedSchemaGenerationResponse: FailedSchemaGenerationResponse) =
                apply {
                    error = failedSchemaGenerationResponse.error
                    generatedSchema = failedSchemaGenerationResponse.generatedSchema
                    refinedPrompt = failedSchemaGenerationResponse.refinedPrompt
                    requestId = failedSchemaGenerationResponse.requestId
                    status = failedSchemaGenerationResponse.status
                    userPrompt = failedSchemaGenerationResponse.userPrompt
                    additionalProperties =
                        failedSchemaGenerationResponse.additionalProperties.toMutableMap()
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

            fun generatedSchema(generatedSchema: JsonValue) = apply {
                this.generatedSchema = generatedSchema
            }

            fun refinedPrompt(refinedPrompt: String?) =
                refinedPrompt(JsonField.ofNullable(refinedPrompt))

            /** Alias for calling [Builder.refinedPrompt] with `refinedPrompt.orElse(null)`. */
            fun refinedPrompt(refinedPrompt: Optional<String>) =
                refinedPrompt(refinedPrompt.getOrNull())

            /**
             * Sets [Builder.refinedPrompt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.refinedPrompt] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun refinedPrompt(refinedPrompt: JsonField<String>) = apply {
                this.refinedPrompt = refinedPrompt
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
             * Returns an immutable instance of [FailedSchemaGenerationResponse].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): FailedSchemaGenerationResponse =
                FailedSchemaGenerationResponse(
                    error,
                    generatedSchema,
                    refinedPrompt,
                    requestId,
                    status,
                    userPrompt,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): FailedSchemaGenerationResponse = apply {
            if (validated) {
                return@apply
            }

            error()
            refinedPrompt()
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
                (if (refinedPrompt.asKnown().isPresent) 1 else 0) +
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

            return /* spotless:off */ other is FailedSchemaGenerationResponse && error == other.error && generatedSchema == other.generatedSchema && refinedPrompt == other.refinedPrompt && requestId == other.requestId && status == other.status && userPrompt == other.userPrompt && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(error, generatedSchema, refinedPrompt, requestId, status, userPrompt, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FailedSchemaGenerationResponse{error=$error, generatedSchema=$generatedSchema, refinedPrompt=$refinedPrompt, requestId=$requestId, status=$status, userPrompt=$userPrompt, additionalProperties=$additionalProperties}"
    }
}
