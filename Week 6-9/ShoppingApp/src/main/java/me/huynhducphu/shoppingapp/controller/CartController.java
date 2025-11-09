package me.huynhducphu.shoppingapp.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import me.huynhducphu.shoppingapp.dto.CartItem;
import me.huynhducphu.shoppingapp.model.Customer;
import me.huynhducphu.shoppingapp.model.Order;
import me.huynhducphu.shoppingapp.model.OrderLine;
import me.huynhducphu.shoppingapp.model.Product;
import me.huynhducphu.shoppingapp.repository.CustomerRepository;
import me.huynhducphu.shoppingapp.repository.OrderRepository;
import me.huynhducphu.shoppingapp.service.CustomerService;
import me.huynhducphu.shoppingapp.service.OrderService;
import me.huynhducphu.shoppingapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final ProductService productService;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    private static final String CART_KEY = "CART";

    // 🧺 Lấy giỏ hàng từ session
    @SuppressWarnings("unchecked")
    private Map<Long, CartItem> getCart(HttpSession session) {
        Object obj = session.getAttribute(CART_KEY);
        if (obj == null) {
            Map<Long, CartItem> map = new LinkedHashMap<>();
            session.setAttribute(CART_KEY, map);
            return map;
        }
        return (Map<Long, CartItem>) obj;
    }

    // 🛒 Trang hiển thị giỏ hàng
    @GetMapping
    public String viewCart(Model model, HttpSession session) {
        Map<Long, CartItem> cart = getCart(session);
        double total = cart.values().stream().mapToDouble(CartItem::getTotal).sum();

        model.addAttribute("items", cart.values());
        model.addAttribute("total", total);
        return "cart";
    }

    // ➕ Thêm sản phẩm vào giỏ
    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId,
                            @RequestParam(defaultValue = "1") int quantity,
                            HttpSession session) {
        Map<Long, CartItem> cart = getCart(session);
        Product p = productService.getById(productId);

        CartItem item = cart.get(productId);
        if (item == null) {
            item = new CartItem(p.getId(), p.getName(), p.getPrice(), quantity);
            cart.put(productId, item);
        } else {
            item.setQuantity(item.getQuantity() + quantity);
        }
        return "redirect:/cart";
    }

    // 🔄 Cập nhật số lượng
    @PostMapping("/update")
    public String updateQuantity(@RequestParam Long productId,
                                 @RequestParam int quantity,
                                 HttpSession session) {
        Map<Long, CartItem> cart = getCart(session);
        CartItem item = cart.get(productId);
        if (item != null) {
            if (quantity <= 0) cart.remove(productId);
            else item.setQuantity(quantity);
        }
        return "redirect:/cart";
    }

    // ❌ Xóa sản phẩm khỏi giỏ
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, HttpSession session) {
        Map<Long, CartItem> cart = getCart(session);
        cart.remove(id);
        return "redirect:/cart";
    }

    // 🧹 Xóa toàn bộ giỏ hàng
    @GetMapping("/clear")
    public String clear(HttpSession session) {
        session.removeAttribute(CART_KEY);
        return "redirect:/cart";
    }

    // 🔍 Tìm khách hàng theo số điện thoại (cho JS)
    @GetMapping("/customer")
    @ResponseBody
    public Map<String, Object> findCustomer(@RequestParam String phoneNumber) {
        Map<String, Object> res = new HashMap<>();
        var opt = customerRepository.findByPhoneNumber(phoneNumber);
        if (opt.isPresent()) {
            res.put("found", true);
            res.put("name", opt.get().getName());
        } else {
            res.put("found", false);
        }
        return res;
    }

    // ✅ Checkout → tạo Order + OrderLine
    @PostMapping("/checkout")
    public String checkout(@RequestParam String customerName,
                           @RequestParam String customerPhone,
                           HttpSession session,
                           Model model) {

        Map<Long, CartItem> cart = getCart(session);
        if (cart.isEmpty()) {
            model.addAttribute("error", "Giỏ hàng trống!");
            model.addAttribute("items", cart.values());
            model.addAttribute("total", 0);
            return "cart";
        }

        // 🔎 Kiểm tra khách hàng
        Optional<Customer> optCustomer = customerRepository.findByPhoneNumber(customerPhone);
        if (optCustomer.isEmpty()) {
            model.addAttribute("error", "Không tìm thấy khách hàng có số điện thoại này!");
            double total = cart.values().stream().mapToDouble(CartItem::getTotal).sum();
            model.addAttribute("items", cart.values());
            model.addAttribute("total", total);
            return "cart";
        }

        Customer customer = optCustomer.get();

        // 🧾 Tạo đơn hàng mới
        Order order = new Order();
        order.setCustomer(customer);
        order.setDate(LocalDate.now());

        List<OrderLine> lines = new ArrayList<>();

        for (CartItem item : cart.values()) {
            Product product = productService.getById(item.getProductId());

            OrderLine line = new OrderLine();
            line.setOrder(order);
            line.setProduct(product);
            line.setAmount(item.getQuantity());
            line.setPurchasePrice(product.getPrice());

            lines.add(line);
        }

        order.setOrderLines(lines);
        orderRepository.save(order);

        // 🧹 Clear giỏ hàng
        session.removeAttribute(CART_KEY);
        model.addAttribute("success", "Đặt hàng thành công!");
        return "redirect:/shopping";
    }


}
