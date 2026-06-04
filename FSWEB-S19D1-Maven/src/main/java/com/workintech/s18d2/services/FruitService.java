package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {
    Fruit save(Fruit fruit);
    List<Fruit> findAll();
    Fruit getById(Long id);
    Fruit delete(Long id);
    List<Fruit> getByPriceDesc();
    List<Fruit> getByPriceAsc();
    List<Fruit> searchByName (String name);

}
