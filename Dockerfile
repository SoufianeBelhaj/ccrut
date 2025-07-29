# Use a lightweight JDK image
FROM openjdk:17-jdk-slim

# Create app directory in the container
WORKDIR /app

# Copy your built JAR file into the container
COPY target/ccrut-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app uses
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
