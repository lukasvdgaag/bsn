import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    id("org.sonarqube") version "4.4.1.3373"
}

group = "nl.hva"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

sonar {
    properties {
        property("sonar.projectKey", "se-specialization-2023-2_tse1_lukas-van-der-gaag_assignments_218091fd-f4d6-475a-b22e-fea1f85e42b1")
        property("sonar.projectName", "assignments")
        property("sonar.plugins.downloadOnlyRequired", true)
        property("sonar.qualitygate.wait", true)
        property("sonar.task.timeout", "600")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
