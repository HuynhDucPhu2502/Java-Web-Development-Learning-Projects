package me.huynhducphu.section_4_remade.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.huynhducphu.section_4_remade.model.Product;

/**
 * Admin 9/23/2025
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartItemBean {

    private Product product;
    private int quantity;

    public double getSubTotal() {
        return product.getPrice() * quantity;
    }


}
