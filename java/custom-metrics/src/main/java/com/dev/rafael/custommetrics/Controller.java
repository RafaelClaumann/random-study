package com.dev.rafael.custommetrics;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Timed
public class Controller {

    @Autowired
    ItemService itemService;

    @GetMapping("/")
    @Timed("api")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/books")
    @Timed("books.api")
    public String orderBook() {
        return itemService.orderBook();
    }

    @GetMapping("/movies")
    @Timed("movies.api")
    public String orderMovie() {
        return itemService.orderMovie();
    }

}
