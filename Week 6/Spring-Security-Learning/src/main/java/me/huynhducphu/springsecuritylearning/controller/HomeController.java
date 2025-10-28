package me.huynhducphu.springsecuritylearning.controller;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.springsecuritylearning.service.ProjectService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.Collectors;

/**
 * Admin 10/27/2025
 **/
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProjectService projectService;

    @GetMapping("/")
    public String root() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model, Authentication authentication) {
        // welcome
        String role = authentication
                .getAuthorities()
                .stream()
                .map(x -> x.getAuthority().toString())
                .collect(Collectors.joining(","));

        model.addAttribute("name", authentication.getName());
        model.addAttribute("role", role);

        // project table
        model.addAttribute("projects", projectService.findAll());


        return "home-page";
    }

}
