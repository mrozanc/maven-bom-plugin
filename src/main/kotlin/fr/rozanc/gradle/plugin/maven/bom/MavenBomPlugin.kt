package fr.rozanc.gradle.plugin.maven.bom

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.BasePlugin
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin

class MavenBomPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.pluginManager.apply(BasePlugin::class.java)
        project.pluginManager.apply(MavenPublishPlugin::class.java)

        project.extensions.getByType(PublishingExtension::class.java).apply {
            publications { publications ->
                project.pluginManager.withPlugin("java-platform") {
                    publications.create("mavenJavaPlatform", MavenPublication::class.java) {
                        it.from(project.components.getByName("javaPlatform"))
                    }
                }
                project.pluginManager.withPlugin("version-catalog") {
                    publications.create("mavenVersionCatalog", MavenPublication::class.java) {
                        it.from(project.components.getByName("versionCatalog"))
                    }
                }
            }
        }
    }
}