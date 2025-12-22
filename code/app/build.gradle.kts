plugins {
    application
    id("com.github.ben-manes.versions") version "0.53.0"
    id("org.sonarqube") version "4.4.1.3373"
    // Подключаем Checkstyle плагин
    id("checkstyle")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass = "hexlet.code.App"
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

// Конфигурация для dependencyUpdates
tasks.named<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask>("dependencyUpdates") {
    checkForGradleUpdate = true
    outputFormatter = "plain"
    outputDir = "build/dependencyUpdates"
    reportfileName = "report"
    
    rejectVersionIf {
        isNonStable(candidate.version)
    }
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return !isStable
}

// Настройка задачи run
tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

// Конфигурация SonarQube
sonarqube {
    properties {
        property("sonar.projectKey", "bobbidenisleo-glitch_java-project-61")
        property("sonar.organization", "bobbidenisleo-glitch")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.token", "7971f5acfbf4b050a3f9000315b95d08222b9d3c")
    }
}

// Конфигурация Checkstyle
checkstyle {
    // Версия Checkstyle
    toolVersion = "10.12.5"
    
    // Файл конфигурации
    configFile = file("config/checkstyle/checkstyle.xml")
    
    // Игнорировать неудачи? (false = сборка упадёт при ошибках Checkstyle)
    isIgnoreFailures = false
    
    // Максимальное количество предупреждений (0 = не допускать предупреждений)
    maxWarnings = 0
    
    // Показывать нарушения
    
}

// Настройка отчётов Checkstyle
tasks.withType<Checkstyle>().configureEach {
    reports {
        xml.required = false
        html.required = true
        html.outputLocation = file("$buildDir/reports/checkstyle/${name}.html")
    }
}

// Отключаем Checkstyle для тестов если нужно
tasks.named("checkstyleTest") {
    enabled = true
}
