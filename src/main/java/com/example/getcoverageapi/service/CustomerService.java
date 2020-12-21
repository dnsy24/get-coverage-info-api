package com.example.getcoverageapi.service;



import com.example.getcoverageapi.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();

    void saveCustomer(Customer customer);

    Customer findOneCustomer(long id);

    void deleteCustomer(long id);

    List<Customer> findAllByLastname(String lastname);
}
