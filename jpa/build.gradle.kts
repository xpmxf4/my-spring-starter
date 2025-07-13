plugins {
    // QueryDSL을 사용하기 위해 플러그인을 추가합니다.
    kotlin("plugin.jpa") version "1.9.24"
    id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"
}

dependencies {
    // api(project(":common"))  <-- 이 줄을 삭제했습니다.

    // Spring Data JPA
    api("org.springframework.boot:spring-boot-starter-data-jpa")

    // QueryDSL
    api("com.querydsl:querydsl-jpa:5.1.0:jakarta")
    annotationProcessor("com.querydsl:querydsl-apt:5.1.0:jakarta")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")
}

// --- QueryDSL 설정 ---
val querydslDir = "build/generated/querydsl"

querydsl {
    jpa = true
    querydslSourcesDir = querydslDir
}
sourceSets {
    main.java.srcDir(querydslDir)
}
tasks.compileQuerydsl {
    options.annotationProcessorPath = configurations.querydsl
}