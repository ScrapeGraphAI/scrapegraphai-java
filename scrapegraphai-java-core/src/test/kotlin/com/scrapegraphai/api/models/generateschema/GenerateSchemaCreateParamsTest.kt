// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.generateschema

import com.scrapegraphai.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GenerateSchemaCreateParamsTest {

    @Test
    fun create() {
        GenerateSchemaCreateParams.builder()
            .userPrompt(
                "Create a schema for product information including name, price, and reviews"
            )
            .existingSchema(JsonValue.from(mapOf<String, Any>()))
            .build()
    }

    @Test
    fun body() {
        val params =
            GenerateSchemaCreateParams.builder()
                .userPrompt(
                    "Create a schema for product information including name, price, and reviews"
                )
                .existingSchema(JsonValue.from(mapOf<String, Any>()))
                .build()

        val body = params._body()

        assertThat(body.userPrompt())
            .isEqualTo("Create a schema for product information including name, price, and reviews")
        assertThat(body._existingSchema()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            GenerateSchemaCreateParams.builder()
                .userPrompt(
                    "Create a schema for product information including name, price, and reviews"
                )
                .build()

        val body = params._body()

        assertThat(body.userPrompt())
            .isEqualTo("Create a schema for product information including name, price, and reviews")
    }
}
