import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "love.aespa.nemomemo.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    implementation(libs.bundles.plugins)
}

gradlePlugin {
    plugins {
        register("detekt") {
            id = "love.aespa.nemomemo.detekt"
            implementationClass = "DetektPlugin"
        }
        register("kover") {
            id = "love.aespa.nemomemo.kover"
            implementationClass = "KoverPlugin"
        }
    }
}
