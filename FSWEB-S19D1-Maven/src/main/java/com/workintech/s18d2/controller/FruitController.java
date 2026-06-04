package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    private final FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> findAll() {
        // [GET] /fruits => Fiyata göre artan sırada (Default davranış)
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit getById(@PathVariable("id") Long id) {
        // [GET] /fruits/{id}
        return fruitService.getById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> findAllDesc() {
        // [GET] /fruits/desc => Fiyata göre azalan sırada
        return fruitService.getByPriceDesc();
    }

    @PostMapping
    public Fruit save(@Validated @RequestBody Fruit fruit) {
        // [POST] /fruits => Save or Update
        return fruitService.save(fruit);
    }

    @GetMapping("/name/{name}")
    public List<Fruit> searchByName(@PathVariable("name") String name) {
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable("id") Long id) {
        // [DELETE] /fruits/{id}
        return fruitService.delete(id);
    }
}