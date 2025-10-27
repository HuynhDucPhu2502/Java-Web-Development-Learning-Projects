package me.huynhducphu.shoppingapp.service;

import me.huynhducphu.shoppingapp.model.Category;

import java.util.List;

/**
 * Admin 10/9/2025
 *
 **/
public interface CategoryService {
    Category create(Category category);

    Category getById(Long id);

    List<Category> getAll();

    Category update(Long id, Category request);

    void delete(Long id);
}
