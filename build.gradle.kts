plugins {
    java
    id("org.springframework.boot") version "2.7.18"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "ppzxc.learning"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    // Use Tomcat
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Use Jetty
//    implementation("org.springframework.boot:spring-boot-starter-web") {
//        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
//    }
//    implementation("org.springframework.boot:spring-boot-starter-jetty")

    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}