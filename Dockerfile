# Stage 1: Build the application
FROM gradle:8.5-jdk21 AS build

WORKDIR /app

COPY build.gradle settings.gradle /app/

COPY src /app/src

RUN gradle clean build -x test

FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

COPY --from=build /app/build/libs/sync-data-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]