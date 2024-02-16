FROM openjdk:8-jdk-alpine
COPY target/spring-boot--bancom-0.0.1-SNAPSHOT.jar app-bancom.jar
ENTRYPOINT ["java","-jar","/app-bancom.jar"]