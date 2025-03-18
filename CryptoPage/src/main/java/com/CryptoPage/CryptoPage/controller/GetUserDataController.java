package com.CryptoPage.CryptoPage.controller;

import com.CryptoPage.CryptoPage.model.User;
import com.CryptoPage.CryptoPage.model.UserRepository;
import com.CryptoPage.CryptoPage.model.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

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




/*

@Controller
public class GetUserDataController {

    private final UserRepository userRepository;

    public GetUserDataController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/mainpage")
    public String mainPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof UserDetails userDetails) {
            Optional<User> userOptional = userRepository.findByEmail(userDetails.getUsername());
            userOptional.ifPresent(user -> model.addAttribute("user", user));
        }

        return "mainpage";
    }
}


*/