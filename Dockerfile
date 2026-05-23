FROM eclipse-temurin:21-jdk

WORKDIR /main-service

COPY target/main-service.jar main-service.jar

EXPOSE 8082

ENTRYPOINT ["java", ".jar", "main-service.jar"]