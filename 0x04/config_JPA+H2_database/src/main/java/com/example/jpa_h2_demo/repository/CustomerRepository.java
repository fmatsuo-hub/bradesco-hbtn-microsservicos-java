package com.example.jpa_h2_demo.repository;

import com.example.jpa_h2_demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
