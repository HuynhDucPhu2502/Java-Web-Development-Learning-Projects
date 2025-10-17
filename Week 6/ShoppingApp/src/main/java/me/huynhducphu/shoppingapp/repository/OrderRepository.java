package me.huynhducphu.shoppingapp.repository;

import me.huynhducphu.shoppingapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Admin 10/7/2025
 *
 **/
public interface OrderRepository extends JpaRepository<Order, Long> {
}
