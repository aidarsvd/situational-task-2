FROM maven:3.9.5 AS build

WORKDIR consumer

COPY src ./src
COPY pom.xml .

RUN mvn clean package -DskipTests

FROM openjdk:17

COPY --from=build consumer/target/consumer.jar consumer.jar

ENTRYPOINT ["java", "-jar", "consumer.jar"]