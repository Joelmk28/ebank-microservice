# 1. On part d'une image légère de Java 17 (ou 21 selon ta version)
FROM eclipse-temurin:21-jdk-alpine

# 2. On crée un dossier pour l'application
WORKDIR /app

# 3. On copie le fichier JAR généré par Maven dans le container
# (On suppose que tu as fait un 'mvn clean package' avant)
COPY target/*.jar app.jar

# 4. On expose le port du service (ex: 8056)
EXPOSE 8056

# 5. On lance l'application
ENTRYPOINT ["java", "-jar", "app.jar"]