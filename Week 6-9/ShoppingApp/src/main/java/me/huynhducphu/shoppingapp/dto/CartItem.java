package me.huynhducphu.shoppingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Admin 11/9/2025
 *
 **/
@Data
@AllArgsConstructor
public class CartItem {
    private Long productId;
    private String name;
    private Double price;
    private int quantity;

    public double getTotal() {
        return price * quantity;
    }
}
