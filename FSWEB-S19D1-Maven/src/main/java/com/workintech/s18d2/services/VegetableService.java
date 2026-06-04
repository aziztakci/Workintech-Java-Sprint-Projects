package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    Vegetable save(Vegetable vegetable);
    List<Vegetable> findAll();
    Vegetable findById(Long id);
    Vegetable delete(Long id);
    List<Vegetable> searchByPriceDesc();
    List<Vegetable> searchByPriceAsc();
    List<Vegetable> searchByName (String name);
}
