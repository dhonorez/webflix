package com.axxes.webflix;

import com.axxes.webflix.util.MovieReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebflixApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(WebflixApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WebflixApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("List of movies:");
        new MovieReader().readMovies().forEach(m -> logger.info("{}", m));
    }

}
