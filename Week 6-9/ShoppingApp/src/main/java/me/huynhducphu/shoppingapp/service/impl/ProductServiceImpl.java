package me.huynhducphu.shoppingapp.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.huynhducphu.shoppingapp.model.Product;
import me.huynhducphu.shoppingapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Admin 10/12/2025
 *
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements me.huynhducphu.shoppingapp.service.ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found: " + id));
    }

    @Override
    public List<Product> getAll(boolean onlyActive) {
        return onlyActive ? productRepository.findByIsActiveTrue()
                : productRepository.findAll();
    }

    @Override
    public Product update(Long id, Product request) {
        Product existing = getById(id);
        existing.setName(request.getName());
        existing.setPrice(request.getPrice());
        existing.setInStock(request.getInStock());
        existing.setIsActive(request.getIsActive());

        if (request.getCategory() != null && request.getCategory().getId() != null) {
            existing.setCategory(request.getCategory());
        } else {
            existing.setCategory(null);
        }

        return productRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Product product = getById(id);
        product.setIsActive(false);
        productRepository.save(product);
    }
}
