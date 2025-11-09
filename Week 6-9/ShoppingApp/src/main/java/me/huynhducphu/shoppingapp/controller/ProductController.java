package me.huynhducphu.shoppingapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.huynhducphu.shoppingapp.model.Category;
import me.huynhducphu.shoppingapp.model.Product;
import me.huynhducphu.shoppingapp.service.CategoryService;
import me.huynhducphu.shoppingapp.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Admin 10/12/2025
 *
 **/
@Controller
@RequestMapping("/admin/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    // Tự động đổ categories cho mọi view
    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.getAll();
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String list(@RequestParam(required = false, defaultValue = "true") boolean onlyActive,
                       Model model) {
        model.addAttribute("products", productService.getAll(onlyActive));
        model.addAttribute("onlyActive", onlyActive);
        return "admin/products/list";
    }

    @GetMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "admin/products/form";
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String createProduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            // categories đã được @ModelAttribute cung cấp
            return "admin/products/form";
        }

        productService.create(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "admin/products/form";
    }

    @PostMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateProduct(@PathVariable Long id,
                                @Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "admin/products/form";
        }

        productService.update(id, product);
        return "redirect:/admin/products";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/admin/products";
    }
}
