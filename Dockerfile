FROM openjdk:13-jdk-alpine
ADD target/argento-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -jar argento-0.0.1-SNAPSHOT.jar
