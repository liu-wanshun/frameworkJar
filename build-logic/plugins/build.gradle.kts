import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    id("com.gradle.plugin-publish") version "2.0.0"
    kotlin("jvm") version "2.3.0"
    kotlin("plugin.sam.with.receiver") version "2.3.0"
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_11
        apiVersion = KotlinVersion.KOTLIN_1_9
        languageVersion = KotlinVersion.KOTLIN_1_9
    }
    coreLibrariesVersion = "1.9.25"
}
samWithReceiver {
    annotation("org.gradle.api.HasImplicitReceiver")
}

dependencies {
    compileOnly(gradleKotlinDsl())
    compileOnly("com.android.tools.build:gradle-api:7.3.0")
}

group = "io.github.liu-wanshun"
version = "1.0.0"
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
