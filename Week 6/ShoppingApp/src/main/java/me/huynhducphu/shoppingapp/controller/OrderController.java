package me.huynhducphu.shoppingapp.controller;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.shoppingapp.model.Order;
import me.huynhducphu.shoppingapp.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Admin 10/12/2025
 *
 **/
@Controller
@RequestMapping("/admin/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("orders", orderService.getAll());
        return "/admin/orders/list";
    }

    @GetMapping("/{id}")
    public String viewDetails(@PathVariable Long id, Model model) {
        Order order = orderService.getById(id);

        double total = order.getOrderLines()
                .stream()
                .mapToDouble(line -> line.getAmount() * line.getPurchasePrice())
                .sum();

        model.addAttribute("order", order);
        model.addAttribute("total", total);
        return "/admin/orders/details";
    }

}
