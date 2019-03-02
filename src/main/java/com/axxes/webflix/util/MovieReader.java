package com.axxes.webflix.util;

import com.axxes.webflix.domain.Movie;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MovieReader {

    public List<Movie> readMovies(String filename) {
        try {
            File file = ResourceUtils.getFile("classpath:" + filename);
            return Files.readAllLines(file.toPath())
                    .stream()
                    .map(this::toMovie)
                    .collect(Collectors.toList());
        } catch (IOException e) {
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
