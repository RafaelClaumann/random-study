package com.requests.rest_template;

import com.requests.rest_template.model.Vehicle;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class Example01Service {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Example01Service.class);
    
    private final RestTemplate restTemplate;
    private final Example01ServiceConfiguration serviceConfiguration;

    public Example01Service(
            RestTemplate restTemplate,
            Example01ServiceConfiguration example01ServiceConfiguration
    ) {
        this.restTemplate = restTemplate;
        this.serviceConfiguration = example01ServiceConfiguration;
    }

    public ResponseEntity<String> doGetForEntity() {
        final String apiURL = this.serviceConfiguration.getRandomDataApiUrl();
        final String apiPath = this.serviceConfiguration.getRandomVehicleApiPath();
        final URI uri = URI.create(apiURL.concat(apiPath));

        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(uri, String.class);
        LOGGER.info("doGetForEntity -> Returning Vehicle Data: {}", responseEntity.getBody());

        return responseEntity;
    }

    public Vehicle doGetForObject() {
        final String apiURL = this.serviceConfiguration.getRandomDataApiUrl();
        final String apiPath = this.serviceConfiguration.getRandomVehicleApiPath();
        final URI uri = URI.create(apiURL.concat(apiPath));

        Vehicle responseVehicle = this.restTemplate.getForObject(uri, Vehicle.class);
        LOGGER.info("doGetForObject -> Returning Vehicle Data: {}", responseVehicle);

        return responseVehicle;
    }

}
