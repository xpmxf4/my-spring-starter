plugins {
    `java-library` apply false
    id("io.spring.dependency-management") version "1.1.5" apply false
}

// 모든 하위 모듈(subprojects)에 공통으로 적용될 설정입니다.
subprojects {
    apply(plugin = "java-library")
    apply(plugin = "io.spring.dependency-management")

    group = "com.mycompany"
    version = "1.0.0-SNAPSHOT"
    java.sourceCompatibility = JavaVersion.VERSION_17

    repositories {
        mavenCentral()
    }

    // 의존성 버전을 중앙에서 관리합니다.
    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:3.3.1")
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}