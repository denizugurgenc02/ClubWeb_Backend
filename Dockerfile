FROM eclipse-temurin:25-jdk
LABEL authors="denizugurgenc02"

WORKDIR /app


COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

COPY src src

RUN ./mvnw clean install -DskipTests