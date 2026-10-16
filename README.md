# Gym Management System

Gym Management System is a Spring Boot web application (DevOps mini project) that provides a simple gym management backend and frontend using Thymeleaf, MySQL and Spring Data JPA. The repository includes a Dockerfile and a docker-compose setup with MySQL, Prometheus and Grafana for local development and monitoring.

## Languages
- Java (Spring Boot)
- HTML / Thymeleaf
- CSS

## Prerequisites
- Java 17 (JDK)
- Maven 3.6+
- Docker & Docker Compose (if using containers)

## Build and run locally (without Docker)
1. Build the project with Maven:

   mvn clean package

2. Run the produced jar:

   java -jar target/gym-management-system-1.0.0.jar

By default the application listens on port 8080 inside the process defined in the code. Adjust application properties if you need a different port.

## Run with Docker Compose (recommended for dev)
This repository includes a Dockerfile and `docker-compose.yml` to run the application with MySQL, Prometheus and Grafana.

1. Build and start containers:

   docker-compose up --build

2. Services and mapped ports (as configured in docker-compose.yml):
- App: http://localhost:8081 (container port 8080 mapped to host 8081)
- MySQL: 3307 -> 3306 (host: 3307)
- Prometheus: http://localhost:9090
- Grafana: http://localhost:3001

3. MySQL credentials (from docker-compose.yml):
- Database: gymdb
- User: gymuser
- Password: gympassword
- Root password: rootpassword

Notes:
- The `app` service depends on `mysql` and waits for it to become healthy before starting.
- Prometheus configuration is loaded from `prometheus/prometheus.yml` in the repository and Prometheus is set to scrape the app (check the file to confirm targets).

## Dockerfile
The Dockerfile uses Eclipse Temurin JDK 17 and expects the jar to be available at `target/gym-management-system-1.0.0.jar` prior to building the image.

To build the image manually:

  docker build -t gym-management-system:latest .

To run the image:

  docker run -p 8081:8080 --name gym-app gym-management-system:latest

## Monitoring
The project includes Micrometer Prometheus registry and Spring Boot Actuator dependency in `pom.xml`. Expose and configure actuator endpoints (for example `/actuator/prometheus`) through `application.properties` / `application.yml` if you want Prometheus to scrape metrics.

## Tests
Run tests with:

  mvn test

## Contributing
Contributions are welcome — please open issues or pull requests with changes.

## License
Add a license file to the repository (for example `LICENSE`) and update this section with the chosen license.
