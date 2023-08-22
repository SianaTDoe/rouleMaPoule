# Utiliser une image de base contenant Maven et le JDK 17
FROM maven:3.8-openjdk-17

# Répertoire de travail dans le conteneur
WORKDIR /app

# Copier les fichiers sources de l'application
COPY src ./src
COPY pom.xml .

# Compiler l'application
RUN mvn clean package

# Exposer le port sur lequel l'application écoute
EXPOSE 8080

# Commande pour lancer l'application lorsque le conteneur démarre
CMD ["java", "-jar", "target/RouleMaPoule-0.0.1-SNAPSHOT.jar"]

