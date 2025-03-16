package com.CryptoPage.CryptoPage.controller;

import com.CryptoPage.CryptoPage.model.User;
import com.CryptoPage.CryptoPage.model.UserRepository;
import com.CryptoPage.CryptoPage.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public RedirectView registerUser(@RequestParam String name,
                                     @RequestParam String lastname,
                                     @RequestParam String email,
                                     @RequestParam String password) {

        System.out.println("Próba rejestracji użytkownika: " + name + " " + lastname);

        User user = new User();
        user.setUserName(name);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setPassword(password);

        userService.registerUser(user);

        return new RedirectView("/login");
    }
}