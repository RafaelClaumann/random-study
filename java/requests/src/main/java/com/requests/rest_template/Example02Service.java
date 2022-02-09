package com.requests.rest_template;

import com.requests.rest_template.model.Vehicle;
import org.slf4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class Example02Service {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Example02Service.class);
    private static final URI LOCALHOST_EXAMPLE02 = URI.create("http://localhost:8080/example02");

    private final RestTemplate restTemplate;

    public Example02Service(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void doPostForObjectEmptyBodyLocalhost() {
        final MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        final HttpEntity<Vehicle> request = new HttpEntity<>(Vehicle.builder().build(), headers);

        final Vehicle responseVehicle =
                this.restTemplate.postForObject(
                        Example02Service.LOCALHOST_EXAMPLE02,
                        request,
                        Vehicle.class
                );

        LOGGER.info("doPostForObjectEmptyBodyLocalhost -> POST Vehicle Data: {}", responseVehicle);
    }

    public void doPostForEntityEmptyBodyLocalhost() {
        final MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        final HttpEntity<Vehicle> request = new HttpEntity<>(Vehicle.builder().build(), headers);

        final ResponseEntity<Vehicle> responseVehicle =
                this.restTemplate.exchange(
                        Example02Service.LOCALHOST_EXAMPLE02,
                        HttpMethod.POST,
                        request,
                        Vehicle.class
                );

        LOGGER.info("doPostForEntityEmptyBodyLocalhost -> Response Headers: {}", responseVehicle.getHeaders());
        LOGGER.info("doPostForEntityEmptyBodyLocalhost -> Response StatusCode: {}", responseVehicle.getStatusCode());
        LOGGER.info("doPostForEntityEmptyBodyLocalhost -> POST Vehicle Data: {}", responseVehicle);
    }

}
