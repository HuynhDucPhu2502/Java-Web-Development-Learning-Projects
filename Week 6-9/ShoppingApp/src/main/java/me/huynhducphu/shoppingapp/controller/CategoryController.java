package me.huynhducphu.shoppingapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.huynhducphu.shoppingapp.model.Category;
import me.huynhducphu.shoppingapp.service.CategoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Admin 10/9/2025
 *
 **/
@Controller
@RequestMapping("/admin/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "admin/categories/list";
    }

    @GetMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "admin/categories/form";
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String createCategory(@Valid @ModelAttribute("category") Category category,
                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "admin/categories/form";
        }

        categoryService.create(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.getById(id));
        return "admin/categories/form";
    }

    @PostMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateCategory(@PathVariable Long id,
                                 @Valid @ModelAttribute("category") Category category,
                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "admin/categories/form";
        }

        categoryService.update(id, category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return "redirect:/admin/categories";
    }

}
