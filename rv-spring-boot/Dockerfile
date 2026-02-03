# Bước 1: Build ứng dụng bằng Maven và Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Bước 2: Chạy ứng dụng bằng JRE Java 21
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
# Đảm bảo copy đúng tên file jar trong thư mục target
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]