import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    id("com.gradle.plugin-publish") version "2.0.0"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.sam.with.receiver") version "1.9.22"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_1_8
        apiVersion = KotlinVersion.KOTLIN_1_4
        languageVersion = KotlinVersion.KOTLIN_1_4
    }
}
samWithReceiver {
    annotation("org.gradle.api.HasImplicitReceiver")
}

dependencies {
    compileOnly("com.android.tools.build:gradle:7.3.0")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib:1.9.22")
    compileOnly("dev.gradleplugins:gradle-api:8.0")
}

configurations.all {
    withDependencies {
        remove(project.dependencies.gradleApi())
        remove(project.dependencies.gradleTestKit())
    }
}

group = "io.github.liu-wanshun"
version = "1.0.0"
base.archivesName = "frameworkJar"
publishing {
    publications {
        maybeCreate<MavenPublication>("pluginMaven").apply {
            artifactId = base.archivesName.get()
        }
    }
}
gradlePlugin {
    website = "https://github.com/liu-wanshun/frameworkJar"
    vcsUrl = "https://github.com/liu-wanshun/frameworkJar"
    plugins {
        create("frameworkJarPlugin") {
            id = "io.github.liu-wanshun.frameworkJar"
            implementationClass = "app.lws.frameworkJar.FrameworkJarPlugin"
            displayName = "frameworkJar plugin"
            description =
                "Gradle plugin to add frameworkJar in to classpath for using android hiden api"
            tags.set(listOf("android", "framework","hiden api"))
        }
    }
}
