package me.huynhducphu.bai2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Admin 10/31/2025
 **/
@Controller
public class AdminController {

    @GetMapping("/admin")
    public String showAdminPage() {
        return "admin";
    }

}
