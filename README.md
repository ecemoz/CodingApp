# Coding App Backend

This project is a Spring Boot backend application designed to teach users coding skills through various tasks and levels. Users can register, complete tasks to earn points, and climb the leaderboard. This README provides an overview of the project, setup steps, configuration requirements, and API endpoints.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
  - [Requirements](#requirements)
  - [Installation](#installation)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
  - [User](#user)
  - [Task](#task)
  - [Submission](#submission)
  - [Leaderboard](#leaderboard)
- [Database Schema](#database-schema)
- [Customization](#customization)

## Features

- **User Registration and Authentication**: Basic HTTP authentication for secure login.
- **Task Management**: Users can view and complete coding tasks to earn points.
- **Submissions**: Handles task submissions and evaluates results.
- **Leaderboard**: Ranks users based on scores and completion of tasks.

## Getting Started

### Requirements

- **Java 17 or higher**
- **Spring Boot 3.0+**
- **PostgreSQL** or **MySQL**
- **Postman** (for API testing)

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/ecemoz/coding-app.git
   cd coding-app
   ```

2. **Configure Database**:
   - Update `application.properties` with your database details:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/coding_app
     spring.datasource.username=your_db_username
     spring.datasource.password=your_db_password
     ```

3. **Build and Run the Application**:
   ```bash
   ./gradlew clean build
   ./gradlew bootRun
   ```

4. **Access the Application**:
   - The server should start on `http://localhost:3000`.

## Project Structure

```
src/main/java/com/galata/codingapp
│
├── controller         # REST controllers for API endpoints
├── model              # Entity classes for database tables
├── repository         # Interfaces for JPA repositories
├── service            # Business logic for various models
└── security           # Security configuration
```

## API Endpoints

### User

| Endpoint                | Method | Description                  |
|-------------------------|--------|------------------------------|
| `/users/`               | `GET`  | Retrieve all users           |
| `/users/{id}`           | `GET`  | Retrieve a user by ID        |
| `/users/signup`         | `POST` | Register a new user          |
| `/users/login`          | `POST` | Login an existing user       |
| `/users/{id}`           | `PUT`  | Update user details          |
| `/users/{id}`           | `DELETE` | Delete a user             |

### Task

| Endpoint                | Method | Description                  |
|-------------------------|--------|------------------------------|
| `/tasks/`               | `GET`  | Retrieve all tasks           |
| `/tasks/{id}`           | `GET`  | Retrieve a task by ID        |
| `/tasks/`               | `POST` | Add a new task               |
| `/tasks/{id}`           | `PUT`  | Update a task                |
| `/tasks/{id}`           | `DELETE` | Delete a task             |

### Submission

| Endpoint                | Method | Description                  |
|-------------------------|--------|------------------------------|
| `/submissions/`         | `GET`  | Retrieve all submissions     |
| `/submissions/{id}`     | `GET`  | Retrieve a submission by ID  |
| `/submissions/`         | `POST` | Submit a solution            |

### Leaderboard

| Endpoint                | Method | Description                  |
|-------------------------|--------|------------------------------|
| `/leaderboard/`         | `GET`  | Retrieve leaderboard         |

## Database Schema

- **User**: `id`, `username`, `email`, `password`, `score`, `level`
- **Task**: `id`, `title`, `description`, `level_required`, `points`
- **Submission**: `id`, `task_id`, `user_id`, `submitted_code`, `status`, `score`

## Customization

To customize the application, modify the configurations in `application.properties`. You can also extend the models, services, and controllers to add new features.
