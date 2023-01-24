package fr.rozanc.gradle.plugin.maven.bom.tasks

import fr.rozanc.gradle.plugin.maven.bom.model.ModelHierarchy
import fr.rozanc.gradle.plugin.maven.bom.utils.MavenModelReader
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
        MavenModelReader.readProject(inputDirectory.get().asFile)
            .sortedWith(compareBy(
                { it.path() },
                { it.parentModule?.childModules?.indexOf(it) ?: 0 }
            ))
            .forEach { node ->
                println(" ".repeat(node.level * 2) + node.model.id)
            }
    }

    private fun ModelHierarchy.path(): String {
        val sb = StringBuilder(100)
        path(this, sb)
        return sb.toString()
    }

    private fun path(currentModel: ModelHierarchy, pathBuilder: StringBuilder) {
        if (currentModel.parentModule != null) {
            path(currentModel.parentModule, pathBuilder)
        }
        pathBuilder.append('/').append(currentModel.model.id)
    }
}
