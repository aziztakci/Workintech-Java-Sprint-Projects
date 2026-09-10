package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AddressService {
    List<Address> findAll();
    Address findById(long id);
    Address save(Address address);
    Address update(long id, Address address);
    Address delete(long id);
}
