package com.service1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigurationServ {

//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate(); // Spring Boot should handle converter configuration
//    }
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().forEach(converter ->
                System.out.println("Registered converter: " + converter.getClass().getName())
        );
        return restTemplate;
    }

}

