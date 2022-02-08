package com.requests.rest_template;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class Example01Service {

    private final RestTemplate restTemplate;
    private final Example01ServiceConfiguration serviceConfiguration;

    public Example01Service(
            RestTemplate restTemplate,
            Example01ServiceConfiguration example01ServiceConfiguration
    ) {
        this.restTemplate = restTemplate;
        this.serviceConfiguration = example01ServiceConfiguration;
    }

    public ResponseEntity<String> doRestRequest() {
        final String apiURL = this.serviceConfiguration.getRandomDataApiUrl();
        final String apiPath = this.serviceConfiguration.getRandomFoodApiPath();
        final URI uri = URI.create(apiURL.concat(apiPath));

        return this.restTemplate.getForEntity(uri, String.class);
    }

}
