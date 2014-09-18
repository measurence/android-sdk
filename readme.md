# Measurence Android SDK

Still a work in progress.

If interested, please contact info@measurence.com

# Setup

## Gradle properties

Copy the `gradle.properties.example` file to `gradle.properties`.

Replace the placeholders with proper settings - only needed if you are going yto release a new version of the SDK to Maven Central. See this reference guide: http://zserge.com/blog/gradle-maven-publish.html

# Release

1. setup the VERSION_NAME in the `gradle.properties`
1. execute `gradle uploadArchives`
1. release the SDK from the Sonatype dashboard - see this reference guide: http://zserge.com/blog/gradle-maven-publish.html
1. upgrade the version in `gradle.properties` AND `gradle.properties.example` and commit it
    * for instance, if you release 0.1.0, set the new version to 0.2.0-SNAPSHOT