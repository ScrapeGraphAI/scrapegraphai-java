// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.generateschema

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.jsonMapper
import com.scrapegraphai.api.errors.ScrapegraphaiInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class GenerateSchemaRetrieveResponseTest {

    @Test
    fun ofCompletedSchemaGeneration() {
        val completedSchemaGeneration =
            GenerateSchemaRetrieveResponse.CompletedSchemaGenerationResponse.builder()
                .error("error")
                .generatedSchema(JsonValue.from(mapOf<String, Any>()))
                .refinedPrompt("refined_prompt")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .status(
                    GenerateSchemaRetrieveResponse.CompletedSchemaGenerationResponse.Status
                        .COMPLETED
                )
                .userPrompt("user_prompt")
                .build()

        val generateSchemaRetrieveResponse =
            GenerateSchemaRetrieveResponse.ofCompletedSchemaGeneration(completedSchemaGeneration)

        assertThat(generateSchemaRetrieveResponse.completedSchemaGeneration())
            .contains(completedSchemaGeneration)
        assertThat(generateSchemaRetrieveResponse.failedSchemaGeneration()).isEmpty
    }

    @Test
    fun ofCompletedSchemaGenerationRoundtrip() {
        val jsonMapper = jsonMapper()
        val generateSchemaRetrieveResponse =
            GenerateSchemaRetrieveResponse.ofCompletedSchemaGeneration(
                GenerateSchemaRetrieveResponse.CompletedSchemaGenerationResponse.builder()
                    .error("error")
                    .generatedSchema(JsonValue.from(mapOf<String, Any>()))
                    .refinedPrompt("refined_prompt")
                    .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .status(
                        GenerateSchemaRetrieveResponse.CompletedSchemaGenerationResponse.Status
                            .COMPLETED
                    )
                    .userPrompt("user_prompt")
                    .build()
            )

        val roundtrippedGenerateSchemaRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(generateSchemaRetrieveResponse),
                jacksonTypeRef<GenerateSchemaRetrieveResponse>(),
            )

        assertThat(roundtrippedGenerateSchemaRetrieveResponse)
            .isEqualTo(generateSchemaRetrieveResponse)
    }

    @Test
    fun ofFailedSchemaGeneration() {
        val failedSchemaGeneration =
            GenerateSchemaRetrieveResponse.FailedSchemaGenerationResponse.builder()
                .error("error")
                .generatedSchema(JsonValue.from(mapOf<String, Any>()))
                .refinedPrompt("refined_prompt")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .status(GenerateSchemaRetrieveResponse.FailedSchemaGenerationResponse.Status.FAILED)
                .userPrompt("user_prompt")
                .build()

        val generateSchemaRetrieveResponse =
            GenerateSchemaRetrieveResponse.ofFailedSchemaGeneration(failedSchemaGeneration)

        assertThat(generateSchemaRetrieveResponse.completedSchemaGeneration()).isEmpty
        assertThat(generateSchemaRetrieveResponse.failedSchemaGeneration())
            .contains(failedSchemaGeneration)
    }

    @Test
    fun ofFailedSchemaGenerationRoundtrip() {
        val jsonMapper = jsonMapper()
        val generateSchemaRetrieveResponse =
            GenerateSchemaRetrieveResponse.ofFailedSchemaGeneration(
                GenerateSchemaRetrieveResponse.FailedSchemaGenerationResponse.builder()
                    .error("error")
                    .generatedSchema(JsonValue.from(mapOf<String, Any>()))
                    .refinedPrompt("refined_prompt")
                    .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .status(
                        GenerateSchemaRetrieveResponse.FailedSchemaGenerationResponse.Status.FAILED
                    )
                    .userPrompt("user_prompt")
                    .build()
            )

        val roundtrippedGenerateSchemaRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(generateSchemaRetrieveResponse),
                jacksonTypeRef<GenerateSchemaRetrieveResponse>(),
            )

        assertThat(roundtrippedGenerateSchemaRetrieveResponse)
            .isEqualTo(generateSchemaRetrieveResponse)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val generateSchemaRetrieveResponse =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<GenerateSchemaRetrieveResponse>())

        val e =
            assertThrows<ScrapegraphaiInvalidDataException> {
                generateSchemaRetrieveResponse.validate()
            }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
