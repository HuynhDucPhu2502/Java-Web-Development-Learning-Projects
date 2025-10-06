package me.huynhducphu.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Admin 10/6/2025
 *
 **/
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "redirect:/employees";
    }
}
