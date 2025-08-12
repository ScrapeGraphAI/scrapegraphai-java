// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scrapegraphai.api.client.okhttp.ScrapegraphaiOkHttpClient
import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.jsonMapper
import com.scrapegraphai.api.models.smartscraper.CompletedSmartscraper
import com.scrapegraphai.api.models.smartscraper.SmartscraperRetrieveResponse
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream(
                "META-INF/proguard/scrapegraphai-java-core.pro"
            )

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client = ScrapegraphaiOkHttpClient.builder().apiKey("My API Key").build()

        assertThat(client).isNotNull()
        assertThat(client.smartscraper()).isNotNull()
        assertThat(client.markdownify()).isNotNull()
        assertThat(client.searchscraper()).isNotNull()
        assertThat(client.generateSchema()).isNotNull()
        assertThat(client.crawl()).isNotNull()
        assertThat(client.credits()).isNotNull()
        assertThat(client.validate()).isNotNull()
        assertThat(client.feedback()).isNotNull()
        assertThat(client.healthz()).isNotNull()
    }

    @Test
    fun completedSmartscraperRoundtrip() {
        val jsonMapper = jsonMapper()
        val completedSmartscraper =
            CompletedSmartscraper.builder()
                .error("error")
                .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .result(JsonValue.from(mapOf<String, Any>()))
                .status(CompletedSmartscraper.Status.QUEUED)
                .userPrompt("user_prompt")
                .websiteUrl("https://example.com")
                .build()

        val roundtrippedCompletedSmartscraper =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(completedSmartscraper),
                jacksonTypeRef<CompletedSmartscraper>(),
            )

        assertThat(roundtrippedCompletedSmartscraper).isEqualTo(completedSmartscraper)
    }

    @Test
    fun smartscraperRetrieveResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val smartscraperRetrieveResponse =
            SmartscraperRetrieveResponse.ofCompletedSmartscraper(
                CompletedSmartscraper.builder()
                    .error("error")
                    .requestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .result(JsonValue.from(mapOf<String, Any>()))
                    .status(CompletedSmartscraper.Status.QUEUED)
                    .userPrompt("user_prompt")
                    .websiteUrl("https://example.com")
                    .build()
            )

        val roundtrippedSmartscraperRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(smartscraperRetrieveResponse),
                jacksonTypeRef<SmartscraperRetrieveResponse>(),
            )

        assertThat(roundtrippedSmartscraperRetrieveResponse).isEqualTo(smartscraperRetrieveResponse)
    }
}
