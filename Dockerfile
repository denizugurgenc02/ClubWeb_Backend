FROM openjdk:25-jdk-slim
LABEL authors="denizugurgenc02"

WORKDIR /app


COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

COPY src src

RUN ./mvnw clean install -DskipTests