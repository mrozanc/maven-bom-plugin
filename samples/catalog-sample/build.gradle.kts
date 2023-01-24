plugins {
    id("version-catalog")
    id("fr.rozanc.maven.bom")
}

catalog {
    versionCatalog {
        fromMavenProject(file("$rootDir/../src/test/data/complex-project"))
    }
}
