# Use an official OpenJDK runtime as a parent image
FROM openjdk:23-jdk-slim as base

# Set the working directory in the container
WORKDIR /app

# Expose the port the application runs on
EXPOSE 8080

FROM gradle:8.12.0-jdk23 as build
WORKDIR /src
COPY . /src/
RUN cd /src && ./gradlew clean build

FROM base as final
WORKDIR /app
COPY --from=build /src/build/libs/*.jar /app/publish/
ENTRYPOINT ["java","-jar","/app/publish/sneakerlookup-0.0.1-SNAPSHOT.jar"]