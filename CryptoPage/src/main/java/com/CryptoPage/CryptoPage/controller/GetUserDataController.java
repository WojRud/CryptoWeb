package com.CryptoPage.CryptoPage.controller;

import com.CryptoPage.CryptoPage.model.User;
import com.CryptoPage.CryptoPage.model.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

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
