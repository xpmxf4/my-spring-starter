plugins {
    `java-library`
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
    id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"
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

dependencies {
    // Spring Data JPA & QueryDSL
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("com.querydsl:querydsl-jpa:5.1.0:jakarta")
    annotationProcessor("com.querydsl:querydsl-apt:5.1.0:jakarta", "jakarta.persistence:jakarta.persistence-api", "jakarta.annotation:jakarta.annotation-api")

    // Lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // 이 모듈 자체를 테스트하기 위한 의존성
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.bootJar { enabled = false }
tasks.jar { enabled = true }

val querydslDir = "build/generated/querydsl"
querydsl { jpa = true; querydslSourcesDir = querydslDir }
sourceSets { main { java { srcDir(querydslDir) } } }