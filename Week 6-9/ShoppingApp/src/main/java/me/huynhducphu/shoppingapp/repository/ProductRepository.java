package me.huynhducphu.shoppingapp.repository;

import me.huynhducphu.shoppingapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Admin 10/7/2025
 *
 **/
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByIsActiveTrue();
}
