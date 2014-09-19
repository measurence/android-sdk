# Measurence

Measurence's mission is to transform retail stores into "physical websites", by providing:

1. actionable knowledge about customers behavior into the stores
1. marketing solutions and technologies aimed at improving the customers engagement and loyalty

As a primary source of Knowledge, Measurence install and manages a network of WiFi sensors which collect anonymized and aggregated information about foot traffic within retail stores.

Measurence crunches this information in order to deliver its own analytics solution, and also distributes it to partners in order to provide the highest possible value to the stakeholders.

For any inquiry, drop us a email at info@measurence.com

# Measurence API Platform

In order to implement an effective and efficient distribution to its partners of the collected information, Measurence has create an "API Platform".

The Measurence API Platform is currently intended to serve 3 use cases:

* a mobile app, which subscribes to receive customers "session updates" (related to the device where it's installed) via push notification (e.g. Google Cloud Messaging)
* a mobile app, which subscribes to receive customers "session updates" (related to the device where it's installed) to its Back End servers
* a Back End server of a Measurence partner, which subscribes to receive "session updates" of _ALL_ devices captured by the Measurence sensors

# Measurence Android SDK

The Android SDK is intended to be embedded in an Android mobile app in order to implement the related use cases (see previous Sections).

A Demp App demonstrating how to embed the SDK is available at: https://bitbucket.org/measurence/measurence-android-sdk-demo-app

Please refer to its documentation for a better understanding on how to use the Measurence Android SDK.

The following Sections are intended to provide information about maintenance of the SDK.

# Development environmente Setup

## Gradle properties

Copy the `gradle.properties.example` file to `gradle.properties`.

Replace the placeholders with proper settings - only needed if you are going yto release a new version of the SDK to Maven Central. See this reference guide: http://zserge.com/blog/gradle-maven-publish.html

# Release

1. setup the VERSION_NAME in the `gradle.properties`
1. execute `gradle uploadArchives`
1. release the SDK from the Sonatype dashboard - see this reference guide: http://zserge.com/blog/gradle-maven-publish.html
1. upgrade the version in `gradle.properties` AND `gradle.properties.example` and commit it
    * for instance, if you release 0.1.0, set the new version to 0.2.0-SNAPSHOT