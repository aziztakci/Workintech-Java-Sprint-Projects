package com.workintech.s18d4.service;

import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerResponse> findAll() {
        return customerRepository.findAll().stream()
                .map(customer -> new CustomerResponse(customer.getId(), customer.getFirstName(), customer.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponse findById(long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        return new CustomerResponse(customer.getId(), customer.getFirstName(), customer.getLastName());
    }

    @Transactional
    @Override
    public CustomerResponse save(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return new CustomerResponse(savedCustomer.getId(), savedCustomer.getFirstName(), savedCustomer.getLastName());
    }

    @Transactional
    @Override
    public CustomerResponse update(long id, Customer customer) {
        Customer mevcutCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        // 1. Managed Entity alanlarını güncelle
        mevcutCustomer.setFirstName(customer.getFirstName());
        mevcutCustomer.setLastName(customer.getLastName());
        mevcutCustomer.setEmail(customer.getEmail());
        mevcutCustomer.setSalary(customer.getSalary());

        // 2. Güncellenen yönetilen nesneyi kaydet
        Customer updatedCustomer = customerRepository.save(mevcutCustomer);

        return new CustomerResponse(updatedCustomer.getId(), updatedCustomer.getFirstName(), updatedCustomer.getLastName());
    }

    @Transactional
    @Override
    public CustomerResponse delete(long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        customerRepository.delete(customer);
        return new CustomerResponse(customer.getId(), customer.getFirstName(), customer.getLastName());
    }
}