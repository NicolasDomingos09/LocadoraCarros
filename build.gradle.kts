plugins {
    java
    war
    id("org.springframework.boot") version "3.5.7"
    id("io.spring.dependency-management") version "1.1.7"
}
apply(plugin = "project-report")

group = "br.edu.fateczl"
version = "0.0.1-SNAPSHOT"
description = "LocadoraCarros"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.microsoft.sqlserver:mssql-jdbc")
    annotationProcessor("org.projectlombok:lombok")
    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // https://mvnrepository.com/artifact/net.sf.jasperreports/jasperreports-pdf
    implementation("net.sf.jasperreports:jasperreports-pdf:7.0.2")

    // https://mvnrepository.com/artifact/net.sf.jasperreports/jasperreports
    implementation("net.sf.jasperreports:jasperreports:7.0.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
