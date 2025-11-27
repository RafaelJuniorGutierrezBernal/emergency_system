# Sistema de Gestión de Emergencias

Sistema de gestión de emergencias desarrollado con Spring Boot que permite la administración de incidentes, recursos, reportes y usuarios. El sistema proporciona una API REST completa para la gestión eficiente de situaciones de emergencia.

## 📋 Descripción

Este sistema permite:
- **Gestión de Incidentes**: Crear, actualizar, consultar y eliminar incidentes de emergencia
- **Gestión de Recursos**: Administrar recursos disponibles (vehículos, equipos, personal)
- **Gestión de Reportes**: Generar y consultar reportes de emergencias
- **Gestión de Usuarios**: Administrar usuarios del sistema

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.5.0**
- **Spring Data JPA**: Para el acceso a datos
- **Spring Security**: Para la seguridad de la aplicación
- **PostgreSQL**: Base de datos relacional
- **Lombok**: Para reducir código boilerplate
- **SpringDoc OpenAPI**: Para documentación de la API (Swagger)
- **Maven**: Gestión de dependencias y construcción del proyecto
- **Spring Boot Validation**: Para validación de datos

## 📦 Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- **JDK 17** o superior
- **Maven 3.6+**
- **PostgreSQL 12+**
- Un IDE compatible con Java (IntelliJ IDEA, Eclipse, VS Code, etc.)

## ⚙️ Configuración

### 1. Base de Datos

Crea una base de datos PostgreSQL llamada `Emergency_db`:

```sql
CREATE DATABASE Emergency_db;
```

### 2. Configuración de la Aplicación

Edita el archivo `src/main/resources/application.properties` con tus credenciales de PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/Emergency_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

### 3. Configuración del Puerto

El servidor se ejecuta por defecto en el puerto **8081**. Puedes cambiarlo en `application.properties`:

```properties
server.port=8081
```

## 🚀 Instalación y Ejecución

### Opción 1: Usando Maven Wrapper (Recomendado)

```bash
# Windows
.\mvnw.cmd spring-boot:run

# Linux/Mac
./mvnw spring-boot:run
```

### Opción 2: Usando Maven

```bash
mvn clean install
mvn spring-boot:run
```

### Opción 3: Ejecutar el JAR

```bash
mvn clean package
java -jar target/emergency_system-0.0.1-SNAPSHOT.jar
```

## 📁 Estructura del Proyecto

```
emergency_system/
├── src/
│   ├── main/
│   │   ├── java/com/emergency_system/emergency_system/
│   │   │   ├── config/              # Configuraciones (Security, etc.)
│   │   │   ├── controller/          # Controladores REST
│   │   │   │   ├── IncidentController.java
│   │   │   │   ├── ResourceController.java
│   │   │   │   ├── ReportController.java
│   │   │   │   └── UserController.java
│   │   │   ├── service/             # Interfaces de servicios
│   │   │   │   └── impl/            # Implementaciones de servicios
│   │   │   ├── repository/          # Repositorios JPA
│   │   │   ├── models/
│   │   │   │   ├── entities/        # Entidades JPA
│   │   │   │   └── dtos/            # Data Transfer Objects
│   │   │   │       ├── Request/     # DTOs de solicitud
│   │   │   │       └── Response/    # DTOs de respuesta
│   │   │   ├── mapper/              # Mappers para conversión DTO-Entity
│   │   │   └── EmergencySystemApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/                        # Pruebas unitarias
└── pom.xml
```

## 🔌 Endpoints Principales

### Incidentes (`/api/incidents`)

- `GET /api/incidents` - Obtener todos los incidentes
- `GET /api/incidents/{id}` - Obtener un incidente por ID
- `GET /api/incidents/search?type={tipo}&location={ubicacion}` - Buscar incidentes
- `POST /api/incidents` - Crear un nuevo incidente
- `PUT /api/incidents/{id}` - Actualizar un incidente
- `PATCH /api/incidents/{id}/status` - Actualizar estado de un incidente
- `DELETE /api/incidents/{id}` - Eliminar un incidente

### Recursos (`/api/resources`)

- `GET /api/resources` - Obtener todos los recursos
- `GET /api/resources/{id}` - Obtener un recurso por ID
- `POST /api/resources` - Crear un nuevo recurso
- `PUT /api/resources/{id}` - Actualizar un recurso
- `DELETE /api/resources/{id}` - Eliminar un recurso

### Reportes (`/api/reports`)

- Endpoints para gestión de reportes (consultar controlador para detalles)

### Usuarios (`/users`)

- `GET /users` - Obtener todos los usuarios
- `GET /users/{id}` - Obtener un usuario por ID
- `PUT /users/{id}` - Actualizar un usuario
- `DELETE /users/{id}` - Eliminar un usuario

## 📚 Documentación de la API

Una vez que la aplicación esté ejecutándose, puedes acceder a la documentación interactiva de la API (Swagger UI) en:

```
http://localhost:8081/swagger-ui.html
```

O la documentación en formato OpenAPI JSON:

```
http://localhost:8081/v3/api-docs
```

## 🏗️ Arquitectura

El proyecto sigue una arquitectura en capas:

1. **Capa de Controladores (Controller)**: Maneja las peticiones HTTP y devuelve respuestas
2. **Capa de Servicios (Service)**: Contiene la lógica de negocio
3. **Capa de Repositorios (Repository)**: Acceso a datos mediante Spring Data JPA
4. **Capa de Entidades (Entity)**: Modelos de datos persistentes
5. **Capa de DTOs**: Objetos de transferencia de datos para las peticiones y respuestas
6. **Capa de Mappers**: Convierte entre DTOs y Entidades

## 🔒 Seguridad

El sistema utiliza Spring Security para la autenticación. Actualmente, la configuración requiere autenticación para todas las peticiones. Puedes personalizar la configuración de seguridad en `SecurityConfig.java`.

## 🧪 Pruebas

Para ejecutar las pruebas unitarias:

```bash
mvn test
```

## 📝 Notas Adicionales

- La base de datos se actualiza automáticamente gracias a `spring.jpa.hibernate.ddl-auto=update`
- Las consultas SQL se muestran en consola cuando `spring.jpa.show-sql=true`
- Los timestamps (`createdAt`, `updatedAt`) se generan automáticamente mediante `@PrePersist` y `@PreUpdate`

## 👥 Contribución

Este es un proyecto de demostración. Si deseas contribuir:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT.

## 📧 Contacto

Para más información o consultas sobre el proyecto, por favor contacta al equipo de desarrollo.

---

**Versión**: 0.0.1-SNAPSHOT  
**Última actualización**: 2025

