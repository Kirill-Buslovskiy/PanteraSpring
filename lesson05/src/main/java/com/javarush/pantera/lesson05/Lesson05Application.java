package com.javarush.pantera.lesson05;

import com.javarush.pantera.lesson05.config.AppConfig;
import com.javarush.pantera.lesson05.entity.User;
import com.javarush.pantera.lesson05.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lesson05Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Lesson05Application.class, args);
        UserService userService = context.getBean(UserService.class);
        userService.findAll().forEach(System.out::println);
        AppConfig appConfig = context.getBean(AppConfig.class);
        System.out.println(appConfig);
        User admin = userService.findUserBy(3L, "USER");
        System.out.println(admin);
        User userByPassword = userService.findUserByPassword("admin");
        System.out.println(userByPassword);
    }


}
