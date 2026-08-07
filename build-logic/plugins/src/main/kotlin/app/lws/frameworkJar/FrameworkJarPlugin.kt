package app.lws.frameworkJar

import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.gradle.api.AndroidBasePlugin
import com.android.build.gradle.internal.utils.getProjectKotlinPluginKotlinVersion
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.attributes.Attribute
import org.gradle.api.file.FileCollection
import org.gradle.api.tasks.compile.JavaCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class FrameworkJarPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.withType(AndroidBasePlugin::class.java) {
            project.addFrameworkConfigurations()

            val androidComponents =
                project.extensions.getByType(AndroidComponentsExtension::class.java)
            androidComponents.apply {
                onVariants { variant ->
                    variant.compileConfiguration.extendsFrom(project.configurations.getByName("frameworkJar"))
                }
            }
        }
    }
}


private fun Project.addFrameworkConfigurations() {

    configurations.register("frameworkJar") {
        isCanBeConsumed = false
        isTransitive = false
    }

    gradle.projectsEvaluated {

        configurations.named("frameworkJar").configure {
            val artifactType = Attribute.of("artifactType", String::class.java)
            val files = incoming.artifactView {
                attributes {
                    attribute(artifactType, "jar")
                }
            }.files
            addFrameworkClasspath(files)
        }
    }

}

private fun Project.addFrameworkClasspath(jarFiles: FileCollection) {
    tasks.withType(JavaCompile::class.java).configureEach {
        if (JavaVersion.toVersion(sourceCompatibility).isJava9Compatible) {
            classpath = files(jarFiles, classpath)
            logger.info("addFrameworkClasspath $name ${classpath.files}")
        } else {
            options.bootstrapClasspath = files(jarFiles, options.bootstrapClasspath)
        }
    }
    val kotlinVersion = getProjectKotlinPluginKotlinVersion(this)
    if (kotlinVersion == null) {
        logger.lifecycle("kotlinVersion is null, skip config frameworkJar for kotlin")
        return
    }
    tasks.withType(KotlinCompile::class.java).configureEach {
        if (kotlinVersion.isAtLeast(1, 7)) {
            libraries.setFrom(files(jarFiles, libraries))
            logger.info("addFrameworkClasspath $name ${libraries.files}")
        } else {
            classpath = files(jarFiles, classpath)
        }
    }
}
