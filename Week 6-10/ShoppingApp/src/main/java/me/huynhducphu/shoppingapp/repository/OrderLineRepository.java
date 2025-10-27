package me.huynhducphu.shoppingapp.repository;

import me.huynhducphu.shoppingapp.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Admin 10/7/2025
 *
 **/
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
