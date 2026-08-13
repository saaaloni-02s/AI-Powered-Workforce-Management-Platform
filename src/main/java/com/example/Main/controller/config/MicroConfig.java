package com.example.Main.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MicroConfig {
    @Bean
    public RestTemplate Input(){
        return new RestTemplate();
    }
}
