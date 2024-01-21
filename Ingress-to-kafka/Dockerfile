# Используем OpenJDK 11 в качестве базового образа
# FROM adoptopenjdk:11-jre-hotspot
FROM openjdk:11-slim-bullseye

# Устанавливаем рабочую директорию в /app
WORKDIR /app

EXPOSE 8088

# Копируем JAR-файл в образ
COPY target/Ingress-to-kafka-0.0.1-SNAPSHOT.jar Ingress-to-kafka-0.0.1-SNAPSHOT.jar

# Команда, которая будет выполнена при запуске контейнера
CMD ["java", "-jar", "Ingress-to-kafka-0.0.1-SNAPSHOT.jar"]
