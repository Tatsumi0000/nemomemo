import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.getByType


class DetektPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            apply("io.gitlab.arturbosch.detekt")
            val extension = extensions.getByType<DetektExtension>()

        }
    }

}