import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class DetektPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("io.gitlab.arturbosch.detekt")
            val fileTree = project.files("./").asFileTree.matching {
                include("**/*.kt")
                include("**/*.kts")
                exclude("**/build/**")
                exclude("**/resources/**")
            }
            val extension = extensions.getByType<DetektExtension>()
            extension.apply {
                buildUponDefaultConfig = true
                autoCorrect = true
                config.setFrom(project.files("${project.rootProject.rootDir}/config/detekt.yml"))
                debug = true
                source.setFrom(fileTree)
            }

            dependencies {
                "detektPlugins"(libs.findLibrary("detektFormatting").get())
                "detektPlugins"(libs.findLibrary("detektComposeRule").get())
            }
        }
    }
}
