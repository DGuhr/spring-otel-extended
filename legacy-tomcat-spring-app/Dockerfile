# Step 1: OpenTelemetry Java Agent
FROM curlimages/curl:latest AS downloader
WORKDIR /app
RUN curl -L -o opentelemetry-javaagent.jar "https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v1.33.0/opentelemetry-javaagent.jar"

# Step 2: Build the application
FROM tomcat:9-jdk11-openjdk

RUN rm -rf /usr/local/tomcat/webapps

COPY --from=downloader /app/opentelemetry-javaagent.jar /usr/local/tomcat/lib/opentelemetry-javaagent.jar

COPY target/*.war /usr/local/tomcat/webapps/ROOT.war
COPY agent/otel-javaagent-spring-extension-1.0-SNAPSHOT.jar /usr/local/tomcat/lib/spring-extension.jar
COPY setenv.sh /usr/local/tomcat/bin/setenv.sh
EXPOSE 8080

ENTRYPOINT ["catalina.sh", "run"]