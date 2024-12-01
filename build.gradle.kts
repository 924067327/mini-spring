plugins {
    id("java")
}

java {
    tasks.withType<JavaCompile> {
        // 这里设置 Java 编译任务的编码为 UTF-8
        options.encoding = "UTF-8"
    }
}

group = "com.blackhuang.mini.spring"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    implementation(libs.cglib)
    implementation(libs.hutoolsall)

    testCompileOnly(libs.lombok)
    testAnnotationProcessor(libs.lombok)
    testImplementation(platform(libs.junitbom))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}