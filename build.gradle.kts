import net.ltgt.gradle.errorprone.errorprone

plugins {
    application
    id("java")
    id("com.gradleup.shadow") version "9.6.1"
    id("net.ltgt.errorprone") version "5.1.1"
}

group = "com.example.myapp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.1.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("org.jspecify:jspecify:1.0.1")
    errorprone("com.google.errorprone:error_prone_core:2.51.0")
    errorprone("com.uber.nullaway:nullaway:0.14.3")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

application {
    mainClass.set("com.example.myapp.Main")
}

tasks.withType<JavaCompile> {
    options.errorprone {
        disableAllChecks = true
        option("NullAway:JSpecifyMode", "true")
//        option("NullAway:OnlyNullMarked", "true")
        option("NullAway:AnnotatedPackages", "com.example.myapp")
        error("NullAway")
    }
    // Disable NullAway on test code
    if (name.lowercase().contains("test")) {
        options.errorprone {
            disable("NullAway")
        }
    }
}
