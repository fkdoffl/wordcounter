# Word Counter Application

This is a simple web application that counts and stores translated words using an external translation service.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup](#setup)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Word Counting:** Counts and stores translated words.
- **Translation:** Utilizes an external translation service to translate words.

## Technologies Used

- Spring Boot
- Google Cloud Translation API
- Java
- Maven
- Swagger

## Setup

1. **Clone the repository:**

    ```bash
    git clone https://github.com/fkdoffl/wordcounter.git
    cd wordcounter
    ```

2. **Build the project:**

    ```bash
    mvn clean install
    ```

3. **Run the application:**

    ```bash
    java -jar target/wordcounter.jar
    ```

## Usage

1. Access the application at `http://localhost:8080`.
2. Use the provided API to add and retrieve word counts.

## API Documentation

The API documentation is available at `http://localhost:8080/swagger-ui.html`.

## Contributing

Feel free to contribute by [opening an issue](https://github.com/fkdoffl/wordcounter/issues) or submitting a pull request.

