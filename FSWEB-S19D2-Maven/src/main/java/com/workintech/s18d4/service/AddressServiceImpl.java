package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));
    }

    @Transactional
    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Transactional
    @Override
    public Address update(long id, Address address) {
        Address mevcutAddress = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));

        // 1. Veritabanından gelen mevcudun alanlarını güncelle (null overwrite riski önlendi)
        mevcutAddress.setStreet(address.getStreet());
        mevcutAddress.setCity(address.getCity());
        mevcutAddress.setCountry(address.getCountry());
        mevcutAddress.setNo(address.getNo());
        // Varsa diğer alanlar: zipCode, description vb.

        // 2. Yönetilen (managed) nesneyi kaydet
        return addressRepository.save(mevcutAddress);
    }

    @Transactional
    @Override
    public Address delete(long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));

        addressRepository.delete(address);
        return address;
    }
}