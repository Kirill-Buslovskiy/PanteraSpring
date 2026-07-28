package com.javarush.lesson22;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
public class AUTDemo {
    public static void main(String[] args) {
        SpringApplication.run(AUTDemo.class, args);
        log.info("Application started http://localhost:8080");
    }
}
