# gateway/Dockerfile
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY shortlink-gateway.jar app.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","/app/app.jar","--server.port=8000"]