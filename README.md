This project is a simple Spring Boot RESTful API that manages a collection of items.
It allows users to:
  Add a new item
  Retrieve an item by its ID
  
The application demonstrates core backend development concepts including RESTful API design, input validation, DTO pattern implementation, layered architecture, and persistent data storage using PostgreSQL.

Technologies Used
  Java 17
  Spring Boot
  Spring Data JPA
  PostgreSQL
  ModelMapper
  Maven

How to Run the Application

  Prerequisites:
  Java 17+
  Maven
  PostgreSQL running locally

Step 1: Configure Database
Update application.properties:

  spring.application.name=ItemModel
  spring.datasource.url= jdbc:postgresql://localhost:5432/ItemDB
  spring.datasource.username=postgres
  spring.datasource.password=root
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  spring.jpa.properties.hibernate.format_sql=true

Step 2: Run the Application
mvn spring-boot:run

Application will start at:
  http://localhost:8080

API Endpoints  

1. Add New Item
  POST /items

Creates a new item in the database.

Example Request:

{
  "name": "MacBook",
  "description": "Gaming laptop with 32GB RAM"
}

Response:
  200 OK → Item saved successfully
  400 Bad Request → Validation failed

2. Get Item by ID

  GET /ById/{id}
  Retrieves an item by its ID.

Example:
  GET /ById/1
  
Response:
  200 OK → Item found
  404 Not Found → Item does not exist

Important Implementation Details

The project follows layered architecture.

DTOs are used to separate request and response models.

ModelMapper is used for object mapping.

Validation annotations (@NotBlank) ensure required fields are provided.

Data is stored in PostgreSQL for persistence.
