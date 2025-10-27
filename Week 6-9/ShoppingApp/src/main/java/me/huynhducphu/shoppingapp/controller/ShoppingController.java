package me.huynhducphu.shoppingapp.controller;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.shoppingapp.model.Product;
import me.huynhducphu.shoppingapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Admin 10/23/2025
 *
 **/
@Controller
@RequiredArgsConstructor
@RequestMapping("/shopping")
public class ShoppingController {

    private final ProductService productService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productService.getAll(true));
        return "shopping";
    }

    @GetMapping("/products/{id}")
    public String details(@PathVariable Long id, Model model) {
        Product p = productService.getById(id);
        model.addAttribute("product", p);
        return "shopping-product-details";
    }

}
