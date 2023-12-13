package org.gradle.kotlin.dsl

import fr.rozanc.gradle.plugin.maven.bom.utils.MavenModelReader
import org.gradle.api.artifacts.dsl.DependencyConstraintHandler
import org.gradle.api.initialization.dsl.VersionCatalogBuilder
import java.io.File

fun DependencyConstraintHandler.fromMavenProject(mavenProjectDir: File) {
    MavenModelReader.readProject(mavenProjectDir)
        .filter { it.model.packaging == "jar" }
        .sortedWith(compareBy(
            { it.model.groupId },
            { it.model.artifactId }
        ))
        .forEach { node ->
            this.add("api", "${node.model.groupId}:${node.model.artifactId}:${node.model.version}")
        }
}

fun VersionCatalogBuilder.fromMavenProject(mavenProjectDir: File, prefix: String? = null) {
    val libPrefix = prefix?.let { "$it-" } ?: ""
    val moduleVersions = mutableSetOf<String>()
    val modules = MavenModelReader.readProject(mavenProjectDir)
        .map { it.model }
        .onEach { moduleVersions += it.version!! }
        .toList()

    val inferredPrefix = modules.map { it.artifactId!! }
        .reduce { a, b -> a.commonPrefixWith(b) }
        .replace(Regex("[^a-zA-Z0-9]+\$"), "")

    val insertedVersion: String? =
        if (prefix != null && moduleVersions.size == 1) {
            version(prefix, moduleVersions.first())
            prefix
        } else if (moduleVersions.size == 1 && inferredPrefix.isNotEmpty()) {
            version(inferredPrefix, moduleVersions.first())
            inferredPrefix
        } else {
            null
        }

    modules
        .sortedWith(compareBy(
            { it.groupId },
            { it.artifactId }
        ))
        .forEach { module ->
        val libBuilder = library(libPrefix + module.artifactId!!, module.groupId!!, module.artifactId!!)
        if (insertedVersion == null) {
            libBuilder.version(module.version!!)
        } else {
            libBuilder.versionRef(insertedVersion)
        }
    }
}
