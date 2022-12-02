FROM openjdk:17-jdk-alpine
MAINTAINER baeldung.com
COPY target/micro-sender-1.0-SNAPSHOT.jar micro-sender-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=default","-jar","/micro-sender-1.0-SNAPSHOT.jar"]