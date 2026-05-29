package com.workintech.s17d2.rest;

import com.workintech.s17d2.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.workintech.s17d2.tax.Taxable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/developers")
public class DeveloperController {


    public Map<Integer, Developer> developers;

    private Taxable taxable;

    @Autowired
    public DeveloperController(Taxable taxable) {
        this.taxable = taxable;
    }

    @PostConstruct
    public void init() {
        this.developers = new HashMap<>();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Developer save(@RequestBody Developer developer) {
        Developer savedDeveloper = null;


        if(developer.getExperience() == Experience.JUNIOR) {
            double salary = developer.getSalary() - (developer.getSalary() * taxable.getSimpleTaxRate() / 100);
            savedDeveloper = new JuniorDeveloper(developer.getId(), developer.getName(), salary);
        } else if(developer.getExperience() == Experience.MID) {
            double salary = developer.getSalary() - (developer.getSalary() * taxable.getMiddleTaxRate() / 100);
            savedDeveloper = new MidDeveloper(developer.getId(), developer.getName(), salary);
        } else if(developer.getExperience() == Experience.SENIOR) {
            double salary = developer.getSalary() - (developer.getSalary() * taxable.getUpperTaxRate() / 100);
            savedDeveloper = new SeniorDeveloper(developer.getId(), developer.getName(), salary);
        }

        if(savedDeveloper != null) {
            developers.put(savedDeveloper.getId(), savedDeveloper);
        }
        return savedDeveloper;
    }

    @GetMapping
    public List<Developer> findAll() {
        return developers.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Developer find(@PathVariable int id) {
        return developers.get(id);
    }

    @PutMapping("/{id}")
    public Developer update(@PathVariable int id, @RequestBody Developer developer) {
        if(!developers.containsKey(id)) {
            return null;
        }
        developer.setId(id);
        developers.put(id, developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public Developer delete(@PathVariable int id) {
        return developers.remove(id);
    }
}
