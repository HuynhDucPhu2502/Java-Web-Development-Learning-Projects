package me.huynhducphu.huynhducphu_22653551_bai3.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartBean {

    private final List<CartItemBean> items;

    public CartBean() {
        this.items = new ArrayList<>();
    }

    public List<CartItemBean> getItems() {
        return items;
    }

    public void addProduct(Product product) {
        var existedItem = items
                .stream()
                .filter(item -> Objects.equals(item.getProduct().getId(), product.getId()))
                .findFirst()
                .orElse(null);

        if (existedItem != null) {
            existedItem.setQuantity(existedItem.getQuantity() + 1);
        } else {
            var item = new CartItemBean(product, 1);
            items.add(item);
        }
    }

    public void removeProduct(Long productId) {
        items.removeIf(item -> Objects.equals(item.getProduct().getId(), productId));
    }

    public void updateQuantity(Long productId, int quantity) {
        var existedItem = items
                .stream()
                .filter(item -> Objects.equals(item.getProduct().getId(), productId))
                .findFirst()
                .orElse(null);

        if (existedItem != null) {
            if (quantity < 0) items.remove(existedItem);
            else existedItem.setQuantity(quantity);
        }
    }

    public double getTotalPrice() {
        return items
                .stream()
                .mapToDouble(item -> item.getProduct().getPrice()).sum();
    }

    public void clear() {
        items.clear();
    }


}
