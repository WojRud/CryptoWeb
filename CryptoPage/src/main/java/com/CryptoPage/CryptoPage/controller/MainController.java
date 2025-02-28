package com.CryptoPage.CryptoPage.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/register")
    public String register() {
        return "register";
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

    @PostMapping("/register")
    public RedirectView handleRegister(
            @RequestParam String name,
            @RequestParam String lastname,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String confirmPassword,
            @RequestParam(required = false) String referralCode,
            @RequestParam boolean terms) {
        if (name.isEmpty() || lastname.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return new RedirectView("/register?error=emptyFields");
        }
        if (!password.equals(confirmPassword)) {
            return new RedirectView("/register?error=passwordMismatch");
        }
        if (!terms) {
            return new RedirectView("/register?error=termsNotAccepted");
        }
        return new RedirectView("/login");
    }
}