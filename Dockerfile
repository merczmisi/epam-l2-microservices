FROM openjdk:17-jdk-alpine
MAINTAINER baeldung.com
COPY target/microservices-1.0-SNAPSHOT.jar microservices-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=default","-jar","/micro-services-1.0-SNAPSHOT.jar"]