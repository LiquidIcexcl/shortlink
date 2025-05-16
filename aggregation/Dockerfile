# aggregate/Dockerfile
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY shortlink-aggregation.jar app.jar
EXPOSE 8003
ENTRYPOINT ["java","-jar","/app/app.jar","--server.port=8003"]