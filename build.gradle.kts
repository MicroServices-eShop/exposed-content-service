import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

buildscript {
    val springBootVersion: String = "1.5.4.RELEASE"//"2.0.0.M2"
    repositories {
        maven { setUrl("https://repo.gradle.org/gradle/repo") }
        maven { setUrl("https://repo.spring.io/snapshot") }
        maven { setUrl("https://repo.spring.io/milestone") }
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
        classpath(kotlin("gradle-plugin"))
        classpath(kotlin("allopen"))
        classpath(kotlin("noarg"))
    }
}

apply {
    plugin("kotlin")
    plugin("kotlin-spring")
    plugin("java")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    maven { setUrl("https://repo.gradle.org/gradle/repo") }
    maven { setUrl("https://repo.spring.io/snapshot") }
    maven { setUrl("https://repo.spring.io/milestone") }
}

configure<DependencyManagementExtension> {
    val springBootVersion: String = "1.5.4.RELEASE"//"2.0.0.M2"
    val springCloudVersion: String = "Dalston.SR1"//"Finchley.BUILD-SNAPSHOT"
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:$springBootVersion")
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
    }
}

dependencies {
    val swaggerVersion: String = "2.7.0"
    val jacksonModuleKotlinVersion = "2.8.7"
    compile(kotlin("stdlib"))
    compile(kotlin("reflect"))
    compile("org.projectlombok:lombok")
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("org.springframework.boot:spring-boot-starter-actuator")
    compile("org.springframework.boot:spring-boot-starter-data-redis")
    compile("org.springframework.boot:spring-boot-starter-hateoas")
    compile("org.springframework.cloud:spring-cloud-starter-eureka")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonModuleKotlinVersion")
//    compile("org.springframework.cloud:spring-cloud-starter-zipkin")
    compile("io.springfox:springfox-swagger2:$swaggerVersion")
    compile("io.springfox:springfox-swagger-ui:$swaggerVersion")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}

