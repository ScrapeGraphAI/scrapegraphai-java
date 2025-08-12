// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.generateschema

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GenerateSchemaCreateResponseTest {

    @Test
    fun create() {
        val generateSchemaCreateResponse =
            GenerateSchemaCreateResponse.builder()
                .error("error")
                .generatedSchema(JsonValue.from(mapOf<String, Any>()))
                .refinedPrompt("refined_prompt")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .status(GenerateSchemaCreateResponse.Status.COMPLETED)
                .userPrompt("user_prompt")
                .build()

        assertThat(generateSchemaCreateResponse.error()).contains("error")
        assertThat(generateSchemaCreateResponse._generatedSchema())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(generateSchemaCreateResponse.refinedPrompt()).contains("refined_prompt")
        assertThat(generateSchemaCreateResponse.requestId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(generateSchemaCreateResponse.status())
            .contains(GenerateSchemaCreateResponse.Status.COMPLETED)
        assertThat(generateSchemaCreateResponse.userPrompt()).contains("user_prompt")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val generateSchemaCreateResponse =
            GenerateSchemaCreateResponse.builder()
                .error("error")
                .generatedSchema(JsonValue.from(mapOf<String, Any>()))
                .refinedPrompt("refined_prompt")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .status(GenerateSchemaCreateResponse.Status.COMPLETED)
                .userPrompt("user_prompt")
                .build()

        val roundtrippedGenerateSchemaCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(generateSchemaCreateResponse),
                jacksonTypeRef<GenerateSchemaCreateResponse>(),
            )

        assertThat(roundtrippedGenerateSchemaCreateResponse).isEqualTo(generateSchemaCreateResponse)
    }
}
