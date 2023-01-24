import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-gradle-plugin`
    kotlin("jvm") version embeddedKotlinVersion
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

gradlePlugin {
    plugins {
        create("mavenBomPlugin") {
            id = "fr.rozanc.maven.bom"
            implementationClass = "fr.rozanc.gradle.plugin.maven.bom.MavenBomPlugin"
        }
    }
}

dependencies {
    implementation(platform(embeddedKotlin("bom")))
    implementation("org.apache.maven:maven-model") {
        version {
            strictly("3+")
            prefer("[3.8,4.0)")
        }
    }
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    testImplementation(gradleTestKit())
    testImplementation("io.kotest:kotest-assertions-core:5.5.4")
    testImplementation("io.kotest:kotest-runner-junit5:5.5.4")
    testImplementation(kotlin("test"))
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
    withType<Test> {
        useJUnitPlatform()
    }
}
