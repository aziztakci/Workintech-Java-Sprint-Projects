package com.workintech.s18d4.controller;


import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerResponse> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerResponse findById(@PathVariable long id) {
        return customerService.findById(id);
    }

    @PostMapping
    public CustomerResponse save(@RequestBody Customer customer)  {
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public CustomerResponse update(@PathVariable long id, @RequestBody Customer customer) {
        return customerService.update(id,customer);
    }

    @DeleteMapping("/{id}")
    public CustomerResponse delete(@PathVariable long id) {
        return customerService.delete(id);
    }

}
