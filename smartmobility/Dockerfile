######## Maven build stage ########
FROM maven:3.8.1-openjdk-17 as build
WORKDIR /workspace/app

COPY pom.xml .
COPY src src

RUN --mount=type=cache,target=/root/.m2 mvn install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

######## SmartMobility Application build stage ########
FROM openjdk:17.0-jdk-oracle

VOLUME /tmp

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]