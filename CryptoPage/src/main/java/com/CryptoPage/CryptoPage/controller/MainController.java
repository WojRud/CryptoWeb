package com.CryptoPage.CryptoPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/login")
    public String handleLogin(String username, String password) {
        return "redirect:/";
    }

    @PostMapping("/register")
    public String handleRegister(String username, String password) {
        return "redirect:/";
    }
}