package com.security.demo;

import com.security.demo.model.Post;
import com.security.demo.model.User;
import com.security.demo.repository.PostRepository;
import com.security.demo.repository.UserRepository;
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
    CommandLineRunner runSomething(final PostRepository postRepository, final UserRepository userRepository) {
        return args -> {
            postRepository.save(new Post("Hello World", "hello-world", "Welcome to my blog!", "Rafael"));
            userRepository.save(new User("rafael", "123", "ROLE_USER"));
            userRepository.save(new User("admin", "123", "ROLE_USER,ROLE_ADMIN"));
        };
    }

}
