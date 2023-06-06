FROM maven:3.8.6 AS build

WORKDIR /app
COPY pom.xml /app

RUN mvn dependency:resolve
COPY . /app
RUN mvn clean
RUN mvn package -DskipTests

FROM openjdk:11-jdk-slim
COPY --from=build /app/target/mediscreenDiabet.jar app.jar
CMD ["java", "-jar", "app.jar"]