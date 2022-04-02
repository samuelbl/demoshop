FROM maven:3.8.4-jdk-11-slim

#
# Build stage
#
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/app/target/demoshop.jar"]

CMD [""]