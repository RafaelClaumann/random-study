# Monitor Spring Boot Custom Metrics with Micrometer and Prometheus using Docker

[Monitor Spring Boot Custom Metrics with Micrometer and Prometheus using Docker](https://mehmetozkaya.medium.com/monitor-spring-boot-custom-metrics-with-micrometer-and-prometheus-using-docker-62798123c714)

1 - build java app `mvn clean install`
2 - build docker image `docker build -t demoapp:1.0`
3 - check prometheus config at `prometheus.yml`
4 - start docker-compose `docker-compose up -d`
5 - check spring-boot-actuator exposed endpoints at `resources/application.properties`
6 - view spring metrics at `localhost:8080/actuator/prometheus`
7 - view prometheus metrics at `order_books_total`, `order_movies_total`, `number_of_active_users` at `localhost:9090`
