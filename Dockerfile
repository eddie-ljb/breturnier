FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY build/libs/Tippspiel-0.0.1-SNAPSHOT.jar Tippspiel-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Tippspiel-0.0.1-SNAPSHOT.jar"]