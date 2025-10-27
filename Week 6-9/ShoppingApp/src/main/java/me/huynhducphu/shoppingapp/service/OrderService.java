package me.huynhducphu.shoppingapp.service;

import me.huynhducphu.shoppingapp.model.Order;

import java.util.List;

/**
 * Admin 10/12/2025
 *
 **/
public interface OrderService {
    List<Order> getAll();

    Order getById(Long id);
}
