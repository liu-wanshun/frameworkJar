plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("io.github.liu-wanshun.frameworkJar")
}

android {
    namespace = "app.lws.frameworkJar.demo"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
        targetSdk = 34
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}
dependencies {
    frameworkJar("androidx.collection:collection:1.0.0")
    // implementation("androidx.core:core:1.0.0")
}