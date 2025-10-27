package me.huynhducphu.shoppingapp.controller;

import lombok.RequiredArgsConstructor;
import me.huynhducphu.shoppingapp.model.*;
import me.huynhducphu.shoppingapp.service.CustomerService;
import me.huynhducphu.shoppingapp.service.ProductService;
import me.huynhducphu.shoppingapp.repository.OrderRepository;
import me.huynhducphu.shoppingapp.repository.OrderLineRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * Admin 10/12/2025
 *
 **/
@Controller
@RequestMapping("/admin/sales")
@RequiredArgsConstructor
public class SalesController {

    private final ProductService productService;
    private final CustomerService customerService;
    private final OrderRepository orderRepository;
    private final OrderLineRepository orderLineRepository;

    // Trang bán hàng
    @GetMapping
    public String showSalesPage(Model model) {

        var products = productService
                .getAll(true)
                .stream().filter(x -> x.getInStock() == true)
                .toList();

        model.addAttribute("products", products);
        model.addAttribute("cart", new ArrayList<OrderLine>());
        model.addAttribute("customer", new Customer());
        return "/admin/sales/sales";
    }

    // Xử lý đặt hàng
    @PostMapping("/checkout")
    public String checkout(
            @RequestParam String phoneNumber,
            @RequestParam List<Long> productIds,
            @RequestParam List<Integer> quantities,
            Model model) {

        // Kiểm tra khách hàng tồn tại
        Optional<Customer> optionalCustomer = customerService.getAll(false)
                .stream()
                .filter(c -> c.getPhoneNumber().equals(phoneNumber) && c.getIsActive())
                .findFirst();

        if (optionalCustomer.isEmpty()) {
            model.addAttribute("error", "Customer not found or inactive!");
            model.addAttribute("products", productService.getAll(true));
            return "/admin/sales/sales";
        }

        Customer customer = optionalCustomer.get();

        if (productIds == null || productIds.isEmpty()) {
            model.addAttribute("error", "Cart cannot be empty!");
            model.addAttribute("products", productService.getAll(true));
            return "/admin/sales/sales";
        }

        // Tạo đơn hàng
        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setCustomer(customer);
        order = orderRepository.save(order);

        // Tạo các dòng hàng
        for (int i = 0; i < productIds.size(); i++) {
            Product p = productService.getById(productIds.get(i));
            OrderLine line = new OrderLine();
            line.setOrder(order);
            line.setProduct(p);
            line.setAmount(quantities.get(i));
            line.setPurchasePrice(p.getPrice());
            orderLineRepository.save(line);
        }

        return "redirect:/admin/orders";
    }

    @ResponseBody
    @GetMapping("/customer")
    public Map<String, Object> getCustomerByPhone(@RequestParam String phoneNumber) {
        Map<String, Object> result = new HashMap<>();
        customerService.getAll(false)
                .stream()
                .filter(c -> c.getPhoneNumber().equals(phoneNumber) && c.getIsActive())
                .findFirst()
                .ifPresentOrElse(
                        c -> {
                            result.put("found", true);
                            result.put("name", c.getName());
                        },
                        () -> result.put("found", false)
                );
        return result;
    }
}