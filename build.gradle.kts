plugins {
	java
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(23)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	runtimeOnly("com.microsoft.sqlserver:mssql-jdbc")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("javax.servlet:javax.servlet-api:4.0.1")
	implementation("org.springframework.boot:spring-boot-starter-logging")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
