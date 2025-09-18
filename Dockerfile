# Use an official OpenJDK as a base image
FROM openjdk:17-jdk-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/invoicing-0.0.1-SNAPSHOT.jar invoicing-0.0.1-SNAPSHOT.jar

# Command to run the Java application
ENTRYPOINT ["java", "-jar", "invoicing-0.0.1-SNAPSHOT.jar"]

# Expose the port your app is running on
EXPOSE 8071
