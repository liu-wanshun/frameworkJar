plugins {
    `kotlin-dsl`
    id("org.jetbrains.kotlin.jvm") version "1.9.25"
    id("com.gradle.plugin-publish") version "2.0.0"
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
