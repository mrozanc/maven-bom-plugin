plugins {
    id("java-platform")
    id("fr.rozanc.maven.bom")
}

dependencies {
    constraints {
        fromMavenProject(file("$rootDir/../src/test/data/complex-project"))
    }
}
