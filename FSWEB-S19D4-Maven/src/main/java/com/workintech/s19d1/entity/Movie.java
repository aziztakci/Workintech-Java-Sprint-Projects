package com.workintech.s19d1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="movie",schema = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "director_name")
    private String directorName;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    }, mappedBy = "movies")

    @JsonIgnoreProperties("movies")
    private List<Actor> actors;


    public void addActor(Actor actor) {
        if (actors == null) {
            actors = new ArrayList<>();
        }
        if (!actors.contains(actor)) {
            actors.add(actor);
        }

        // İlişkinin Sahibi (Owning Side) olan Actor tarafına da bu filmi (this) ekliyoruz!
        if (actor.getMovies() == null) {
            actor.setMovies(new ArrayList<>());
        }
        if (!actor.getMovies().contains(this)) {
            actor.getMovies().add(this);
        }
    }
}
