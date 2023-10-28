# Expense Tracker API

This is an REST API project implemented in Spring Boot. It provides CRUD APIs for tracking expenses. 

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [License](#license)

## Introduction

This project provides REST API functionality for tracking expenses for a user.

## Features

- Register and Login User
- API Authorization using JSON Web Token (JWT)
- Categorize Expenses
- API endpoints to manaage categories and expenses.
- CORS Support

## Installation

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/sunnypatel2048/expense-tracker-api.git
   ```

2. Switch to the project directory:

    ```bash
    cd expense-tracker-api
    ```

## Usage

**1. Spin up PostgreSQL database instance**

  You can use either of the below two options:
   - One option is to download from [here](https://www.postgresql.org/download) and install locally on the machine.
   - Other option is to run a postgres docker container using,

     ```sh
     docker container run --name postgresdb -e POSTGRES_PASSWORD=admin -d -p 5432:5432 postgres
     ```

**2. Create database objects**

There is a SQL script (expensetracker_db.sql) in the root folder of the project for creating all the necessary database objects.

- Run below script if using Docker PostgreSQL instance,
  ```sh
  docker container cp expensetracker_db.sql postgresdb:/
  ```
  ```sh
  docker container exec -it postgresdb bash
  ```

  The first command copies the sql script to the running container and then the second command executes that script in the container.

- Run the below script using psql client if using installed PostgresSQL,
  ```bash
  psql -U postgres --file expensetracker_db.sql
  ```

**3. (Optional) Update database configurations in application.properties**

If your database is hosted at some cloud platform or if you have modified the SQL script file with some different username and password, update the src/main/resources/application.properties file accordingly:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/expensetrackerdb
spring.datasource.username=expensetracker
spring.datasource.password=password
```

**4. Run the spring boot application**

```sh
./mvnw spring-boot:run
```

This runs at port 8080 and hence all enpoints can be accessed from http://localhost:8080.

## License

This project is licensed under the [MIT License](LICENSE). You can view the full license text [here](https://opensource.org/licenses/MIT).
