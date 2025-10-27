package me.huynhducphu.shoppingapp.service;

import me.huynhducphu.shoppingapp.model.Customer;

import java.util.List;

/**
 * Admin 10/7/2025
 *
 **/
public interface CustomerService {
    Customer create(Customer customer);

    Customer getById(Long id);


    List<Customer> getAll(boolean onlyActive);

    Customer update(Long id, Customer request);

    void delete(Long id);
}
