Sci-All Payments API
Descripción
La Sci-All Payments API es un servicio que gestiona perfiles de pagos, notificaciones y operaciones relacionadas dentro del ecosistema de Sci-All. Está implementada en Java y sigue una arquitectura hexagonal para garantizar modularidad y escalabilidad.

Tecnologías
Java 17
Spring Boot
Spring Data JPA
Flyway (para migraciones de base de datos)
Docker (opcional, para contenedores)
H2 Database (por defecto, para pruebas locales)
Requisitos previos
Java 17 (Amazon Corretto u otra distribución compatible)
Maven 3.8.4 o superior
Docker (opcional, para instancias de base de datos)
Configuración inicial
Clonar el repositorio
bash

git clone https://github.com/Noctis-Dev/sci-all-payments-api.git
cd sci-all-payments-api
Compilar el proyecto y descargar dependencias
bash

mvn clean install
Configurar la base de datos
Si deseas usar una base de datos persistente, configura una instancia de PostgreSQL (local o con Docker).

bash

docker run --name sci_all_postgres -e POSTGRES_PASSWORD=adminadmin -p 5432:5432 -d postgres
Configura el archivo de propiedades application.properties (ubicado en src/main/resources) para que apunte a tu instancia de PostgreSQL:

properties
Copiar código
spring.datasource.url=jdbc:postgresql://localhost:5432/sci_all_payments
spring.datasource.username=postgres
spring.datasource.password=adminadmin
spring.jpa.hibernate.ddl-auto=update
Ejecutar las migraciones
Flyway aplicará automáticamente las migraciones definidas en el directorio db/migration cuando se inicie el proyecto.

Cómo ejecutar
Iniciar la aplicación
bash

mvn spring-boot:run
Acceder a la documentación de la API
La API expone una interfaz interactiva Swagger en:
http://localhost:8080/swagger-ui.html

