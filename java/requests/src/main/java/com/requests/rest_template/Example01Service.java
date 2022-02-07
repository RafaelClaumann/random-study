package com.requests.rest_template;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Example01Service {

    private final RestTemplate restTemplate;

    public Example01Service(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> test() {
        return this.restTemplate.getForEntity("https://random-data-api.com/api/stripe/random_stripe", String.class);
    }

}
