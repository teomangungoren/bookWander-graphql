FROM openjdk:17-jdk-slim AS build

WORKDIR /app

COPY build/libs/lib-0.0.1-SNAPSHOT.jar lib.jar

EXPOSE 8080

CMD ["java","-jar","lib.jar"]