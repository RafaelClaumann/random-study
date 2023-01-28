package com.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String home() {
        return "Hello World";
    }

    @GetMapping("/user")
    public String user(Authentication authentication) {
        return "Welcome " + authentication.getName();
    }

    @GetMapping("/admin")
    public String admin(Authentication authentication) {
        return "Welcome " + authentication.getName();
    }

}
