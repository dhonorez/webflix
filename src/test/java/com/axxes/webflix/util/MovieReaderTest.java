package com.axxes.webflix.util;

import com.axxes.webflix.domain.Movie;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieReaderTest {

    private MovieReader movieReader = new MovieReader();

    @Test
    public void readMovies() {
        List<Movie> movies = movieReader.readMovies("movies.txt");

        assertThat(movies).isNotEmpty();
        assertThat(movies).hasSize(10);
    }

}