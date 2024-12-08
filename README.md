Sci-All Payments API
API desarrollada en Java 17 para gestionar perfiles de pagos, notificaciones y operaciones relacionadas, siguiendo una arquitectura hexagonal.

Tecnologías
Java 17
Spring Boot
Spring Data JPA
Flyway (para migraciones de base de datos)
Docker (opcional)
H2 Database (por defecto, para pruebas locales)
Requisitos
Tener Java 17 instalado en tu máquina. Puedes descargar Amazon Corretto aquí.
Maven (versión 3.8.4 o superior).

Descárgalo desde Maven.
Tener Docker instalado para configurar la base de datos (opcional). Descárgalo desde Docker Desktop.
Cómo Iniciar el Proyecto
Opción 1: Usando Docker para la base de datos
Clona el repositorio:
git clone https://github.com/Noctis-Dev/sci-all-payments-api.git
cd sci-all-payments-api
Construye la base de datos con Docker:

docker run --name sci_all_postgres -e POSTGRES_PASSWORD=adminadmin -p 5432:5432 -d postgres
Configura el archivo application.properties:
Abre el archivo src/main/resources/application.properties y asegura que la configuración sea la siguiente:

properties
spring.datasource.url=jdbc:postgresql://localhost:5432/sci_all_payments
spring.datasource.username=postgres
spring.datasource.password=adminadmin
spring.jpa.hibernate.ddl-auto=update
Compila el proyecto:

mvn clean install
Ejecuta la aplicación:
mvn spring-boot:run
Accede a la API:
Abre http://localhost:8080/swagger-ui.html para ver la documentación interactiva de la API.
