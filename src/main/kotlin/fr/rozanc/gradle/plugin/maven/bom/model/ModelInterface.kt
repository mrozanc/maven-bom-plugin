package fr.rozanc.gradle.plugin.maven.bom.model

import org.apache.maven.model.*
import java.io.File
import java.io.Serializable

/**
 *
 *
 * The `<project>` element is the root of
 * the descriptor.
 * The following table lists all of the possible child
 * elements.
 *
 *
 *
 * @version $Revision$ $Date$
 */
interface ModelInterface : Serializable, Cloneable, InputLocationTracker {
    /**
     * Method addContributor.
     *
     * @param contributor
     */
    fun addContributor(contributor: Contributor) //-- void addContributor( Contributor )

    /**
     * Method addDeveloper.
     *
     * @param developer
     */
    fun addDeveloper(developer: Developer) //-- void addDeveloper( Developer )

    /**
     * Method addLicense.
     *
     * @param license
     */
    fun addLicense(license: License) //-- void addLicense( License )

    /**
     * Method addMailingList.
     *
     * @param mailingList
     */
    fun addMailingList(mailingList: MailingList) //-- void addMailingList( MailingList )

    /**
     * Method addProfile.
     *
     * @param profile
     */
    fun addProfile(profile: Profile) //-- void addProfile( Profile )

    /**
     * Method clone.
     *
     * @return Model
     */
    public override fun clone(): Model //-- Model clone()

    /**
     * Get the identifier for this artifact that is unique within
     * the group given by the
     * group ID. An artifact is something that is
     * either produced or used by a project.
     * Examples of artifacts produced by Maven for a
     * project include: JARs, source and binary
     * distributions, and WARs.
     *
     * @return String
     */ //-- String getArtifactId()
    fun getArtifactId(): String?

    /**
     * Get information required to build the project.
     *
     * @return Build
     */
    fun getBuild(): Build? //-- Build getBuild()

    /**
     * Get when children inherit from project's url, append path or
     * not? Note: While the type
     * of this field is `String` for
     * technical reasons, the semantic type is actually
     * `Boolean`
     * <br></br>**Default value is**: `true`
     * <br></br>**Since**: Maven 3.6.1.
     *
     * @return String
     */
    fun getChildProjectUrlInheritAppendPath(): String? //-- String getChildProjectUrlInheritAppendPath()

    /**
     * Get the project's continuous integration information.
     *
     * @return CiManagement
     */
    fun getCiManagement(): CiManagement? //-- CiManagement getCiManagement()

    /**
     * Method getContributors.
     *
     * @return List
     */
    fun getContributors(): MutableList<Contributor> //-- java.util.MutableList<Contributor> getContributors()

    /**
     * Get a detailed description of the project, used by Maven
     * whenever it needs to
     * describe the project, such as on the web site.
     * While this element can be specified as
     * CDATA to enable the use of HTML tags within the
     * description, it is discouraged to allow
     * plain text representation. If you need to modify
     * the index page of the generated web
     * site, you are able to specify your own instead
     * of adjusting this text.
     *
     * @return String
     */
    fun getDescription(): String? //-- String getDescription()

    /**
     * Method getDevelopers.
     *
     * @return List
     */
    fun getDevelopers(): MutableList<Developer> //-- java.util.MutableList<Developer> getDevelopers()

    /**
     * Get a universally unique identifier for a project. It is
     * normal to
     * use a fully-qualified package name to
     * distinguish it from other
     * projects with a similar name (eg.
     * `org.apache.maven`).
     *
     * @return String
     */
    fun getGroupId(): String? //-- String getGroupId()

    /**
     * Get the year of the project's inception, specified with 4
     * digits. This value is
     * used when generating copyright notices as well
     * as being informational.
     *
     * @return String
     */
    fun getInceptionYear(): String? //-- String getInceptionYear()

    /**
     * Get the project's issue management system information.
     *
     * @return IssueManagement
     */
    fun getIssueManagement(): IssueManagement? //-- IssueManagement getIssueManagement()

    /**
     * Method getLicenses.
     *
     * @return List
     */
    fun getLicenses(): MutableList<License> //-- java.util.MutableList<License> getLicenses()

    /**
     * Method getMailingLists.
     *
     * @return List
     */
    fun getMailingLists(): MutableList<MailingList> //-- java.util.MutableList<MailingList> getMailingLists()

    /**
     * Get the modelEncoding field.
     *
     * @return String
     */
    fun getModelEncoding(): String? //-- String getModelEncoding()

    /**
     * Get declares to which version of project descriptor this POM
     * conforms.
     *
     * @return String
     */
    fun getModelVersion(): String? //-- String getModelVersion()

    /**
     * Get the full name of the project.
     *
     * @return String
     */
    fun getName(): String? //-- String getName()

    /**
     * Get this element describes various attributes of the
     * organization to which the
     * project belongs. These attributes are utilized
     * when documentation is created (for
     * copyright notices and links).
     *
     * @return Organization
     */
    fun getOrganization(): Organization? //-- Organization getOrganization()

    /**
     * Get the type of artifact this project produces, for example
     * `jar`
     * `war`
     * `ear`
     * `pom`.
     * Plugins can create their own packaging, and
     * therefore their own packaging types,
     * so this list does not contain all possible
     * types.
     *
     * @return String
     */
    fun getPackaging(): String? //-- String getPackaging()

    /**
     * Get the location of the parent project, if one exists.
     * Values from the parent
     * project will be the default for this project if
     * they are left unspecified. The location
     * is given as a group ID, artifact ID and version.
     *
     * @return Parent
     */
    fun getParent(): Parent? //-- Parent getParent()

    /**
     * Get describes the prerequisites in the build environment for
     * this project.
     *
     * @return Prerequisites
     */
    fun getPrerequisites(): Prerequisites? //-- Prerequisites getPrerequisites()

    /**
     * Method getProfiles.
     *
     * @return List
     */
    fun getProfiles(): MutableList<Profile> //-- java.util.MutableList<Profile> getProfiles()

    /**
     * Get specification for the SCM used by the project, such as
     * CVS, Subversion, etc.
     *
     * @return Scm
     */
    fun getScm(): Scm? //-- Scm getScm()

    /**
     * Get the URL to the project's homepage.
     * <br></br>**Default value is**: parent value [+
     * path adjustment] + (artifactId or project.directory
     * property), or just parent value if
     * project's
     * `child.project.url.inherit.append.path="false"`
     *
     * @return String
     */
    fun getUrl(): String? //-- String getUrl()

    /**
     * Get the current version of the artifact produced by this
     * project.
     *
     * @return String
     */
    fun getVersion(): String? //-- String getVersion()

    /**
     * Method removeContributor.
     *
     * @param contributor
     */
    fun removeContributor(contributor: Contributor) //-- void removeContributor( Contributor )

    /**
     * Method removeDeveloper.
     *
     * @param developer
     */
    fun removeDeveloper(developer: Developer) //-- void removeDeveloper( Developer )

    /**
     * Method removeLicense.
     *
     * @param license
     */
    fun removeLicense(license: License) //-- void removeLicense( License )

    /**
     * Method removeMailingList.
     *
     * @param mailingList
     */
    fun removeMailingList(mailingList: MailingList) //-- void removeMailingList( MailingList )

    /**
     * Method removeProfile.
     *
     * @param profile
     */
    fun removeProfile(profile: Profile) //-- void removeProfile( Profile )

    /**
     * Set the identifier for this artifact that is unique within
     * the group given by the
     * group ID. An artifact is something that is
     * either produced or used by a project.
     * Examples of artifacts produced by Maven for a
     * project include: JARs, source and binary
     * distributions, and WARs.
     *
     * @param artifactId
     */
    fun setArtifactId(artifactId: String?) //-- void setArtifactId( String )

    /**
     * Set information required to build the project.
     *
     * @param build
     */
    fun setBuild(build: Build?) //-- void setBuild( Build )

    /**
     * Set when children inherit from project's url, append path or
     * not? Note: While the type
     * of this field is `String` for
     * technical reasons, the semantic type is actually
     * `Boolean`
     * <br></br>**Default value is**: `true`
     * <br></br>**Since**: Maven 3.6.1.
     *
     * @param childProjectUrlInheritAppendPath
     */
    fun setChildProjectUrlInheritAppendPath(childProjectUrlInheritAppendPath: String?) //-- void setChildProjectUrlInheritAppendPath( String )

    /**
     * Set the project's continuous integration information.
     *
     * @param ciManagement
     */
    fun setCiManagement(ciManagement: CiManagement?) //-- void setCiManagement( CiManagement )

    /**
     * Set describes the contributors to a project that are not yet
     * committers.
     *
     * @param contributors
     */
    fun setContributors(contributors: MutableList<Contributor>?) //-- void setContributors( java.util.List )

    /**
     * Set a detailed description of the project, used by Maven
     * whenever it needs to
     * describe the project, such as on the web site.
     * While this element can be specified as
     * CDATA to enable the use of HTML tags within the
     * description, it is discouraged to allow
     * plain text representation. If you need to modify
     * the index page of the generated web
     * site, you are able to specify your own instead
     * of adjusting this text.
     *
     * @param description
     */
    fun setDescription(description: String?) //-- void setDescription( String )

    /**
     * Set describes the committers of a project.
     *
     * @param developers
     */
    fun setDevelopers(developers: MutableList<Developer>?) //-- void setDevelopers( java.util.List )

    /**
     * Set a universally unique identifier for a project. It is
     * normal to
     * use a fully-qualified package name to
     * distinguish it from other
     * projects with a similar name (eg.
     * `org.apache.maven`).
     *
     * @param groupId
     */
    fun setGroupId(groupId: String?) //-- void setGroupId( String )

    /**
     * Set the year of the project's inception, specified with 4
     * digits. This value is
     * used when generating copyright notices as well
     * as being informational.
     *
     * @param inceptionYear
     */
    fun setInceptionYear(inceptionYear: String?) //-- void setInceptionYear( String )

    /**
     * Set the project's issue management system information.
     *
     * @param issueManagement
     */
    fun setIssueManagement(issueManagement: IssueManagement?) //-- void setIssueManagement( IssueManagement )

    /**
     * Set this element describes all of the licenses for this
     * project.
     * Each license is described by a
     * `license` element, which
     * is then described by additional elements.
     * Projects should only list the license(s) that
     * applies to the project
     * and not the licenses that apply to dependencies.
     * If multiple licenses are listed, it is assumed
     * that the user can select
     * any of them, not that they must accept all.
     *
     * @param licenses
     */
    fun setLicenses(licenses: MutableList<License>?) //-- void setLicenses( java.util.List )

    /**
     * Set contains information about a project's mailing lists.
     *
     * @param mailingLists
     */
    fun setMailingLists(mailingLists: MutableList<MailingList>?) //-- void setMailingLists( java.util.List )

    /**
     * Set the modelEncoding field.
     *
     * @param modelEncoding
     */
    fun setModelEncoding(modelEncoding: String?) //-- void setModelEncoding( String )

    /**
     * Set declares to which version of project descriptor this POM
     * conforms.
     *
     * @param modelVersion
     */
    fun setModelVersion(modelVersion: String?) //-- void setModelVersion( String )

    /**
     * Set the full name of the project.
     *
     * @param name
     */
    fun setName(name: String?) //-- void setName( String )

    /**
     * Set this element describes various attributes of the
     * organization to which the
     * project belongs. These attributes are utilized
     * when documentation is created (for
     * copyright notices and links).
     *
     * @param organization
     */
    fun setOrganization(organization: Organization?) //-- void setOrganization( Organization )

    /**
     * Set the type of artifact this project produces, for example
     * `jar`
     * `war`
     * `ear`
     * `pom`.
     * Plugins can create their own packaging, and
     * therefore their own packaging types,
     * so this list does not contain all possible
     * types.
     *
     * @param packaging
     */
    fun setPackaging(packaging: String?) //-- void setPackaging( String )

    /**
     * Set the location of the parent project, if one exists.
     * Values from the parent
     * project will be the default for this project if
     * they are left unspecified. The location
     * is given as a group ID, artifact ID and version.
     *
     * @param parent
     */
    fun setParent(parent: Parent?) //-- void setParent( Parent )

    /**
     * Set describes the prerequisites in the build environment for
     * this project.
     *
     * @param prerequisites
     */
    fun setPrerequisites(prerequisites: Prerequisites?) //-- void setPrerequisites( Prerequisites )

    /**
     * Set a listing of project-local build profiles which will
     * modify the build process
     * when activated.
     *
     * @param profiles
     */
    fun setProfiles(profiles: MutableList<Profile>?) //-- void setProfiles( java.util.List )

    /**
     * Set specification for the SCM used by the project, such as
     * CVS, Subversion, etc.
     *
     * @param scm
     */
    fun setScm(scm: Scm?) //-- void setScm( Scm )

    /**
     * Set the URL to the project's homepage.
     * <br></br>**Default value is**: parent value [+
     * path adjustment] + (artifactId or project.directory
     * property), or just parent value if
     * project's
     * `child.project.url.inherit.append.path="false"`
     *
     * @param url
     */
    fun setUrl(url: String?) //-- void setUrl( String )

    /**
     * Set the current version of the artifact produced by this
     * project.
     *
     * @param version
     */
    fun setVersion(version: String?) //-- void setVersion( String )

    /**
     * Gets the POM file for the corresponding project (if any).
     *
     * @return The POM file from which this model originated or `null` if this model does not belong to a local
     * project (e.g. describes the metadata of some artifact from the repository).
     */
    fun getPomFile(): File?
    fun setPomFile(pomFile: File?)

    /**
     * Gets the base directory for the corresponding project (if any).
     *
     * @return The base directory for the corresponding project or `null` if this model does not belong to a local
     * project (e.g. describes the metadata of some artifact from the repository).
     */
    fun getProjectDirectory(): File?

    /**
     * @return the model id as `groupId:artifactId:packaging:version`
     */
    fun getId(): String?
    override fun toString(): String
    fun isChildProjectUrlInheritAppendPath(): Boolean
    fun setChildProjectUrlInheritAppendPath(childProjectUrlInheritAppendPath: Boolean)
}
