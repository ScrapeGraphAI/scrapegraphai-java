plugins {
    id("scrapegraphai.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":scrapegraphai-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :scrapegraphai-java-example:run` to run `Main`
    // Use `./gradlew :scrapegraphai-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.scrapegraphai.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
