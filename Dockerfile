# Fetch base image of OpenJDK 17 JRE
FROM openjdk:17-jdk

# Specify the author
LABEL maintainer="Bukhari.kibuka7@gmail.com"

# Provide volume to mount
VOLUME /tmp

# Expose the port
EXPOSE 8000

# Copy .jar file to the container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Execute the application
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
