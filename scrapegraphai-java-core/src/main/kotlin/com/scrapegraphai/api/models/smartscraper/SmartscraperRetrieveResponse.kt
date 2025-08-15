// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.smartscraper

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.core.BaseDeserializer
import com.scrapegraphai.api.core.BaseSerializer
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.allMaxBy
import com.scrapegraphai.api.core.getOrThrow
import com.scrapegraphai.api.errors.ScrapegraphaiInvalidDataException
import java.util.Objects
import java.util.Optional

@JsonDeserialize(using = SmartscraperRetrieveResponse.Deserializer::class)
@JsonSerialize(using = SmartscraperRetrieveResponse.Serializer::class)
class SmartscraperRetrieveResponse
private constructor(
    private val completedSmartscraper: CompletedSmartscraper? = null,
    private val failedSmartscraper: FailedSmartscraper? = null,
    private val _json: JsonValue? = null,
) {

    fun completedSmartscraper(): Optional<CompletedSmartscraper> =
        Optional.ofNullable(completedSmartscraper)

    fun failedSmartscraper(): Optional<FailedSmartscraper> = Optional.ofNullable(failedSmartscraper)

    fun isCompletedSmartscraper(): Boolean = completedSmartscraper != null

    fun isFailedSmartscraper(): Boolean = failedSmartscraper != null

    fun asCompletedSmartscraper(): CompletedSmartscraper =
        completedSmartscraper.getOrThrow("completedSmartscraper")

    fun asFailedSmartscraper(): FailedSmartscraper =
        failedSmartscraper.getOrThrow("failedSmartscraper")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            completedSmartscraper != null ->
                visitor.visitCompletedSmartscraper(completedSmartscraper)
            failedSmartscraper != null -> visitor.visitFailedSmartscraper(failedSmartscraper)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): SmartscraperRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitCompletedSmartscraper(
                    completedSmartscraper: CompletedSmartscraper
                ) {
                    completedSmartscraper.validate()
                }

                override fun visitFailedSmartscraper(failedSmartscraper: FailedSmartscraper) {
                    failedSmartscraper.validate()
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
                override fun visitCompletedSmartscraper(
                    completedSmartscraper: CompletedSmartscraper
                ) = completedSmartscraper.validity()

                override fun visitFailedSmartscraper(failedSmartscraper: FailedSmartscraper) =
                    failedSmartscraper.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SmartscraperRetrieveResponse &&
            completedSmartscraper == other.completedSmartscraper &&
            failedSmartscraper == other.failedSmartscraper
    }

    override fun hashCode(): Int = Objects.hash(completedSmartscraper, failedSmartscraper)

    override fun toString(): String =
        when {
            completedSmartscraper != null ->
                "SmartscraperRetrieveResponse{completedSmartscraper=$completedSmartscraper}"
            failedSmartscraper != null ->
                "SmartscraperRetrieveResponse{failedSmartscraper=$failedSmartscraper}"
            _json != null -> "SmartscraperRetrieveResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid SmartscraperRetrieveResponse")
        }

    companion object {

        @JvmStatic
        fun ofCompletedSmartscraper(completedSmartscraper: CompletedSmartscraper) =
            SmartscraperRetrieveResponse(completedSmartscraper = completedSmartscraper)

        @JvmStatic
        fun ofFailedSmartscraper(failedSmartscraper: FailedSmartscraper) =
            SmartscraperRetrieveResponse(failedSmartscraper = failedSmartscraper)
    }

    /**
     * An interface that defines how to map each variant of [SmartscraperRetrieveResponse] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        fun visitCompletedSmartscraper(completedSmartscraper: CompletedSmartscraper): T

        fun visitFailedSmartscraper(failedSmartscraper: FailedSmartscraper): T

        /**
         * Maps an unknown variant of [SmartscraperRetrieveResponse] to a value of type [T].
         *
         * An instance of [SmartscraperRetrieveResponse] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws ScrapegraphaiInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw ScrapegraphaiInvalidDataException("Unknown SmartscraperRetrieveResponse: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<SmartscraperRetrieveResponse>(SmartscraperRetrieveResponse::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): SmartscraperRetrieveResponse {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<CompletedSmartscraper>())?.let {
                            SmartscraperRetrieveResponse(completedSmartscraper = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<FailedSmartscraper>())?.let {
                            SmartscraperRetrieveResponse(failedSmartscraper = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> SmartscraperRetrieveResponse(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<SmartscraperRetrieveResponse>(SmartscraperRetrieveResponse::class) {

        override fun serialize(
            value: SmartscraperRetrieveResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.completedSmartscraper != null ->
                    generator.writeObject(value.completedSmartscraper)
                value.failedSmartscraper != null -> generator.writeObject(value.failedSmartscraper)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid SmartscraperRetrieveResponse")
            }
        }
    }
}
