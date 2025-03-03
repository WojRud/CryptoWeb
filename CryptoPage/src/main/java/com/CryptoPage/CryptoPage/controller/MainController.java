package com.CryptoPage.CryptoPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

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

    @PostMapping("/login")
    public RedirectView handleLogin(
            @RequestParam String username,
            @RequestParam String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return new RedirectView("/login?error=emptyFields");
        }

        return new RedirectView("/welcome");
    }
}