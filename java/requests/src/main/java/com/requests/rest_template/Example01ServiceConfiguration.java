package com.requests.rest_template;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "example01.service")
public class Example01ServiceConfiguration {

    private String randomDataApiUrl;
    private String randomDataApiPath;

    public Example01ServiceConfiguration() { }

    public Example01ServiceConfiguration(String randomDataApiUrl, String randomDataApiPath) {
        this.randomDataApiUrl = randomDataApiUrl;
        this.randomDataApiPath = randomDataApiPath;
    }

    public String getRandomDataApiUrl() {
        return randomDataApiUrl;
    }

    public String getRandomDataApiPath() {
        return randomDataApiPath;
    }

    public void setRandomDataApiUrl(String randomDataApiUrl) {
        this.randomDataApiUrl = randomDataApiUrl;
    }

    public void setRandomDataApiPath(String randomDataApiPath) {
        this.randomDataApiPath = randomDataApiPath;
    }

}
