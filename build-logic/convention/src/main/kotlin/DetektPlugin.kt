import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class DetektPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("io.gitlab.arturbosch.detekt")

            dependencies {
                "detektPlugins"(libs.findLibrary("detektFormatting").get())
//                "detektPlugins"(libs.findLibrary("twitterComposeRule").get())
            }
        }
    }
}