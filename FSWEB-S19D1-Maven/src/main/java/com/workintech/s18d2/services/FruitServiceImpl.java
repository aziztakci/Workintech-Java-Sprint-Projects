package com.workintech.s18d2.services;

import com.workintech.s18d2.repository.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {
    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit getById(Long id) {
        if(id<=0) {
            throw new PlantException("Id cannot be equal or less than 0 :" + id,HttpStatus.BAD_REQUEST);
        }
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if(fruitOptional.isPresent()) {
            return fruitOptional.get();
        } else {
            throw new PlantException("Fruit with id: " + id + " not found!" , HttpStatus.NOT_FOUND);
        }
    }
// --------yukarıdaki formül bu şekilde de yazılabilir.
//@Override
//public Fruit findById(Long id) {
//    if (id < 0) {
//        throw new FruitException("ID cannot be less than zero: " + id, HttpStatus.BAD_REQUEST);
//    }
//
//    return fruitRepository.findById(id)
//            .orElseThrow(() -> new FruitException("Fruit with id: " + id + " not found!", HttpStatus.NOT_FOUND));
//}

    @Override
    public Fruit delete(Long id) {
        Fruit fruit = getById(id);
        fruitRepository.delete(fruit);
        return fruit;
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }
}
