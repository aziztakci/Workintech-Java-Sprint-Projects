package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetable")
public class VegetableController {
    private final VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> findAll() {
        return vegetableService.searchByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable findById(@PathVariable("id") Long id) {
        return vegetableService.findById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> findAllDesc() {
        return vegetableService.searchByPriceDesc();
    }

    @PostMapping
    public Vegetable save(@Validated @RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }


    @GetMapping("/name/{name}")
    public List<Vegetable> searchByName(@PathVariable("name") String name) {
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable("id") Long id) {
        return vegetableService.delete(id);
    }
}
