# Step 1: Get the OpenTelemetry Java Agent
FROM curlimages/curl:latest AS downloader
WORKDIR /app
RUN curl -L -o opentelemetry-javaagent.jar "https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v1.33.0/opentelemetry-javaagent.jar"

# Step 2: Build the application
FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=downloader /app/opentelemetry-javaagent.jar opentelemetry-javaagent.jar
ADD target/*.jar aspect-instrumented-app.jar

EXPOSE 8080

CMD ["java", "-javaagent:opentelemetry-javaagent.jar", "-jar", "aspect-instrumented-app.jar"]