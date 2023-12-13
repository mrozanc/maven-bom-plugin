package fr.rozanc.gradle.plugin.maven.bom.model

import org.apache.maven.model.*
import java.io.File
import java.util.*

open class ModelWrapper(val model: Model) : Model(), ModelInterface {

    override fun toString(): String {
        return model.toString()
    }

    override fun clone(): Model {
        return ModelWrapper(model.clone())
    }

    override fun getLocation(key: Any?): InputLocation {
        return model.getLocation(key)
    }

    override fun setLocation(key: Any?, location: InputLocation?) {
        model.setLocation(key, location)
    }

    override fun addDependency(dependency: Dependency) {
        model.addDependency(dependency)
    }

    override fun addModule(string: String) {
        model.addModule(string)
    }

    override fun addPluginRepository(repository: Repository) {
        model.addPluginRepository(repository)
    }

    override fun addProperty(key: String, value: String) {
        model.addProperty(key, value)
    }

    override fun addRepository(repository: Repository) {
        model.addRepository(repository)
    }

    override fun setOtherLocation(key: Any?, location: InputLocation?) {
        model.setOtherLocation(key, location)
    }

    override fun removeDependency(dependency: Dependency) {
        model.removeDependency(dependency)
    }

    override fun removeModule(string: String) {
        model.removeModule(string)
    }

    override fun removePluginRepository(repository: Repository) {
        model.removePluginRepository(repository)
    }

    override fun removeRepository(repository: Repository) {
        model.removeRepository(repository)
    }

    override fun addContributor(contributor: Contributor) {
        model.addContributor(contributor)
    }

    override fun addDeveloper(developer: Developer) {
        model.addDeveloper(developer)
    }

    override fun addLicense(license: License) {
        model.addLicense(license)
    }

    override fun addMailingList(mailingList: MailingList) {
        model.addMailingList(mailingList)
    }

    override fun addProfile(profile: Profile) {
        model.addProfile(profile)
    }

    override fun getDependencies(): MutableList<Dependency> {
        return model.dependencies
    }

    override fun getDependencyManagement(): DependencyManagement? {
        return model.dependencyManagement
    }

    override fun getDistributionManagement(): DistributionManagement? {
        return model.distributionManagement
    }

    override fun getModules(): MutableList<String> {
        return model.modules
    }

    override fun getPluginRepositories(): MutableList<Repository> {
        return model.pluginRepositories
    }

    override fun getProperties(): Properties {
        return model.properties
    }

    override fun getReporting(): Reporting? {
        return model.reporting
    }

    override fun getReports(): Any? {
        return model.reports
    }

    override fun getRepositories(): MutableList<Repository> {
        return model.repositories
    }

    override fun setDependencies(dependencies: MutableList<Dependency>?) {
        model.dependencies = dependencies
    }

    override fun setDependencyManagement(dependencyManagement: DependencyManagement?) {
        model.dependencyManagement = dependencyManagement
    }

    override fun setDistributionManagement(distributionManagement: DistributionManagement?) {
        model.distributionManagement = distributionManagement
    }

    override fun setModules(modules: MutableList<String>?) {
        model.modules = modules
    }

    override fun setPluginRepositories(pluginRepositories: MutableList<Repository>?) {
        model.pluginRepositories = pluginRepositories
    }

    override fun setProperties(properties: Properties?) {
        model.properties = properties
    }

    override fun setReporting(reporting: Reporting?) {
        model.reporting = reporting
    }

    override fun setReports(reports: Any?) {
        model.reports = reports
    }

    override fun setRepositories(repositories: MutableList<Repository>?) {
        model.repositories = repositories
    }

    override fun getArtifactId(): String? {
        return model.artifactId
    }

    override fun getBuild(): Build? {
        return model.build
    }

    override fun getChildProjectUrlInheritAppendPath(): String? {
        return model.childProjectUrlInheritAppendPath
    }

    override fun getCiManagement(): CiManagement? {
        return model.ciManagement
    }

    override fun getContributors(): MutableList<Contributor> {
        return model.contributors
    }
    override fun getDescription(): String? {
        return model.description
    }

    override fun getDevelopers(): MutableList<Developer> {
        return model.developers
    }

    override fun getGroupId(): String? {
        return model.groupId
    }

    override fun getInceptionYear(): String? {
        return model.inceptionYear
    }

    override fun getIssueManagement(): IssueManagement? {
        return model.issueManagement
    }

    override fun getLicenses(): MutableList<License> {
        return model.licenses
    }

    override fun getMailingLists(): MutableList<MailingList> {
        return model.mailingLists
    }

    override fun getModelEncoding(): String? {
        return model.modelEncoding
    }

    override fun getModelVersion(): String? {
        return model.modelVersion
    }

    override fun getName(): String? {
        return model.name
    }

    override fun getOrganization(): Organization? {
        return model.organization
    }

    override fun getPackaging(): String? {
        return model.packaging
    }

    override fun getParent(): Parent? {
        return model.parent
    }

    override fun getPrerequisites(): Prerequisites? {
        return model.prerequisites
    }

    override fun getProfiles(): MutableList<Profile> {
        return model.profiles
    }

    override fun getScm(): Scm? {
        return model.scm
    }

    override fun getUrl(): String? {
        return model.url
    }

    override fun getVersion(): String? {
        return model.version
    }

    override fun removeContributor(contributor: Contributor) {
        model.removeContributor(contributor)
    }

    override fun removeDeveloper(developer: Developer) {
        model.removeDeveloper(developer)
    }

    override fun removeLicense(license: License) {
        model.removeLicense(license)
    }

    override fun removeMailingList(mailingList: MailingList) {
        model.removeMailingList(mailingList)
    }

    override fun removeProfile(profile: Profile) {
        model.removeProfile(profile)
    }

    override fun setArtifactId(artifactId: String?) {
        model.artifactId = artifactId
    }

    override fun setBuild(build: Build?) {
        model.build = build
    }

    override fun setChildProjectUrlInheritAppendPath(childProjectUrlInheritAppendPath: String?) {
        model.childProjectUrlInheritAppendPath = childProjectUrlInheritAppendPath
    }

    override fun setChildProjectUrlInheritAppendPath(childProjectUrlInheritAppendPath: Boolean) {
        model.isChildProjectUrlInheritAppendPath = childProjectUrlInheritAppendPath
    }

    override fun setCiManagement(ciManagement: CiManagement?) {
        model.ciManagement = ciManagement
    }

    override fun setContributors(contributors: MutableList<Contributor>?) {
        model.contributors = contributors
    }

    override fun setDescription(description: String?) {
        model.description = description
    }

    override fun setDevelopers(developers: MutableList<Developer>?) {
        model.developers = developers
    }

    override fun setGroupId(groupId: String?) {
        model.groupId = groupId
    }

    override fun setInceptionYear(inceptionYear: String?) {
        model.inceptionYear = inceptionYear
    }

    override fun setIssueManagement(issueManagement: IssueManagement?) {
        model.issueManagement = issueManagement
    }

    override fun setLicenses(licenses: MutableList<License>?) {
        model.licenses = licenses
    }

    override fun setMailingLists(mailingLists: MutableList<MailingList>?) {
        model.mailingLists = mailingLists
    }

    override fun setModelEncoding(modelEncoding: String?) {
        model.modelEncoding = modelEncoding
    }

    override fun setModelVersion(modelVersion: String?) {
        model.modelVersion = modelVersion
    }

    override fun setName(name: String?) {
        model.name = name
    }

    override fun setOrganization(organization: Organization?) {
        model.organization = organization
    }

    override fun setPackaging(packaging: String?) {
        model.packaging = packaging
    }

    override fun setParent(parent: Parent?) {
        model.parent = parent
    }

    override fun setPrerequisites(prerequisites: Prerequisites?) {
        model.prerequisites = prerequisites
    }

    override fun setProfiles(profiles: MutableList<Profile>?) {
        model.profiles = profiles
    }

    override fun setScm(scm: Scm?) {
        model.scm = scm
    }

    override fun setUrl(url: String?) {
        model.url = url
    }

    override fun setVersion(version: String?) {
        model.version = version
    }

    override fun getPomFile(): File? {
        return model.pomFile
    }

    override fun setPomFile(pomFile: File?) {
        model.pomFile = pomFile
    }

    override fun getProjectDirectory(): File? {
        return model.projectDirectory
    }

    override fun getId(): String {
        return model.id
    }

    override fun isChildProjectUrlInheritAppendPath(): Boolean {
        return model.isChildProjectUrlInheritAppendPath
    }
}
