package com.requests.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateBeanConfiguration {

    @Bean
    public RestTemplate getRestTemplateBean() {
        return new RestTemplate();
    }

}
