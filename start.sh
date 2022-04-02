#!/bin/sh
mvn -f /home/app/pom.xml clean package
java -jar /home/app/target/demoshop.jar