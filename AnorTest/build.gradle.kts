plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val allureVersion = "2.29.0"
val junit = "5.11.1"
val slf4j = "2.0.16"

dependencies {
    testImplementation("com.github.romankh3:image-comparison:4.4.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit")
    testImplementation("io.qameta.allure:allure-junit5:$allureVersion")
    testImplementation("org.slf4j:slf4j-simple:$slf4j")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junit")

    implementation("com.codeborne:selenide:7.5.1")
    implementation("io.qameta.allure:allure-selenide:$allureVersion")
    implementation("io.appium:java-client:9.3.0")
    implementation("org.aeonbits.owner:owner:1.0.12")
    implementation("com.github.javafaker:javafaker:1.0.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register("DFDSF") {
    doLast {
        println("Task DFDSF executed")
    }
}