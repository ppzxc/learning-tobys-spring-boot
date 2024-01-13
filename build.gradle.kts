plugins {
    java
    id("org.springframework.boot") version "2.7.18"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "ppzxc.learning"
version = "0.0.1-SNAPSHOT"

java {
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework:spring-jdbc")
    runtimeOnly("com.h2database:h2:2.1.214")
    implementation("com.zaxxer:HikariCP:5.1.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}