FROM openjdk:17-jdk-alpine
MAINTAINER baeldung.com
COPY target/micro-collector-1.0-SNAPSHOT.jar micro-collector-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=default","-jar","/micro-collector-1.0-SNAPSHOT.jar"]
