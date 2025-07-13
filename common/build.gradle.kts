// common/build.gradle.kts

val mapstructVersion = "1.6.3"

dependencies {
    // Lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // MapStruct
    api("org.mapstruct:mapstruct:$mapstructVersion")
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")

    // Jakarta Validation
    api("org.springframework.boot:spring-boot-starter-validation")

    // --- 테스트(test)용 의존성 ---
    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")
    testImplementation("com.navercorp.fixturemonkey:fixture-monkey-starter:1.0.17")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}