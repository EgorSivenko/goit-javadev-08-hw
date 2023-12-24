plugins {
    id("java")
    id("org.flywaydb.flyway") version "8.3.0"
    id("io.freefair.lombok") version "8.4"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

buildscript {
    dependencies {
        classpath("org.flywaydb:flyway-mysql:8.3.0")
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    implementation("com.mysql:mysql-connector-j:8.2.0")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
}

tasks.test {
    useJUnitPlatform()
}

flyway {
    url = "jdbc:mysql://127.0.0.1:3306/mega_soft"
    user = "root"
    password = "strong_password"
}