// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.blocking

import com.scrapegraphai.api.TestServerExtension
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClient
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.models.generateschema.GenerateSchemaCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class GenerateSchemaServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            ScrapegraphaiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val generateSchemaService = client.generateSchema()

        val generateSchema =
            generateSchemaService.create(
                GenerateSchemaCreateParams.builder()
                    .userPrompt(
                        "Create a schema for product information including name, price, and reviews"
                    )
                    .existingSchema(JsonValue.from(mapOf<String, Any>()))
                    .build()
            )

        generateSchema.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            ScrapegraphaiOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val generateSchemaService = client.generateSchema()

        val generateSchema = generateSchemaService.retrieve("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        generateSchema.validate()
    }
}
