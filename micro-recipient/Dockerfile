FROM openjdk:17-jdk-alpine
MAINTAINER baeldung.com
COPY target/micro-recipient-1.0-SNAPSHOT.jar micro-recipient-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=default","-jar","/micro-recipient-1.0-SNAPSHOT.jar"]