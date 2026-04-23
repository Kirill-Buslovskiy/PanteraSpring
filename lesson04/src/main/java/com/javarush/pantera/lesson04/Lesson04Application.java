package com.javarush.pantera.lesson04;

import com.javarush.pantera.lesson04.entity.User;
import com.javarush.pantera.lesson04.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Lesson04Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Lesson04Application.class, args);
		UserService userService = context.getBean(UserService.class);
		List<User> users = List.of(
				User.builder().id(1L).name("admin").email("ok@gmail.com").password("qwertysdfsdf").build(),
				User.builder().id(2L).name("ok").email("ok@gmail.com").password("1fsdfsdfsd").build(),
				User.builder().id(3L).name("superman").email("okokokokok@gmail.com").password("adasfsdfsdfsdf").build(),
				User.builder().id(4L).name("guest").email("okerwer@gmail.com").password("wqw88erty").build()
		);
		userService.saveAll(users);
		User user = userService.getById(3L);
		System.out.println(user);
	}

}
