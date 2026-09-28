package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.MovieRepository;
import com.workintech.s19d1.util.HollywoodValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        HollywoodValidation.checkId(id);
        return movieRepository.findById(id)
                .orElseThrow(() -> new ApiException("Movie is not found with id: " + id, HttpStatus.NOT_FOUND));
    }
    @Transactional
    @Override
    public Movie save(Movie movie) {
        HollywoodValidation.checkEntityNotNull(movie);
        if (movie.getActors() != null && !movie.getActors().isEmpty()) {
            for (Actor actor : movie.getActors()) {
                movie.addActor(actor);
            }
        }
        return movieRepository.save(movie);
    }
    @Transactional
    @Override
    public Movie update(Long id, Movie movie) {
        HollywoodValidation.checkId(id);
        HollywoodValidation.checkEntityNotNull(movie);

        Movie existingMovie = findById(id);

        existingMovie.setName(movie.getName());
        existingMovie.setDirectorName(movie.getDirectorName());
        existingMovie.setRating(movie.getRating());
        existingMovie.setReleaseDate(movie.getReleaseDate());

        if (movie.getActors() != null) {
            for (Actor actor : movie.getActors()) {
                existingMovie.addActor(actor);
            }
        }

        return movieRepository.save(existingMovie);
    }
    @Transactional
    @Override
    public void delete(Movie movie) {
        HollywoodValidation.checkEntityNotNull(movie);
        movieRepository.delete(movie);
    }
}