package com.requests.rest_template;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exemplo-01")
public class Example01Controller {

    private final Example01Service example01Service;

    public Example01Controller(Example01Service example01Service) {
        this.example01Service = example01Service;
    }

    @GetMapping
    public ResponseEntity<String> callService() {
        ResponseEntity<String> response = this.example01Service.doRestRequest();
        return response;
    }
}
