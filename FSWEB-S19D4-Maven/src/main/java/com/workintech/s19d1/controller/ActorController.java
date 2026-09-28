package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.ActorRequest;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.ActorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/actor")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> findAllActors() {
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public Actor findActorById(@PathVariable Long id) {
        return actorService.findById(id);
    }

    @PostMapping
    public Actor save(@RequestBody ActorRequest actorRequest) {
        Actor actor = actorRequest.getActor();
        actor.setMovies(actorRequest.getMovies());
        return actorService.save(actor);
    }

    @PutMapping("/{actorId}")
    public Actor updateActor(@PathVariable Long actorId, @RequestBody Actor actor) {
        return actorService.update(actorId,actor);
    }

    @DeleteMapping("/{actorId}")
    public Actor deleteActor(@PathVariable Long actorId) {
        Actor foundedActor = actorService.findById(actorId);
        actorService.delete(foundedActor);
        return foundedActor;
    }


}
