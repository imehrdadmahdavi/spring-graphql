# **Spring Boot GraphQL API Demo**

This repository contains a Spring Boot GraphQL application that demonstrates the features of Spring GraphQL. It utilizes an in-memory H2 database to store information about dogs and exposes GraphQL endpoints to interact with the data.

## **Tech Stack**

- Spring Boot
- Spring GraphQL
- H2 Database
- Maven
- Java

## **System Requirements**

- JDK 11 or later
- Maven 3.0+

## **Setup and Installation**

1. Clone the repository or download the source code.
2. Open your terminal or command prompt and navigate to the root directory of the project.
3. Run the following command to build the project and install dependencies:
    
    ```
    ./mvnw clean install
    ```
    
4. After a successful build, navigate to the **`target`** directory, where you will find the executable JAR file.

## **How to Run the Application**

1. You can run the application directly from the command line using the following command:
    
    ```
    java -jar target/DogGraphQL-0.0.1-SNAPSHOT.jar
    ```
    
2. The application will start running at **[http://localhost:8080](http://localhost:8080/)**.

## **Usage**

This application uses GraphQL, which means the client specifies exactly what data it needs, making it possible to get all required data in a limited number of requests. Here is an example of a POST request you can make to the application:

You can make a POST request to the **`/graphql`** endpoint with the following body:

```
{
	"query":"{findAllDogs { id breed } }"
}
```

This query requests the **`id`** and **`breed`** of all dogs in the database.

When making the request, make sure to set the **`Content-Type`** header to **`application/json`**.

Here is an example of how you can make this request using **`curl`**:

```
curl -X POST -H "Content-Type: application/json" -d '{"query":"{findAllDogs { id breed } }"}' http://localhost:8080/graphql
```

The application will return a JSON response with the requested data.

## **Directory Structure**

- **`src/main/java/udacity/DogGraphQL/entity`**: This package contains the **`Dog`** entity class, representing the data stored in the database.
- **`src/main/java/udacity/DogGraphQL/repository`**: This package contains the repository interface for interacting with the database.
- **`src/main/java/udacity/DogGraphQL/exception`**: This package contains the **`DogNotFoundException`** and **`BreedNotFoundException`** classes, exceptions thrown when a dog or a breed cannot be found.
- **`src/main/resources`**: This directory contains application configuration file and database schemas.
- **`src/test`**: This directory contains tests for the application.
- **`target`**: This directory contains the output of the build process.
- **`pom.xml`**: This is the Project Object Model (POM) file in Maven, which defines the project and its configuration details used by Maven to build the project.

## **Architectural Diagram**

```
cssCopy code
Query/Mutation ----> Repository ----> Dog Table in H2 Database
      |
      v
DogNotFoundException
BreedNotFoundException
```