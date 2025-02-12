pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AndroidScaffold"

include(":app")

include(":core:database")
include(":core:common")
include(":core:data")
include(":core:model")
include(":core:network")
include(":core:testing")

include(":feature:business")
include(":feature:setting")

include(":sync:work")

