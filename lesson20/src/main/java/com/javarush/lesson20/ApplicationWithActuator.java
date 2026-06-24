package com.javarush.lesson20;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
public class ApplicationWithActuator {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationWithActuator.class, args);
        log.info("Application started http://localhost:8080");
    }
}
