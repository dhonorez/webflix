package com.axxes.webflix.util;

import com.axxes.webflix.domain.Movie;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MovieReader {

    public List<Movie> readMovies() {
        try {
            return Files.readAllLines(Paths.get(this.getClass().getResource("/movies.txt").toURI()))
                    .stream()
                    .map(this::toMovie)
                    .collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private Movie toMovie(String line) {
        String[] fields = line.split(";");
        return new Movie(
                Integer.parseInt(fields[0]),    // id
                stripQuotes(fields[1]),         // imdb
                stripQuotes(fields[2]),         // title
                Integer.parseInt(fields[3]),    // year
                Integer.parseInt(fields[4]),    // score
                fields[5].split(",")      // tags
        );
    }

    private static String stripQuotes(String field) {
        if (field.startsWith("'") && field.endsWith("'")) {
            return field.substring(1, field.length() - 1);
        } else {
            return field;
        }
    }

}
