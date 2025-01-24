# Chat Application

This is a simple **Chat Application** built with **Spring Boot** and **WebSocket**. The application supports real-time communication between users using WebSocket for bidirectional communication. The project also includes **CORS** configuration to allow cross-origin requests.

## Features

- Real-time chat functionality using WebSocket.
- Simple chat interface with the ability to send and receive messages.
- CORS configuration to handle cross-origin requests.
- Persistence layer using **JPA** and **SQL database**.

## Technologies Used

- **Spring Boot** - Backend framework.
- **WebSocket** - Real-time messaging protocol.
- **Spring Data JPA** - To interact with the database.
- **SQL Database** - MySQL or any other database supported by JPA.
- **Spring Web** - For building the RESTful web services.
- **CORS Configuration** - To allow cross-origin requests.

## Dependencies

- **Spring Boot Starter Web** - For building web applications.
- **Spring Boot Starter Data JPA** - For JPA and database integration.
- **Spring Boot Starter WebSocket** - For enabling WebSocket support.
- **MySQL JDBC Driver** - For connecting to MySQL or any relational database.

## How to Clone and Run the Application

### Step 1: Clone the Repository

You can clone the repository using the following command:

```bash
git clone https://github.com/Aditya-96108/Chat_Application.git
```

Step 2: Navigate to the Project Directory

```bash
cd Chat_Application
```

Step 3: Configure the Database
Before running the application, make sure you have a database set up and properly configured in the application.properties file.

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/chat_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
Step 4: Build the Application
You can build the application using Maven (since this is a Spring Boot project):
```bash
mvn clean install
```
Step 5: Run the Application
To run the application, use the following command:

```bash
mvn spring-boot:run
```
Step 6: Access the Application
Once the application is up and running, you can access it via:
```bash
http://localhost:8080
```
Contributing
Feel free to fork the repository, make improvements, and create pull requests. If you find any bugs or have suggestions, open an issue in the GitHub repository.
Happy chatting! 😄

### Instructions to include in your repository:
- The user needs to set up a database and configure the connection in `application.properties` (or `application.yml` if you're using YAML configuration).
- The commands to clone, build, and run the application.
- Information about the dependencies and how to configure them.
  
Make sure you replace `"your_password"` and other relevant fields with the correct information for your project.

Let me know if you need more changes or have additional details to add!
