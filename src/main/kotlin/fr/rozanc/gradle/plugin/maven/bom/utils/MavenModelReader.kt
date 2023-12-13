package fr.rozanc.gradle.plugin.maven.bom.utils

import fr.rozanc.gradle.plugin.maven.bom.model.HierarchicalModel
import fr.rozanc.gradle.plugin.maven.bom.model.ModelWrapper
import org.apache.maven.model.io.xpp3.MavenXpp3Reader
import java.io.File

object MavenModelReader {

    fun readProject(projectDirectory: File): Sequence<HierarchicalModel> {
        return readRecursively(projectDirectory)
    }

    private fun readRecursively(
        currentDirectory: File,
        processedModels: MutableMap<String, HierarchicalModel> = mutableMapOf()
    ): Sequence<HierarchicalModel> = sequence {
        val model: ModelWrapper
        File(currentDirectory, "pom.xml").inputStream().use {
            val reader = MavenXpp3Reader()
            model = ModelWrapper(reader.read(it))
        }

        if (model.groupId == null && model.parent?.groupId != null) {
            model.groupId = model.parent?.groupId
        }
        if (model.version == null && model.parent?.version != null) {
            model.version = model.parent?.version
        }

        val childrenList = mutableListOf<HierarchicalModel>()
        val node = HierarchicalModel(model, model.parent?.let { processedModels[it.id] }, childrenList)
        processedModels[model.id] = node
        model.modules.map { module ->
            yieldAll(
                readRecursively(File(currentDirectory, module), processedModels)
                    .onEach {
                        if (it.model.parent?.id == model.id) {
                            childrenList += it
                        }
                    }
            )
        }

        yield(node)
    }
}
