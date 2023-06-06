FROM maven:3.8.6 AS build

ENV MYSQL_HOST /
ENV MYSQL_PORT /
ENV MYSQL_DB_NAME /
ENV MYSQL_USER /
ENV MYSQL_PASSWORD /

WORKDIR /app
COPY pom.xml /app

RUN mvn dependency:resolve
COPY . /app
RUN mvn clean
RUN mvn package -DskipTests

FROM openjdk:11-jdk-slim
COPY --from=build /app/target/mediscreenPatient.jar app.jar
CMD ["java", "-jar", "app.jar"]