export CATALINA_OPTS="$CATALINA_OPTS -javaagent:/usr/local/tomcat/lib/opentelemetry-javaagent.jar -Dotel.javaagent.extensions=/usr/local/tomcat/lib/spring-extension.jar"