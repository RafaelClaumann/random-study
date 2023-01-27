package com.security.demo;

import com.security.demo.model.Post;
import com.security.demo.model.User;
import com.security.demo.repository.PostRepository;
import com.security.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runSomething(
            final PostRepository postRepository,
            final UserRepository userRepository,
            final PasswordEncoder encoder
    ) {
        return args -> {
            postRepository.save(new Post("Hello World", "hello-world", "Welcome to my blog!", "Rafael"));
            userRepository.save(new User("rafael", encoder.encode("123"), "ROLE_USER"));
            userRepository.save(new User("admin", encoder.encode("123"), "ROLE_USER,ROLE_ADMIN"));
        };
    }

}
