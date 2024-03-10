# Monitor Spring Boot Custom Metrics with Micrometer and Prometheus using Docker

[Monitor Spring Boot Custom Metrics with Micrometer and Prometheus using Docker](https://mehmetozkaya.medium.com/monitor-spring-boot-custom-metrics-with-micrometer-and-prometheus-using-docker-62798123c714)

[Monitoring Made Easy: Measure API Response Time in Your Spring Boot App](https://bootcamptoprod.com/measure-api-response-time-spring-boot)

- build java app `mvn clean install`
- build docker image `docker build -t demoapp:1.0`
- check prometheus config at `prometheus-settings.yml`
- start docker-compose `docker-compose up -d`
- check spring-boot-actuator exposed endpoints at `resources/application.properties`
- view spring metrics at `localhost:8080/actuator/prometheus` or `http://localhost:8080/actuator/metrics`
- view books api(@Timed) metrics `http://localhost:8080/actuator/metrics/books.api`
- view movies api(@Timed) metrics `http://localhost:8080/actuator/metrics/movies.api`
- view index api(@Timed) metrics `http://localhost:8080/actuator/metrics/index.api`
- - view index controller(@Timed) metrics `http://localhost:8080/actuator/metrics/index.controller`
- view prometheus metrics `order_books_total`, `order_movies_total`, `number_of_active_users` at `localhost:9090`

O método `scheduledActiveUsersGenerator` foi criado para alterar a quantidade de usuários ativos e facilitar a visualização da métrica `number_of_active_users` de forma gráfica no prometheus.
```java
// com.dev.rafael.custommetrics.ItemService.scheduledActiveUsersGenerator
@Component
public class ItemService {

    private final AtomicInteger activeUsers;

    public ItemService(CompositeMeterRegistry meterRegistry) {
        activeUsers = meterRegistry.gauge("number.of.active.users", new AtomicInteger(0));
    }

    @Scheduled(fixedRate = 5000)
    public void scheduledActiveUsersGenerator() {
        int upperBound = 2000000;
        activeUsers.set(new Random().nextInt(upperBound));
    }
}
```
![image](https://github.com/RafaelClaumann/random-study/assets/25152862/4a6ce754-165b-41f8-9447-2ea6d09ccb9e)
