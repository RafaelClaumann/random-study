package com.requests.rest_template;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "example01.service")
public class Example01ServiceConfiguration {

    private String randomDataApiUrl;
    private String randomVehicleApiPath;

    public Example01ServiceConfiguration() { }

    public Example01ServiceConfiguration(String randomDataApiUrl, String randomVehicleApiPath) {
        this.randomDataApiUrl = randomDataApiUrl;
        this.randomVehicleApiPath = randomVehicleApiPath;
    }

    public String getRandomDataApiUrl() {
        return randomDataApiUrl;
    }

    public String getRandomVehicleApiPath() {
        return randomVehicleApiPath;
    }

    public void setRandomDataApiUrl(String randomDataApiUrl) {
        this.randomDataApiUrl = randomDataApiUrl;
    }

    public void setRandomVehicleApiPath(String randomVehicleApiPath) {
        this.randomVehicleApiPath = randomVehicleApiPath;
    }

}
