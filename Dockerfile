FROM maven:3.8.4-openjdk-17 as build

WORKDIR /app

COPY ./pom.xml ./pom.xml

RUN mvn dependency:go-offline -B

COPY ./src ./src
COPY ./frontend/themes /app/frontend/themes

RUN mvn package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/SpringVaadinTestApp-0.0.1-SNAPSHOT.jar ./SpringVaadinTestApp-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "SpringVaadinTestApp-0.0.1-SNAPSHOT.jar"]