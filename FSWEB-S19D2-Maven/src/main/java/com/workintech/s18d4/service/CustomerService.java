package com.workintech.s18d4.service;

import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    List<CustomerResponse> findAll();
    CustomerResponse findById(long id);
    CustomerResponse save(Customer customer);
    CustomerResponse update(long id,Customer customer);
    CustomerResponse delete(long id);
}
