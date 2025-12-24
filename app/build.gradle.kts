plugins {
    java
    application
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application {
    mainClass = "hexlet.code.App"
}

repositories {
    mavenCentral()
}

dependencies {
    // В первом проекте тесты не используются - зависимости удалены
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileJava {
    options.release = 21
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}
