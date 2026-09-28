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
@Table(name="actor",schema = "movie")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinTable(name = "movie_actor", schema = "movie",
    joinColumns = @JoinColumn(name = "actor_id"),
    inverseJoinColumns = @JoinColumn(name = "movie_id"))
    @JsonIgnoreProperties("actors")
    private List<Movie> movies;

    public void addMovie(Movie movie) {
        if (movies == null) {
            movies = new ArrayList<>();
        }
        if (!movies.contains(movie)) {
            movies.add(movie);
        }

        // Karşı taraftaki (Movie) actors listesine de bu oyuncuyu (this) ekliyoruz!
        if (movie.getActors() == null) {
            movie.setActors(new ArrayList<>());
        }
        if (!movie.getActors().contains(this)) {
            movie.getActors().add(this);
        }
    }


}
