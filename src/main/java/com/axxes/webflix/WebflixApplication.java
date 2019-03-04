package com.axxes.webflix;

import com.axxes.webflix.domain.Movie;
import com.axxes.webflix.repository.MovieRepository;
import com.axxes.webflix.util.MovieReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class WebflixApplication implements CommandLineRunner {

    public static final String MOVIE_FILE = "movies.txt";

    @Autowired
    private MovieRepository movieRepository;

    private static final Logger logger = LoggerFactory.getLogger(WebflixApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WebflixApplication.class, args);
    }

    @Override
    public void run(String... strings) {
        List<Movie> movies = readMoviesFromFile();
        saveMoviesToRepo(movies);
        printMovieList();
    }

    private List<Movie> readMoviesFromFile() {
        return new MovieReader().readMovies(MOVIE_FILE);
    }

    private void saveMoviesToRepo(List<Movie> movies) {
        movies.forEach(movieRepository::save);
    }

    private void printMovieList() {
        logger.info("List of movies:");
        movieRepository.findAll().forEach(System.out::println);
    }

}
