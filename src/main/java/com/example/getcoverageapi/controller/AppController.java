package com.example.getcoverageapi.controller;

import com.example.getcoverageapi.entity.Customer;
import com.example.getcoverageapi.exception.NotFoundException;
import com.example.getcoverageapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> findAllCustomers() {
        return customerService.findAllCustomers();
    }


    @GetMapping("/customers/{id}")
    public Customer findOneCustomer(@PathVariable long id) {
        Customer customer = customerService.findOneCustomer(id);
        if (customer == null) {
            throw new NotFoundException("No such customer with id " + id);
        }
        return customer;
    }


    @GetMapping("/customers/lastname/{lastname}")
    public List<Customer> findAllCustomersByLastname(@PathVariable String lastname) {
        return customerService.findAllByLastname(lastname);
    }


    @PostMapping("/customers")
    public Customer addOneCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }


    @PutMapping("/customers/")
    public Customer updateOneCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }


    @DeleteMapping("/customers/{id}")
    public String deleteOneCustomer(@PathVariable long id) {
        if (customerService.findOneCustomer(id) != null) {
            customerService.deleteCustomer(id);
            return "Customer with id " + id + " was successfully deleted";
        } else throw new NotFoundException("No such customer with id " + id);
    }

}
