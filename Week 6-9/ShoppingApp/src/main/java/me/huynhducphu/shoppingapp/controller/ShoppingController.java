package me.huynhducphu.shoppingapp.controller;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.shoppingapp.model.Comment;
import me.huynhducphu.shoppingapp.model.Product;
import me.huynhducphu.shoppingapp.service.CommentService;
import me.huynhducphu.shoppingapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Admin 10/23/2025
 *
 **/
@Controller
@RequiredArgsConstructor
@RequestMapping("/shopping")
public class ShoppingController {

    private final ProductService productService;
    private final CommentService commentService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productService.getAll(true));
        return "shopping";
    }

    @GetMapping("/products/{id}")
    public String details(@PathVariable Long id, Model model) {
        Product p = productService.getById(id);
        model.addAttribute("product", p);
        model.addAttribute("comments", commentService.getByProductId(id));
        return "shopping-product-details";
    }

    @PostMapping("/products/{id}/comments")
    public String addComment(@PathVariable Long id,
                             @RequestParam("text") String text) {
        Product product = productService.getById(id);

        Comment c = new Comment();
        c.setText(text);
        c.setProduct(product);

        commentService.create(c);

        return "redirect:/shopping/products/" + id;
    }
}
