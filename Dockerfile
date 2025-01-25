FROM eclipse-temurin:17-jdk-jammy

COPY target/user-service-0.0.1-SNAPSHOT.jar /tmp/user-service.jar

CMD ["java", "-jar", "/tmp/user-service.jar"]
