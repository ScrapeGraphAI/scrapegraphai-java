// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.healthz

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HealthzCheckResponseTest {

    @Test
    fun create() {
        val healthzCheckResponse =
            HealthzCheckResponse.builder()
                .services(
                    HealthzCheckResponse.Services.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .status("healthy")
                .build()

        assertThat(healthzCheckResponse.services())
            .contains(
                HealthzCheckResponse.Services.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(healthzCheckResponse.status()).contains("healthy")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val healthzCheckResponse =
            HealthzCheckResponse.builder()
                .services(
                    HealthzCheckResponse.Services.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .status("healthy")
                .build()

        val roundtrippedHealthzCheckResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(healthzCheckResponse),
                jacksonTypeRef<HealthzCheckResponse>(),
            )

        assertThat(roundtrippedHealthzCheckResponse).isEqualTo(healthzCheckResponse)
    }
}
