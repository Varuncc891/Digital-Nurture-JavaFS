# Week 3: Spring RESTful Web Services & Security
This directory contains completed hands-on exercises for Week 3, focusing on building secure REST APIs using Spring Boot, Spring Security, and JSON Web Tokens (JWT).

## Projects Included
### spring-rest-service (REST API, Exception Handling, Security & JWT)
A comprehensive web API service demonstrating:
*   **Hello API**: Simple text response controller.
*   **Resources Controllers**: Complete GET, POST, PUT, and DELETE CRUD handlers for Country and Employee tables.
*   **Validations**: Parameter validation constraints like @NotBlank, @Email, and @Size.
*   **Global Exceptions**: Exception filtering using @RestControllerAdvice to format validation or lookup failures.
*   **Spring Security & JWT**: State-free authorization filter intercepting requests via Bearer headers, and a token generation POST /authenticate gateway.

---

## Running and Testing the API

### 1. Build and Start
Run from the project root:
```bash
../../maven/apache-maven-3.8.8/bin/mvn clean compile
../../maven/apache-maven-3.8.8/bin/mvn spring-boot:run
```

### 2. Generate a JWT Token
Send a POST request to `/authenticate`:
```bash
curl -X POST http://localhost:8080/authenticate \
     -H "Content-Type: application/json" \
     -d "{\"username\":\"admin\", \"password\":\"admin123\"}"
```

### 3. Fetch Secure Resource
Use the token in the Authorization header:
```bash
curl -X GET http://localhost:8080/api/employees \
     -H "Authorization: Bearer <JWT_TOKEN>"
```
