package com.CryptoPage.CryptoPage.controller;

import com.CryptoPage.CryptoPage.model.User;
import com.CryptoPage.CryptoPage.model.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GetUserDataController {

    private final UserService userService;

    public GetUserDataController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/mainpage")
    public String mainPage(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {
            model.addAttribute("user", user);
        } else {
            model.addAttribute("user", userService.getLoggedInUser().orElse(null));
        }
        return "mainpage";
    }
}

