package com.workintech.s18d2.services;

import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetableServiceImpl implements VegetableService {

    private final VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable findById(Long id) {
        if (id <= 0) {
            throw new PlantException("Id must be greater than zero: " + id, HttpStatus.BAD_REQUEST);
        }
        return vegetableRepository.findById(id)
                .orElseThrow(() -> new PlantException("Vegetable with id " + id + " not found!", HttpStatus.NOT_FOUND));
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable vegetable = findById(id);
        vegetableRepository.delete(vegetable);
        return vegetable;
    }

    @Override
    public List<Vegetable> searchByPriceDesc() {
        return vegetableRepository.searchByPriceDesc();
    }

    @Override
    public List<Vegetable> searchByPriceAsc() {
        return vegetableRepository.searchByPriceAsc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }
}
