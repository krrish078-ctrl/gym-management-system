# Monitoring Documentation

The Gym Management System exposes application metrics through Spring Boot Actuator.

Prometheus collects metrics from the application through the /actuator/prometheus endpoint.

Grafana visualizes the collected metrics through dashboards for application availability, HTTP requests, JVM memory, CPU usage, database connections, and disk space.
