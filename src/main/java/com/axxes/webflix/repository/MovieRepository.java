package com.axxes.webflix.repository;

import com.axxes.webflix.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository {

    Movie findById(int id);

    Movie findByName(String name);

    Movie save(Movie movie);

    List<Movie> findAll();

}
