FROM eclipse-temurin:25-jre-alpine
VOLUME /tmp
ARG JAR_FILE=target/store-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8484
ENTRYPOINT ["java","-jar","/app.jar"]


