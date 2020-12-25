package com.example.getcoverageapi.service;

import com.example.getcoverageapi.dao.CustomerRepository;
import com.example.getcoverageapi.entity.Customer;
import com.example.getcoverageapi.exception.BadRequestException;
import com.example.getcoverageapi.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findOneCustomer(long id) {
        Optional<Customer> optional = customerRepository.findById(id);
        if (!optional.isPresent())
            throw new NotFoundException("Customer with id " + id + " not found");
        return optional.get();
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAllByLastname(String lastname) {
        List<Customer> customerList = customerRepository.findAllByLastname(lastname);
        if (customerList.isEmpty())
            throw new NotFoundException("Customer with lastname " + lastname + " not found");
        return customerList;
    }
}
