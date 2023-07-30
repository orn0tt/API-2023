FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/aula10-Service-0.0.1-SNAPSHOT.jar aula10-jwt
ENTRYPOINT [ "java","-jar","/aula10-jwt" ]