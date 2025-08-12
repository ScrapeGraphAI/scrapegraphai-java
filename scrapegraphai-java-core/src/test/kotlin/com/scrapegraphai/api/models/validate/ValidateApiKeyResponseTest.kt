// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.validate

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ValidateApiKeyResponseTest {

    @Test
    fun create() {
        val validateApiKeyResponse =
            ValidateApiKeyResponse.builder().email("dev@stainless.com").build()

        assertThat(validateApiKeyResponse.email()).contains("dev@stainless.com")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val validateApiKeyResponse =
            ValidateApiKeyResponse.builder().email("dev@stainless.com").build()

        val roundtrippedValidateApiKeyResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(validateApiKeyResponse),
                jacksonTypeRef<ValidateApiKeyResponse>(),
            )

        assertThat(roundtrippedValidateApiKeyResponse).isEqualTo(validateApiKeyResponse)
    }
}
