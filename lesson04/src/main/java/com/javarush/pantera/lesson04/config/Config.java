package com.javarush.pantera.lesson04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public SessionCreator getSessionCreator(ApplicationProperties applicationProperties) {
        return new SessionCreator(applicationProperties);
    }


}
