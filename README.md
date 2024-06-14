# Search Service Spring

The Search Service Spring is a core component of InnoTech's suite of microservices, facilitating complex search functionality across applications. This service is implemented using Spring Boot and is responsible for building dynamic search queries based on input parameters.

## Features

- **Dynamic Query Building:** Converts a flat map of parameters into a structured JSON query, which can be used with various search engines.
- **JSON Processing:** Utilizes Jackson's ObjectMapper to serialize map data into JSON format, ensuring compatibility and ease of use with downstream services.

## Prerequisites

Before you can run this service, you need to have the following installed:

- Java 18 or later
- Spring Boot 3.3.0 or later

## Installation

Clone the repository and navigate to the project directory:

```bash
git clone https://github.com/inno-tech-labs/spring-search-demo.git
cd spring-search-demo
```

Build the project using Maven:
```bash
 ./gradlew clean build
```

## Running the Service
To start the service locally, execute the following command:

```bash
 ./gradlew bootRun
```

## License
This project is licensed under the MIT License - see the LICENSE.md file for details.
