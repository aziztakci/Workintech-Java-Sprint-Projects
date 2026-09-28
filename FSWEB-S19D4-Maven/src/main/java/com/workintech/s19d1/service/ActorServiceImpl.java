package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.ActorRepository;
import com.workintech.s19d1.util.HollywoodValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(Long id) {
        HollywoodValidation.checkId(id);
        return actorRepository.findById(id)
                .orElseThrow(() -> new ApiException("actor is not found with id: " + id, HttpStatus.NOT_FOUND));
    }
    @Transactional
    @Override
    public Actor save(Actor actor) {
        HollywoodValidation.checkEntityNotNull(actor);
        if (actor.getMovies() != null && !actor.getMovies().isEmpty()) {
            for (Movie movie : actor.getMovies()) {
                actor.addMovie(movie);
            }
        }
        return actorRepository.save(actor);
    }
    @Transactional
    @Override
    public Actor update(Long id, Actor actor) {
        HollywoodValidation.checkId(id);
        HollywoodValidation.checkEntityNotNull(actor);

        Actor existingActor = findById(id);

        existingActor.setFirstName(actor.getFirstName());
        existingActor.setLastName(actor.getLastName());
        existingActor.setGender(actor.getGender());
        existingActor.setBirthDate(actor.getBirthDate());

        if (actor.getMovies() != null) {
            for (Movie movie : actor.getMovies()) {
                existingActor.addMovie(movie);
            }
        }

        return actorRepository.save(existingActor);
    }
    @Transactional
    @Override
    public void delete(Actor actor) {
        HollywoodValidation.checkEntityNotNull(actor);
        actorRepository.delete(actor);
    }
}