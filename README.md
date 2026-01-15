# frameworkJar

[![Gradle Plugin Portal](https://img.shields.io/gradle-plugin-portal/v/io.github.liu-wanshun.frameworkJar)](https://plugins.gradle.org/plugin/io.github.liu-wanshun.frameworkJar)
[![license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)

      A gradle plugin for add frameworkJar in to classpath for using android hiden api

## Add Gradle Plugin

Using the [plugins DSL](https://docs.gradle.org/current/userguide/plugins.html#sec:plugins_block):


```kotlin
pluginManagement {
   repositories {
      maven {
         gradlePluginPortal()
      }
   }
}

plugins {
    id("io.github.liu-wanshun.frameworkJar") version "1.0.0"
}
```


<details>
  <summary>Using <code>apply plugin</code> (the old way) </summary>



[legacy plugin application](https://docs.gradle.org/current/userguide/plugins.html#sec:old_plugin_application)

[Learn how to apply plugins to subprojects](https://docs.gradle.org/current/userguide/plugins.html#sec:subprojects_plugins_dsl)

```kotlin
buildscript {
    repositories {
        maven {
            gradlePluginPortal()
        }
    }
    dependencies {
        classpath("io.github.liu-wanshun.frameworkJar:plugins:1.0.0")
    }
}

apply(plugin = "io.github.liu-wanshun.frameworkJar")
```

</details>

## Example

Kotlin DSL / Groovy DSL :

```kotlin
dependencies {
    // this should replace with your frameworkJar
    frameworkJar("androidx.core:core:1.0.0")
}
```
