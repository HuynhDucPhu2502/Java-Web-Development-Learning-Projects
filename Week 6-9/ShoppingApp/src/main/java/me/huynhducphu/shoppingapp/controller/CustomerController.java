package me.huynhducphu.shoppingapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.huynhducphu.shoppingapp.model.Customer;
import me.huynhducphu.shoppingapp.service.CustomerService;
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
@RequestMapping("/admin/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String list(@RequestParam(required = false, defaultValue = "true") boolean onlyActive,
                       Model model) {
        model.addAttribute("customers", customerService.getAll(onlyActive));
        model.addAttribute("onlyActive", onlyActive);
        return "admin/customers/list";
    }

    @GetMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "admin/customers/form";
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String createCustomer(@Valid @ModelAttribute("customer") Customer customer,
                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "admin/customers/form";
        }

        customerService.create(customer);
        return "redirect:/admin/customers";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.getById(id));
        return "admin/customers/form";
    }

    @PostMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateCustomer(@PathVariable Long id,
                                 @Valid @ModelAttribute("customer") Customer customer,
                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "admin/customers/form";
        }

        customerService.update(id, customer);
        return "redirect:/admin/customers";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
        return "redirect:/admin/customers";
    }
}
