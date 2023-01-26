package com.security.demo;

import com.security.demo.model.Post;
import com.security.demo.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runSomething(final PostRepository postRepository) {
        return args -> {
            postRepository.save(new Post("Hello World", "hello-world", "Welcome to my blog!", "Rafael"));
        };
    }

}
