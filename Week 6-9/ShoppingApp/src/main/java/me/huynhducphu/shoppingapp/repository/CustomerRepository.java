package me.huynhducphu.shoppingapp.repository;

import me.huynhducphu.shoppingapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Admin 10/7/2025
 *
 **/
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByIsActiveTrue();

    Optional<Customer> findByPhoneNumber(String phoneNumber);
}
