package com.javarush.lesson18;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
public class ApplicationWithCustomSecurity {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationWithCustomSecurity.class, args);
        log.info("Application started http://localhost:8080");
    }
}
