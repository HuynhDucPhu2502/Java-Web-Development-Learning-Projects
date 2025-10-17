package me.huynhducphu.shoppingapp.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.huynhducphu.shoppingapp.model.Category;
import me.huynhducphu.shoppingapp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Admin 10/9/2025
 *
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements me.huynhducphu.shoppingapp.service.CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        category.setId(null); // Đảm bảo tạo mới
        return categoryRepository.save(category);
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category not found: " + id));
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category update(Long id, Category request) {
        Category existing = getById(id);
        existing.setName(request.getName());
        return categoryRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category not found: " + id));

        if (category.getProducts() != null) {
            category.getProducts().forEach(product -> product.setCategory(null));
        }

        categoryRepository.delete(category);
    }

}
