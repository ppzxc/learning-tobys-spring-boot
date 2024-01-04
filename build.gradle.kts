plugins {
    java
    id("org.springframework.boot") version "2.7.18"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "ppzxc.learning"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

dependencies {
    // Use Tomcat
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework:spring-jdbc")
//    implementation("com.h2database:h2:2.2.220")
    implementation("com.h2database:h2:2.1.214")
//    implementation("hikari-cp:hikari-cp:3.0.1")
    implementation("com.zaxxer:HikariCP:5.1.0")
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