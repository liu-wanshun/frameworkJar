plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    id("org.jetbrains.kotlin.jvm") version "1.9.25"
    `maven-publish`
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
    }
}

dependencies {
    compileOnly("com.android.tools.build:gradle-api:7.4.0")
    compileOnly("com.android.tools.build:gradle:7.4.0")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.22")
}

version = "1.0.0-SNAPSHOT"
gradlePlugin {
    plugins {
        create("frameworkJarPlugin") {
            id = "io.github.liu-wanshun.frameworkJar"
            implementationClass = "app.lws.frameworkJar.FrameworkJarPlugin"
        }
    }
}
