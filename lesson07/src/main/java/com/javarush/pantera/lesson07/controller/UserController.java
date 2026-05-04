package com.javarush.pantera.lesson07.controller;

import com.javarush.pantera.lesson07.entity.User;
import com.javarush.pantera.lesson07.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
@RequestMapping("/user")
public class UserController {

    private final static List<User> users = new CopyOnWriteArrayList<>() {
        {
            User user = new User(
                    10L, "Test", "test", "USER", List.of());
            this.add(user);
        }
    };

    @GetMapping("/list")
    public String user(Model model) {
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/new")
    public String getNewUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/add{id}")
    public String addNewUser(
            @ModelAttribute("user") User user, //
            @RequestParam("login") String login, //
            Model model) {
        users.add(user);
        return "redirect:/user/list";
    }

}
