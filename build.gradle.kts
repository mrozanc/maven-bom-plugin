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
    implementation("org.apache.maven.plugins:maven-help-plugin:3.4.0")
    implementation(libs.bundles.maven)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")

    testImplementation(gradleTestKit())
    testImplementation("io.kotest:kotest-assertions-core:5.5.5")
    testImplementation("io.kotest:kotest-runner-junit5:5.5.5")
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
