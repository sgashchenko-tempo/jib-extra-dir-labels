plugins {
  id("java")
  id("com.google.cloud.tools.jib") version ("3.4.2")
}

group = "github"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(platform("org.junit:junit-bom:5.10.0"))
  testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
  useJUnitPlatform()
}

jib {
  from {
    image = "eclipse-temurin:17-jre-alpine"
  }
  to {
    image = "jib-extra-dir-labels:latest"
  }
  extraDirectories {
    paths {
      path {
        setFrom(layout.projectDirectory.dir("extra-dir"))
      }
    }
  }
  container {
    labels.put("some-label", "some-value")
  }
}
