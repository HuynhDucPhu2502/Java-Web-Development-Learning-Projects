package me.huynhducphu.shoppingapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.Collectors;

/**
 * Admin 10/23/2025
 *
 **/
@Controller
public class UserController {

    @GetMapping({"/", "/home"})
    public String home(Authentication authentication, Model model) {
        String username = authentication.getName();
        var roles = authentication.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        model.addAttribute("username", username);
        model.addAttribute("roles", roles);
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}