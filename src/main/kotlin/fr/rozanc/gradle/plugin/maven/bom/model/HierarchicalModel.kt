package fr.rozanc.gradle.plugin.maven.bom.model

import org.apache.maven.model.Model

class HierarchicalModel(
    val model: Model,
    val parentModule: HierarchicalModel?,
    val childModules: List<HierarchicalModel>
) {
    val level: Int = if (parentModule == null) 0 else parentModule.level + 1
}
