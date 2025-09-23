package me.huynhducphu.midterm3.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.huynhducphu.midterm3.model.Product;

/**
 * Admin 9/23/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartItem {

    private Product product;
    private int quantity;

    public double getSubTotal() {
        return product.getPrice() * quantity;
    }

}
