package me.huynhducphu.huynhducphu_22653551_bai3.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartItemBean {

    private Product product;
    private int quantity;

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }
}
