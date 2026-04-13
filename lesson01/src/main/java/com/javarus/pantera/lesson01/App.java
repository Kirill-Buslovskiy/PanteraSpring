package com.javarus.pantera.lesson01;

import com.javarus.pantera.lesson01.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static final String BASE_PACKAGE = "com.javarus.pantera.lesson01";

    public static void main(String[] args) {
//        ApplicationProperties applicationProperties = new ApplicationProperties();
//        SessionCreator sessionCreator = new SessionCreator(applicationProperties);
//        UserRepository userRepository = new UserRepository(sessionCreator);
//        UserService userService = new UserService(userRepository);
        ApplicationContext context = new AnnotationConfigApplicationContext(BASE_PACKAGE);
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService);
    }
}
