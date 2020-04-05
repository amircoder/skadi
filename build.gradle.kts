plugins {
    kotlin("jvm") version "1.3.71"
}

buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:3.6.2")
    }
}

allprojects {
    repositories {
        jcenter()
        google()
    }

    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java) {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    // Enable new Kotlin type inference algorithm
    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).all {
        kotlinOptions {
            freeCompilerArgs = freeCompilerArgs + "-XXLanguage:+NewInference"
        }
    }

    // Enable JUnit5
    tasks.withType(Test::class.java) {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}
