import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.api.AndroidBasePlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.benchmark) apply false
    alias(libs.plugins.jetbrainsKotlinJvm) apply false
}


allprojects {
    println("all project name = $name")

    plugins.withType<AndroidBasePlugin> {

        extensions.configure(CommonExtension::class.java) {

            compileSdk = 34

            //这个基准测试类，自己会定义 ，so
            buildTypes {
                getByName("release") {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
        }

        extensions.configure<BaseExtension> {

            afterEvaluate {
                println("BaseExtension namespace = $namespace")
            }

            defaultConfig {
                minSdk = 24
                targetSdk = 34
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                if (name != "app") {
                    consumerProguardFiles("consumer-rules.pro")
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }

            tasks.withType<KotlinCompile> {
                kotlinOptions {
                    jvmTarget = JavaVersion.VERSION_17.toString()
                }
            }
        }

        dependencies {
            if (name != "common") {
                add("implementation", project(mapOf("path" to ":common")))
            }
        }
    }
}

ext {
    set("autoLeveling", "1")
}

extra["autoLevelTask"] = { project: Project, autoVersionFileName: String ->
    println("project=$project,autoVersionFileName=$autoVersionFileName")
}


class MyCopyTask : DefaultTask() {
    @TaskAction
    fun copyFiles() {
        val sourceDir = File("sourceDir")
        val destinationDir = File("destinationDir")
        sourceDir.listFiles()?.forEach { file ->
            if (file.isFile && file.extension == "txt") {
                file.copyTo(File(destinationDir, file.name))
            }
        }
    }
}