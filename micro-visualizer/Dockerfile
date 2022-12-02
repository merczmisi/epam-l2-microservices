FROM openjdk:17-jdk-alpine
MAINTAINER baeldung.com
COPY target/micro-visualizer-1.0-SNAPSHOT.jar micro-visualizer-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=default","-jar","/micro-visualizer-1.0-SNAPSHOT.jar"]