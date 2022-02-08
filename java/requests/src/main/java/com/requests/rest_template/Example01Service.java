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
    private final URI randomVehicleApiURI;

    public Example01Service(
            RestTemplate restTemplate,
            Example01ServiceConfiguration serviceConfiguration
    ) {
        this.restTemplate = restTemplate;
        this.randomVehicleApiURI = URI.create(serviceConfiguration.getRandomDataApiUrl().concat(serviceConfiguration.getRandomVehicleApiPath()));
    }

    public ResponseEntity<String> doGetForEntity() {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(this.randomVehicleApiURI, String.class);
        LOGGER.info("doGetForEntity -> Returning Vehicle Data: {}", responseEntity.getBody());

        return responseEntity;
    }

    public Vehicle doGetForObject() {
        Vehicle responseVehicle = this.restTemplate.getForObject(this.randomVehicleApiURI, Vehicle.class);
        LOGGER.info("doGetForObject -> Returning Vehicle Data: {}", responseVehicle);

        return responseVehicle;
    }

}
