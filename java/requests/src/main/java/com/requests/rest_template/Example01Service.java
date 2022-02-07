package com.requests.rest_template;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
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
        final String apiPath = this.serviceConfiguration.getRandomDataApiPath();

        URI uri = URI.create(apiURL.concat(apiPath));
        return this.restTemplate.getForEntity(uri, String.class);
    }

}
