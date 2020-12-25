package com.example.getcoverageapi.controller;

import com.example.getcoverageapi.entity.Customer;
import com.example.getcoverageapi.exception.BadRequestException;
import com.example.getcoverageapi.exception.NotFoundException;
import com.example.getcoverageapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('booking:read')")
    public Customer findOneCustomer(@PathVariable long id) {
        Customer customer = customerService.findOneCustomer(id);
        if (customer == null) {
            throw new NotFoundException("No such customer with id " + id);
        }
        return customer;
    }


    @GetMapping("/customers/lastname/{lastname}")
    @PreAuthorize("hasAuthority('booking:read')")
    public List<Customer> findAllCustomersByLastname(@PathVariable String lastname) {
        return customerService.findAllByLastname(lastname);
    }


    @PostMapping("/customers")
    @PreAuthorize("hasAuthority('booking:write')")
    public Customer addOneCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }


    @PutMapping("/customers/")
    @PreAuthorize("hasAuthority('booking:write')")
    public Customer updateOneCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }


    @DeleteMapping("/customers/{id}")
    @PreAuthorize("hasAuthority('booking:write')")
    public String deleteOneCustomer(@PathVariable long id) {
        if (customerService.findOneCustomer(id) != null) {
            customerService.deleteCustomer(id);
            return "Customer with id " + id + " was successfully deleted";
        } else throw new NotFoundException("No such customer with id " + id);
    }

}
