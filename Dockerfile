FROM maven:3.8.6-openjdk-18 AS MAVEN
WORKDIR /tmp
COPY /src/ ./src
COPY /pom.xml ./
RUN mvn package

FROM openjdk:15-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","/app.jar"]
