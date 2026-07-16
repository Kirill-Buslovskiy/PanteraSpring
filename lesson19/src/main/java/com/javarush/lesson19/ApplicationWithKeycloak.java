package com.javarush.lesson19;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
@EnableDiscoveryClient
public class ApplicationWithKeycloak {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationWithKeycloak.class, args);
        log.info("Application started http://localhost:8080");
    }
}
