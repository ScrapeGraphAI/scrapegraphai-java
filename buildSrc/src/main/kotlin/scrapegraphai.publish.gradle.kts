plugins {
    `maven-publish`
    signing
}

configure<PublishingExtension> {
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("ScrapeGraphAI API")
                description.set("FastAPI-based web scraping service that provides intelligent content extraction\nand processing capabilities. The API offers multiple scraping endpoints with\nLLM-powered content analysis, supporting various providers and caching\nmechanisms.")
                url.set("https://scrapegraphai.com")

                licenses {
                    license {
                        name.set("Apache-2.0")
                    }
                }

                developers {
                    developer {
                        name.set("Scrapegraphai")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/stainless-sdks/scrapegraphai-java.git")
                    developerConnection.set("scm:git:git://github.com/stainless-sdks/scrapegraphai-java.git")
                    url.set("https://github.com/stainless-sdks/scrapegraphai-java")
                }

                versionMapping {
                    allVariants {
                        fromResolutionResult()
                    }
                }
            }
        }
    }
}

signing {
    val signingKeyId = System.getenv("GPG_SIGNING_KEY_ID")?.ifBlank { null }
    val signingKey = System.getenv("GPG_SIGNING_KEY")?.ifBlank { null }
    val signingPassword = System.getenv("GPG_SIGNING_PASSWORD")?.ifBlank { null }
    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(
            signingKeyId,
            signingKey,
            signingPassword,
        )
        sign(publishing.publications["maven"])
    }
}

tasks.named("publish") {
    dependsOn(":closeAndReleaseSonatypeStagingRepository")
}
