# Use an official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Install dos2unix to convert Windows line endings to Unix line endings
RUN apt-get update && apt-get install -y dos2unix

# Convert gradlew to Unix format
RUN dos2unix gradlew

# Add execute permissions to the gradlew file
RUN chmod +x gradlew

# Build the project using the Gradle wrapper
RUN ./gradlew build --stacktrace

# Copy the built JAR file to /run/hoshino.jar
WORKDIR /run

# List the files in the /app/app/build/libs directory
RUN ls -l /app/app/build/libs

RUN cp /app/app/build/libs/hoshino.jar /run/hoshino.jar

# Copy the .env file to the container
COPY .env.example /run/.env

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the app when the container launches
CMD ["java", "-jar", "/run/hoshino.jar"]