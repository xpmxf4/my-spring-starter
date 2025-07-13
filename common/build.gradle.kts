plugins {
    `java-library`
    kotlin("jvm") version "1.9.24"
}

group = "com.mycompany"
version = "1.0.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

val mapstructVersion = "1.5.5.Final"

dependencies {
    // Lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // MapStruct
    api("org.mapstruct:mapstruct:$mapstructVersion")
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")

    // Jakarta Annotations & Jackson
    api("jakarta.annotation:jakarta.annotation-api:2.1.1")
    api("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

    // 이 모듈 자체를 테스트하기 위한 의존성
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("com.navercorp.fixturemonkey:fixture-monkey-starter:1.0.17")
    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")
}

tasks.withType<Test> {
    useJUnitPlatform()
}