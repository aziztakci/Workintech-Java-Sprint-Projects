package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals;

    @PostConstruct
    public void loadAll() {
        System.out.println("------proje çalıştırıldı------");
        this.animals = new HashMap<>();
        this.animals.put(1,new Animal(0, "Lion"));
    }

    @GetMapping
    public List<Animal> getAnimals() {
        System.out.println("********* animals get method ********");

        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable Integer id) {
        if(id<0 || id == null) {
            return null;
        }
        return animals.get(id);
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
    }

    @PutMapping("{id}")
    public Animal updateAnimal(@PathVariable Integer id,@RequestBody Animal newAnimal) {
        animals.replace(id,newAnimal);
        return animals.get(id);
    }

    @DeleteMapping("{id}")
    public void deleteAnimal(@PathVariable Integer id) {
        animals.remove(id);
    }



}
