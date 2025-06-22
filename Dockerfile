FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY . .
RUN ./mvnw clean install
EXPOSE 8080
CMD ["java", "-jar", "target/gestion-usuarios-0.0.1-SNAPSHOT.jar"]
