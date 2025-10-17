package me.huynhducphu.shoppingapp.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.huynhducphu.shoppingapp.model.Order;
import me.huynhducphu.shoppingapp.repository.OrderRepository;
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
public class OrderServiceImpl implements me.huynhducphu.shoppingapp.service.OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Order not found: " + id));
    }
}
