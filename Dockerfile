FROM maven:3.8.4-jdk-11-slim as maven

# Build stage
# Modifies to build in docker after running the postgres container.
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
EXPOSE 8080
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/home/app/target/demoshop.jar"]

