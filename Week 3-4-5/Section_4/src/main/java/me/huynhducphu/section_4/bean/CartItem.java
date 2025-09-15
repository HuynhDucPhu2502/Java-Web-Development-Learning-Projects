package me.huynhducphu.section_4.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.huynhducphu.section_4.model.Book;

/**
 * Admin 9/14/2025
 *
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartItem {

    private Book book;
    private int quantity;

    public double getSubtotal() {
        return book.getPrice() * quantity;
    }


}
