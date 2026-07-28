package com.javarush.khmelov.lesson23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Lesson23Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson23Application.class, args);
    }

}
