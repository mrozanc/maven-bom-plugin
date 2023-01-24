package fr.rozanc.gradle.plugin.maven.bom.model

import org.apache.maven.model.Model

data class ModelHierarchy(
    val model: Model,
    val parentModule: ModelHierarchy?,
    val childModules: List<ModelHierarchy>
) {
    val level: Int

    init {
        var currentLevel = 0
        var currentNode: ModelHierarchy? = this
        while (currentNode?.parentModule != null) {
            ++currentLevel
            currentNode = currentNode.parentModule
        }
        level = currentLevel
    }
}
