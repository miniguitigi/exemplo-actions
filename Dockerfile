# Etapa de build
FROM maven:3-openjdk-17 AS builder
LABEL authors="miniguitigi"

WORKDIR /build

COPY . .

RUN mvn clean package -DskipTests -Dcheckstyle.skip=true

# Etapa de execução
FROM openjdk:17-slim

WORKDIR /app

COPY --from=builder /build/target/*.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]
