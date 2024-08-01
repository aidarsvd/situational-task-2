FROM maven:3.9.5 AS build

WORKDIR producer

COPY src ./src
COPY pom.xml .

RUN mvn clean package -DskipTests

FROM openjdk:17

COPY --from=build producer/target/producer.jar producer.jar

ENTRYPOINT ["java", "-jar", "producer.jar"]