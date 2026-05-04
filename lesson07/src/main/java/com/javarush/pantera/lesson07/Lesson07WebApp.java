package com.javarush.pantera.lesson07;

import com.javarush.pantera.lesson07.entity.User;
import com.javarush.pantera.lesson07.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Slf4j
@SpringBootApplication
public class Lesson07WebApp {

    public static void main(String[] args) {
        var context = SpringApplication.run(Lesson07WebApp.class, args);
        UserService userService = context.getBean(UserService.class);

    }

}
