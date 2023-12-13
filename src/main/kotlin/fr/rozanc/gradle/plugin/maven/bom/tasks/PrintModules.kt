package fr.rozanc.gradle.plugin.maven.bom.tasks

import fr.rozanc.gradle.plugin.maven.bom.model.HierarchicalModel
import fr.rozanc.gradle.plugin.maven.bom.utils.MavenModelReader
import org.apache.maven.execution.DefaultMavenExecutionRequest
import org.eclipse.aether.DefaultRepositorySystemSession
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.TaskAction

open class PrintModules : DefaultTask() {

    @get:InputDirectory
    val inputDirectory: DirectoryProperty = project.objects.directoryProperty()

    init {
        group = "help"
    }

    @TaskAction
    fun readPom() {
        val models = MavenModelReader.readProject(inputDirectory.get().asFile)
            .sortedWith(compareBy(
                { it.path() },
                { it.parentModule?.childModules?.indexOf(it) ?: 0 }
            ))
            .toList()

        models.forEach { node ->
            println(" ".repeat(node.level * 2) + node.model.id)
        }

        val request = DefaultMavenExecutionRequest()
        request.pom = models.first().model.pomFile
        request.projectBuildingRequest.repositorySession = DefaultRepositorySystemSession()
    }

    private fun HierarchicalModel.path(): String {
        val sb = StringBuilder(100)
        path(this, sb)
        return sb.toString()
    }

    private fun path(currentModel: HierarchicalModel, pathBuilder: StringBuilder) {
        if (currentModel.parentModule != null) {
            path(currentModel.parentModule, pathBuilder)
        }
        pathBuilder.append('/').append(currentModel.model.id)
    }
}
