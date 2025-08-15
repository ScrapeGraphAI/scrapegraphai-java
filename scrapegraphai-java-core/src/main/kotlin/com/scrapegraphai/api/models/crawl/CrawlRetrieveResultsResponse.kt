// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.crawl

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

class CrawlRetrieveResultsResponse
private constructor(
    private val result: JsonField<Result>,
    private val status: JsonField<Status>,
    private val taskId: JsonField<String>,
    private val traceback: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("result") @ExcludeMissing result: JsonField<Result> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("task_id") @ExcludeMissing taskId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("traceback") @ExcludeMissing traceback: JsonField<String> = JsonMissing.of(),
    ) : this(result, status, taskId, traceback, mutableMapOf())

    /**
     * Successful crawl results
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun result(): Optional<Result> = result.getOptional("result")

    /**
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun status(): Optional<Status> = status.getOptional("status")

    /**
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun taskId(): Optional<String> = taskId.getOptional("task_id")

    /**
     * Error traceback for failed tasks
     *
     * @throws ScrapegraphaiInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun traceback(): Optional<String> = traceback.getOptional("traceback")

    /**
     * Returns the raw JSON value of [result].
     *
     * Unlike [result], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("result") @ExcludeMissing fun _result(): JsonField<Result> = result

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [taskId].
     *
     * Unlike [taskId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("task_id") @ExcludeMissing fun _taskId(): JsonField<String> = taskId

    /**
     * Returns the raw JSON value of [traceback].
     *
     * Unlike [traceback], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("traceback") @ExcludeMissing fun _traceback(): JsonField<String> = traceback

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
         * Returns a mutable builder for constructing an instance of [CrawlRetrieveResultsResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CrawlRetrieveResultsResponse]. */
    class Builder internal constructor() {

        private var result: JsonField<Result> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var taskId: JsonField<String> = JsonMissing.of()
        private var traceback: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(crawlRetrieveResultsResponse: CrawlRetrieveResultsResponse) = apply {
            result = crawlRetrieveResultsResponse.result
            status = crawlRetrieveResultsResponse.status
            taskId = crawlRetrieveResultsResponse.taskId
            traceback = crawlRetrieveResultsResponse.traceback
            additionalProperties = crawlRetrieveResultsResponse.additionalProperties.toMutableMap()
        }

        /** Successful crawl results */
        fun result(result: Result) = result(JsonField.of(result))

        /**
         * Sets [Builder.result] to an arbitrary JSON value.
         *
         * You should usually call [Builder.result] with a well-typed [Result] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun result(result: JsonField<Result>) = apply { this.result = result }

        /** Alias for calling [result] with `Result.ofJsonValue(jsonValue)`. */
        fun result(jsonValue: JsonValue) = result(Result.ofJsonValue(jsonValue))

        /** Alias for calling [result] with `Result.ofString(string)`. */
        fun result(string: String) = result(Result.ofString(string))

        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        fun taskId(taskId: String) = taskId(JsonField.of(taskId))

        /**
         * Sets [Builder.taskId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.taskId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun taskId(taskId: JsonField<String>) = apply { this.taskId = taskId }

        /** Error traceback for failed tasks */
        fun traceback(traceback: String?) = traceback(JsonField.ofNullable(traceback))

        /** Alias for calling [Builder.traceback] with `traceback.orElse(null)`. */
        fun traceback(traceback: Optional<String>) = traceback(traceback.getOrNull())

        /**
         * Sets [Builder.traceback] to an arbitrary JSON value.
         *
         * You should usually call [Builder.traceback] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun traceback(traceback: JsonField<String>) = apply { this.traceback = traceback }

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
         * Returns an immutable instance of [CrawlRetrieveResultsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CrawlRetrieveResultsResponse =
            CrawlRetrieveResultsResponse(
                result,
                status,
                taskId,
                traceback,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CrawlRetrieveResultsResponse = apply {
        if (validated) {
            return@apply
        }

        result().ifPresent { it.validate() }
        status().ifPresent { it.validate() }
        taskId()
        traceback()
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
        (result.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (taskId.asKnown().isPresent) 1 else 0) +
            (if (traceback.asKnown().isPresent) 1 else 0)

    /** Successful crawl results */
    @JsonDeserialize(using = Result.Deserializer::class)
    @JsonSerialize(using = Result.Serializer::class)
    class Result
    private constructor(
        private val jsonValue: JsonValue? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Successful crawl results */
        fun jsonValue(): Optional<JsonValue> = Optional.ofNullable(jsonValue)

        /** Error message */
        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isJsonValue(): Boolean = jsonValue != null

        fun isString(): Boolean = string != null

        /** Successful crawl results */
        fun asJsonValue(): JsonValue = jsonValue.getOrThrow("jsonValue")

        /** Error message */
        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                jsonValue != null -> visitor.visitJsonValue(jsonValue)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Result = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitJsonValue(jsonValue: JsonValue) {}

                    override fun visitString(string: String) {}
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitJsonValue(jsonValue: JsonValue) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Result && jsonValue == other.jsonValue && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(jsonValue, string)

        override fun toString(): String =
            when {
                jsonValue != null -> "Result{jsonValue=$jsonValue}"
                string != null -> "Result{string=$string}"
                _json != null -> "Result{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Result")
            }

        companion object {

            /** Successful crawl results */
            @JvmStatic fun ofJsonValue(jsonValue: JsonValue) = Result(jsonValue = jsonValue)

            /** Error message */
            @JvmStatic fun ofString(string: String) = Result(string = string)
        }

        /** An interface that defines how to map each variant of [Result] to a value of type [T]. */
        interface Visitor<out T> {

            /** Successful crawl results */
            fun visitJsonValue(jsonValue: JsonValue): T

            /** Error message */
            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Result] to a value of type [T].
             *
             * An instance of [Result] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ScrapegraphaiInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ScrapegraphaiInvalidDataException("Unknown Result: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Result>(Result::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Result {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Result(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())?.let {
                                Result(jsonValue = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants.
                    0 -> Result(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Result>(Result::class) {

            override fun serialize(
                value: Result,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.jsonValue != null -> generator.writeObject(value.jsonValue)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Result")
                }
            }
        }
    }

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

            @JvmField val PENDING = of("PENDING")

            @JvmField val STARTED = of("STARTED")

            @JvmField val SUCCESS = of("SUCCESS")

            @JvmField val FAILURE = of("FAILURE")

            @JvmField val RETRY = of("RETRY")

            @JvmField val REVOKED = of("REVOKED")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            PENDING,
            STARTED,
            SUCCESS,
            FAILURE,
            RETRY,
            REVOKED,
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
            PENDING,
            STARTED,
            SUCCESS,
            FAILURE,
            RETRY,
            REVOKED,
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
                PENDING -> Value.PENDING
                STARTED -> Value.STARTED
                SUCCESS -> Value.SUCCESS
                FAILURE -> Value.FAILURE
                RETRY -> Value.RETRY
                REVOKED -> Value.REVOKED
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
                PENDING -> Known.PENDING
                STARTED -> Known.STARTED
                SUCCESS -> Known.SUCCESS
                FAILURE -> Known.FAILURE
                RETRY -> Known.RETRY
                REVOKED -> Known.REVOKED
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

        return other is CrawlRetrieveResultsResponse &&
            result == other.result &&
            status == other.status &&
            taskId == other.taskId &&
            traceback == other.traceback &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(result, status, taskId, traceback, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CrawlRetrieveResultsResponse{result=$result, status=$status, taskId=$taskId, traceback=$traceback, additionalProperties=$additionalProperties}"
}
