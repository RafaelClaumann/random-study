package com.requests.rest_template;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "example01.service")
public class Example01ServiceConfiguration {

    private String randomDataApiUrl;
    private String randomFoodApiPath;

    public Example01ServiceConfiguration() { }

    public Example01ServiceConfiguration(String randomDataApiUrl, String randomFoodApiPath) {
        this.randomDataApiUrl = randomDataApiUrl;
        this.randomFoodApiPath = randomFoodApiPath;
    }

    public String getRandomDataApiUrl() {
        return randomDataApiUrl;
    }

    public String getRandomFoodApiPath() {
        return randomFoodApiPath;
    }

    public void setRandomDataApiUrl(String randomDataApiUrl) {
        this.randomDataApiUrl = randomDataApiUrl;
    }

    public void setRandomFoodApiPath(String randomFoodApiPath) {
        this.randomFoodApiPath = randomFoodApiPath;
    }

}
