package com.axxes.webflix.repository.impl;

import com.axxes.webflix.domain.Movie;
import com.axxes.webflix.repository.MovieRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("movieRepository")
public class MovieRepositoryImpl implements MovieRepository {

    private Map<Integer, Movie> movies = new HashMap<>();

    @Override
    public Movie findById(int id) {
        return movies.get(id);
    }

    @Override
    public Movie findByName(String name) {
        return movies.values().stream()
                .filter(m -> m.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public Movie save(Movie movie) {
        movies.put(movie.getId(), movie);

        return movie;
    }

    @Override
    public List<Movie> findAll() {
        return new ArrayList<>(movies.values());
    }

}
