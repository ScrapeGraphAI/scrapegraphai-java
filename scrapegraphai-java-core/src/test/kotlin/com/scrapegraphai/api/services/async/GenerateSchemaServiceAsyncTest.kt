// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.services.async

import com.scrapegraphai.api.TestServerExtension
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClientAsync
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.models.generateschema.GenerateSchemaCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class GenerateSchemaServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            ScrapegraphaiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val generateSchemaServiceAsync = client.generateSchema()

        val generateSchemaFuture =
            generateSchemaServiceAsync.create(
                GenerateSchemaCreateParams.builder()
                    .userPrompt(
                        "Create a schema for product information including name, price, and reviews"
                    )
                    .existingSchema(JsonValue.from(mapOf<String, Any>()))
                    .build()
            )

        val generateSchema = generateSchemaFuture.get()
        generateSchema.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            ScrapegraphaiOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val generateSchemaServiceAsync = client.generateSchema()

        val generateSchemaFuture =
            generateSchemaServiceAsync.retrieve("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        val generateSchema = generateSchemaFuture.get()
        generateSchema.validate()
    }
}
