import fr.rozanc.gradle.plugin.maven.bom.tasks.PrintModules

plugins {
    id("fr.rozanc.maven.bom")
}

tasks {
    register<PrintModules>("readPom") {
        inputDirectory.set(file("$rootDir/../src/test/data/complex-project"))
    }
}
