package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {
    private Map<Integer, Koala> koalas;

    @PostConstruct
    public void init(){
        koalas= new HashMap<>();
        //koalas.put(1, new Koala(1,"KellyKoala", 10.5, 9.0, "Male" ));
    }

    @GetMapping
    public List<Koala> getAllKoalas() {
        return koalas.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Koala getKoalaById(@PathVariable int id) {
        if(id <= 0) {
            throw new ZooException("Id must be greater than 0", HttpStatus.BAD_REQUEST);
        }
        if(!koalas.containsKey(id)) {
            throw new ZooException("Koalas with given id is not exist: " + id, HttpStatus.NOT_FOUND);
        }
        return koalas.get(id);
    }

    @PostMapping
    public Koala saveKoala(@RequestBody Koala koala){
        if(koala.getId() <= 0) {
            throw new ZooException("Id must be greater than 0", HttpStatus.BAD_REQUEST);
        }
        if(koalas.containsKey(koala.getId())) {
            throw new ZooException("Id is already exist: " + koala.getId(), HttpStatus.BAD_REQUEST);
        }
        koalas.put(koala.getId(), koala);
        return koala;
    }

    @PutMapping("/{id}")
    public Koala updateKoalaById(@PathVariable int id, @RequestBody Koala koala) {
        if(id <= 0) {
            throw new ZooException("Id must be greater than 0", HttpStatus.BAD_REQUEST);
        }
        Koala updatedKoala = new Koala(id, koala.getName(), koala.getWeight(), koala.getSleepHour(), koala.getGender());
        koalas.put(id, updatedKoala);
        return updatedKoala;
    }

    @DeleteMapping("/{id}")
    public Koala deleteKoalaById(@PathVariable int id) {
        if(id <= 0) {
            throw new ZooException("Id must be greater than 0", HttpStatus.BAD_REQUEST);
        }
        if(!koalas.containsKey(id)) {
            throw new ZooException("Id is not exist: " + id, HttpStatus.NOT_FOUND);
        }
        return koalas.remove(id);
    }
}
