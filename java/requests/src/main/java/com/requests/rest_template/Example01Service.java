package com.requests.rest_template;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Example01Service {

    RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> test() {
        ResponseEntity<String> forEntity = this.restTemplate.getForEntity("https://random-data-api.com/api/stripe/random_stripe", String.class);
        return forEntity;
    }
}
