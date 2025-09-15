package me.huynhducphu.section_4.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import me.huynhducphu.section_4.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Admin 9/14/2025
 *
 **/
@AllArgsConstructor
@Data
public class Cart {

    private List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public void addProduct(Book book) {
        // Kiểm tra item có trong giỏ hàng chưa
        var existedItem = cartItems
                .stream()
                .filter(x -> x.getBook().getId().equals(book.getId()))
                .findFirst()
                .orElse(null);

        if (existedItem != null) {
            // TH: giỏ hàng có item đó
            existedItem.setQuantity(existedItem.getQuantity() + 1);
        } else {
            // TH: giỏ hàng không có item đó
            var cartItem = new CartItem(book, 1);
            cartItems.add(cartItem);
        }
    }

    public void removeProduct(Long productId) {
        cartItems.removeIf(x -> x.getBook().getId().equals(productId));
    }

    // Cập nhật số lượng item torng giỏ hàng
    public void updateItemQuantity(Long productId, int newQuantity) {
        // Kiểm tra item có trong giỏ hàng chưa
        var existedItem = cartItems
                .stream()
                .filter(x -> x.getBook().getId().equals(productId))
                .findFirst()
                .orElse(null);

        // Nếu item có trong giỏ hàng
        if (existedItem != null) {
            if (newQuantity < 0) cartItems.remove(existedItem);
            else existedItem.setQuantity(newQuantity);
        }

    }

    // Tính tổng tiền giỏ hàng
    public double getTotalPrice() {
        return cartItems
                .stream()
                .mapToDouble(x -> x.getSubtotal())
                .sum();
    }

    public void clearItems() {
        cartItems.clear();

    }


}
