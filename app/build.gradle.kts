/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/8.1.1/userguide/building_java_projects.html
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.8.10"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.ktor.plugin") version "2.3.1"

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()

    // Add the 'https://m2.dv8tion.net/releases' repository
    maven {
        url = uri("https://m2.dv8tion.net/releases")
    }
    maven {
        url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
    }
    maven("https://maven.kotlindiscord.com/repository/maven-public/")
    maven {
        name = "Sonatype Snapshots"
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }
    maven { url = uri("https://jitpack.io") }
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
    maven {
        name = "topiWTFReleases"
        url = uri("https://maven.topi.wtf/releases")
    }
}

dependencies {
    // Use the Kotlin JUnit 5 integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    // Use the JUnit 5 integration.
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:31.1-jre")

    implementation("dev.kord:kord-core:0.9.0")

    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")

    // https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
    implementation("ch.qos.logback:logback-classic:1.4.7")

    implementation("dev.schlaubi.lavakord:kord:4.1.0")
    // List of artifacts, e.g.:
    implementation("io.ktor:ktor-server-core-jvm:2.3.1")
    implementation("io.ktor:ktor-server-netty-jvm:2.3.1")
    implementation("io.ktor:ktor-server-status-pages-jvm:2.3.1")
    implementation("io.ktor:ktor-server-default-headers-jvm:2.3.1")
    implementation("io.ktor:ktor-server-cors:2.3.1")
    implementation("io.ktor:ktor-client-core:2.3.1")
    implementation("io.ktor:ktor-client-json:2.3.1")
    implementation("io.ktor:ktor-client-gson:2.3.1")
    implementation("io.ktor:ktor-client-apache:2.3.1")
//    implementation("com.kotlindiscord.kord.extensions:kord-extensions:1.5.7")

    implementation("com.github.TopiSenpai.LavaSrc:lavasrc-plugin:3.2.4")


}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    // Define the main class for the application.
    mainClass.set("dev.nthduc.hoshino.AppKt")
}

tasks.shadowJar {
    archiveFileName.set("hoshino.jar")
    archiveClassifier.set("")
    archiveVersion.set("")
    destinationDirectory.set(file("$buildDir/libs"))
}
tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}