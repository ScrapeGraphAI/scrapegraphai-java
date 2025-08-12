// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.models.credits

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreditRetrieveResponseTest {

    @Test
    fun create() {
        val creditRetrieveResponse =
            CreditRetrieveResponse.builder().remainingCredits(0L).totalCreditsUsed(0L).build()

        assertThat(creditRetrieveResponse.remainingCredits()).contains(0L)
        assertThat(creditRetrieveResponse.totalCreditsUsed()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val creditRetrieveResponse =
            CreditRetrieveResponse.builder().remainingCredits(0L).totalCreditsUsed(0L).build()

        val roundtrippedCreditRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(creditRetrieveResponse),
                jacksonTypeRef<CreditRetrieveResponse>(),
            )

        assertThat(roundtrippedCreditRetrieveResponse).isEqualTo(creditRetrieveResponse)
    }
}
