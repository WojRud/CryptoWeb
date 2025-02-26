package com.CryptoPage.CryptoPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public RedirectView processRegistration(
            @RequestParam String name,
            @RequestParam String lastname,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String confirmPassword,
            @RequestParam(required = false) String referralCode,
            @RequestParam boolean terms) {

        if (!password.equals(confirmPassword)) {
            return new RedirectView("/register?error=passwordMismatch");
        }

        return new RedirectView("/login");
    }
}