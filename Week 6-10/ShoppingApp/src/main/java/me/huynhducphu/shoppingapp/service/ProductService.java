package me.huynhducphu.shoppingapp.service;

import me.huynhducphu.shoppingapp.model.Product;

import java.util.List;

/**
 * Admin 10/12/2025
 *
 **/
public interface ProductService {
    Product create(Product product);

    Product getById(Long id);


    List<Product> getAll(boolean onlyActive);

    Product update(Long id, Product request);

    void delete(Long id);
}
