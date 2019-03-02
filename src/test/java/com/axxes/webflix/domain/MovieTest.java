package com.axxes.webflix.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieTest {

    private Movie movie;

    @Test
    public void testDefaultMovie() {
        assertThat(movie.getName()).isEqualTo("Into the Wild");
    }

    @Test
    public void test_toString() {
        assertThat(movie.toString()).isEqualTo("Movie{id='1', imdb='t12345', name='Into the Wild', year=2007, score=81, tags=[Adventure, Biography, Drama]}");
    }

    @Before
    public void init() {
        movie = new Movie(1, "t12345", "Into the Wild", 2007, 81, new String[] { "Adventure", "Biography", "Drama"});
    }

}