package com.javarus.pantera.lesson01;

import com.javarus.pantera.lesson01.config.ApplicationProperties;
import com.javarus.pantera.lesson01.config.SessionCreator;
import com.javarus.pantera.lesson01.repository.UserRepository;
import com.javarus.pantera.lesson01.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
//        ApplicationProperties applicationProperties = new ApplicationProperties();
//        SessionCreator sessionCreator = new SessionCreator(applicationProperties);
//        UserRepository userRepository = new UserRepository(sessionCreator);
//        UserService userService = new UserService(userRepository);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-ctx.xml");
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService);
    }
}
