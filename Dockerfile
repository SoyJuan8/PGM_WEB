# Utiliza una imagen base de Maven con JDK 17
FROM maven:3.8.4-openjdk-17-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo pom.xml al directorio de trabajo
COPY pom.xml .

# Descarga las dependencias del proyecto
RUN mvn dependency:go-offline

# Copia el código fuente al directorio de trabajo
COPY src ./src

# Compila el proyecto y empaquétalo en un archivo JAR
RUN mvn package -DskipTests

# Expone el puerto 8080 para la aplicación de Spring
EXPOSE 9091

# Comando para ejecutar la aplicación Spring al iniciar el contenedor
CMD ["java", "-jar", "target/project-web-burguer-0.0.1-SNAPSHOT.jar"]
