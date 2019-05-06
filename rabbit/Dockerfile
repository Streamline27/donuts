FROM openjdk:8-jdk-alpine
COPY ./build/libs/rabbit-*.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]