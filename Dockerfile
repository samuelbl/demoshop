FROM maven:3.8.4-jdk-11-slim as maven
# Build and Deploy
# Modifies to build in docker after running the postgres container.
COPY src /home/app/src
COPY pom.xml /home/app
COPY start.sh /home/app/start.sh
EXPOSE 8080
ENTRYPOINT ["sh","/home/app/start.sh"]
