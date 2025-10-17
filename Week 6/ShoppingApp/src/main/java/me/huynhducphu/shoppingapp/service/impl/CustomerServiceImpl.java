package me.huynhducphu.shoppingapp.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.huynhducphu.shoppingapp.model.Customer;
import me.huynhducphu.shoppingapp.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Admin 10/7/2025
 *
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements me.huynhducphu.shoppingapp.service.CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        customer.setId(null);
        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found: " + id));
    }

    @Override
    public List<Customer> getAll(boolean onlyActive) {
        return onlyActive ? customerRepository.findByIsActiveTrue()
                : customerRepository.findAll();
    }

    @Override
    public Customer update(Long id, Customer request) {
        Customer existing = getById(id);
        existing.setName(request.getName());
        existing.setCustomerSince(request.getCustomerSince());
        return customerRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found: " + id));

        customer.setIsActive(false);

        if (customer.getComments() != null && !customer.getComments().isEmpty()) {
            customer.getComments().clear();
        }

        customerRepository.save(customer);
    }


}
