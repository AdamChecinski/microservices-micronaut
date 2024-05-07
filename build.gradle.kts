plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.23"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.23"
    id("com.google.devtools.ksp") version "1.9.23-1.0.19"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.aot") version "4.3.8"
}

version = "0.1"
group = "com.microservices"

repositories {
    mavenCentral()
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
}






