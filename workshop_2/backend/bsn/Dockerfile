# Use the gradle image to build your application
FROM gradle:8.2.0-jdk17-jammy as builder

# Copy in your source code
COPY --chown=gradle:gradle . /home/gradle/src

# Set the working directory
WORKDIR /home/gradle/src

# Compile the application
RUN gradle assemble --no-daemon

# Now, create the runtime image
FROM openjdk:17-jdk-slim

# Copy the built artifacts from the builder stage
COPY --from=builder /home/gradle/src/build/libs/*.jar /app/application.jar

# Set the working directory
WORKDIR /app

# Command to run the application
CMD ["java", "-jar", "application.jar"]
