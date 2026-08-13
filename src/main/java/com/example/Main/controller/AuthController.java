package com.example.Main.controller;

import org.springframework.ui.Model;
import com.example.Main.entity.User;
import com.example.Main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerPage(){

        return "register";

    }

    @GetMapping("/login")
    public String loginPage(){

        return "login";

    }
    @PostMapping("/register")
    public String register(User user, Model model){

        User savedUser = userService.saveUser(user);

        if(savedUser == null){

            model.addAttribute("error","Username or Email already exists!");

            return "register";

        }

        return "redirect:/login";


    }

}