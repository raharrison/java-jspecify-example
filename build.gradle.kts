import net.ltgt.gradle.errorprone.errorprone

plugins {
    application
    id("java")
    id("com.gradleup.shadow") version "8.3.6"
    id("net.ltgt.errorprone") version "4.3.0"
}

group = "com.example.myapp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.11.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.jspecify:jspecify:1.0.0")
    errorprone("com.google.errorprone:error_prone_core:2.40.0")
    errorprone("com.uber.nullaway:nullaway:0.12.7")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
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
