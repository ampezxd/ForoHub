**ForoHub API** 💬
------------------------------------------------------------------------------------------------------------------------
API ForoHub es una API RESTful construida con Java y Spring Boot, diseñada para gestionar tópicos en un sistema de foro. 
Implementa un sistema de autenticación y autorización robusto utilizando Spring Security y JSON Web Tokens (JWT), 
garantizando que solo los usuarios autenticados puedan interactuar con los recursos del foro.


🌟 **Características Principales**
------------------------------------------------------------------------------------------------------------------------
* Gestión de Tópicos (CRUD):
 * Crear: Permite a los usuarios crear nuevos tópicos con título y mensaje.
 * Listar: Visualiza todos los tópicos existentes o filtra por criterios específicos.
 * Actualizar: Modifica la información de tópicos ya creados.
 * Eliminar: Borra tópicos de forma permanente.

* Autenticación y Autorización Segura:
 * Implementa Spring Security para la gestión de usuarios y roles.
 * Utiliza JSON Web Tokens (JWT) para la autenticación de usuarios y la protección de endpoints.
 * Validaciones de Negocio: Asegura la integridad de los datos, previniendo tópicos duplicados o datos nulos.
 * Persistencia de Datos: Almacenamiento eficiente de tópicos, respuestas, cursos y usuarios en una base de datos relacional.

 🛠️ **Tecnologías Utilizadas**
 ------------------------------------------------------------------------------------------------------------------------
 * Java 17+: El lenguaje de programación principal.
 * Spring Boot: Framework para el desarrollo rápido y eficiente de aplicaciones Spring.
 * Spring Data JPA: Para una interacción ORM simplificada con la base de datos.
 * Spring Security: Proporciona autenticación, autorización y protección contra vulnerabilidades comunes.
 * JSON Web Tokens (JWT): Para una autenticación de usuario sin estado y segura.
 * MySQL / MariaDB: Base de datos relacional para persistir la información (configurable).
 * Flyway: Para la gestión de migraciones de base de datos, asegurando la consistencia del esquema.
 * Maven: Herramienta de gestión de proyectos y dependencias.
 * Lombok: Para reducir el código boilerplate en las entidades y DTOs.
 * Validación de Jakarta (Bean Validation): Para asegurar la integridad de los datos de entrada.


**Cómo configurar y probar el proyecto**
---------------------------------------------------------------------------------------------------------------------------
Sigue estos pasos para poner en marcha la API ForoHub en tu entorno local.

*Prerequisitos*
Antes de empezar, asegúrate de tener instalado:

* Java Development Kit (JDK) 17 o superior.
* Maven (generalmente incluido con tu IDE o puedes descargarlo).
* Un servidor de base de datos MySQL o MariaDB en ejecución.
* Un cliente REST como Insomnia o Postman para probar los endpoints.

1.  **Clona el Repositorio:**
    ```bash
    git clone [https://github.com/ampezxd/ForoHub.git](https://github.com/ampezxd/ForoHub.git)
    ```
2.  **Navega al Directorio del Proyecto:**
    ```bash
    cd ForoHub
    ```
3.  **Configura la Base de Datos:**
    * Asegúrate de tener una instancia de **MySQL** o **MariaDB** corriendo.
    * Actualiza el archivo `src/main/resources/application.properties` (o `application.yml`) con las credenciales de tu base de datos.
    * Las migraciones de **Flyway** se encargarán de crear el esquema de la base de datos automáticamente al iniciar la aplicación.
4.  **Ejecuta la Aplicación:**
    ```bash
    ./mvnw spring-boot:run
    ```
    La aplicación estará disponible en `http://localhost:8080`.


