package com.example.getcoverageapi.dao;

import com.example.getcoverageapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByLastname(String lastname);

}
