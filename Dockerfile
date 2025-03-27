FROM maven:3.9.9-eclipse-temurin-21-alpine

WORKDIR /app
COPY . .
RUN mvn install -DskipTests
ENTRYPOINT ["java", "-jar", "target/caloriecounter-0.0.1-SNAPSHOT.jar"]