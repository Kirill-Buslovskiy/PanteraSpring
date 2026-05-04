package com.javarush.pantera.lesson07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

    @RequestMapping("/")
    public String home() {
        return "redirect:/user/list";
    }
}
