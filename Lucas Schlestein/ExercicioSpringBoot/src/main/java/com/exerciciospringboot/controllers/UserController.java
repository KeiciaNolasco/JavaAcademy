package com.exerciciospringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/new")
    public String showForm() {
        return "new";
    }

    @PostMapping("/user")
    public String submitForm(@RequestParam(name="name", required=false) String name, Model model) {
        if (name == null || name.isEmpty()) {
            return "error";
        }
        model.addAttribute("name", name);
        return "user";
    }

}