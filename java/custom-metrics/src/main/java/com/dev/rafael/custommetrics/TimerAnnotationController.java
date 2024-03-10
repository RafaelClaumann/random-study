package com.dev.rafael.custommetrics;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Timed(value = "index.controller")
public class TimerAnnotationController {

    @Autowired
    ItemService itemService;

    @GetMapping("/")
    @Timed(value = "index.api")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/books")
    @Timed(value = "books.api")
    public String orderBook() {
        return itemService.orderBook();
    }

    @GetMapping("/movies")
    @Timed(value = "movies.api")
    public String orderMovie() {
        return itemService.orderMovie();
    }

}
