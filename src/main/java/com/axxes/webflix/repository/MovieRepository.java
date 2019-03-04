package com.axxes.webflix.repository;

import com.axxes.webflix.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, Integer> {

    Movie findById(int id);

    Movie findByName(String name);

    Movie save(Movie movie);

    List<Movie> findAll();

}
