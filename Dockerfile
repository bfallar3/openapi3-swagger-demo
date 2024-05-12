FROM eclipse-temurin:17-jdk-alpine
EXPOSE 80:8080
COPY target/openapi-swagger-demo-0.0.1-SNAPSHOT.jar openapi-swagger-demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","openapi-swagger-demo-0.0.1-SNAPSHOT.jar"]