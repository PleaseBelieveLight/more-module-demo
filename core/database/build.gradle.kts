plugins {
    id("logic.android.library")
    id("logic.android.library.jacoco")
    id("logic.android.room")
    id("logic.android.hilt")
}

android {
    namespace = "com.yyzy.database"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)
    implementation(project(":core:common"))
    implementation(project(":core:model"))
}