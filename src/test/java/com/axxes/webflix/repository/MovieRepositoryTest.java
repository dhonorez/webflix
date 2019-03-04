package com.axxes.webflix.repository;

import com.axxes.webflix.domain.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void testSave() {
        Movie movie = new Movie(1, "12345", "Into the Wild", 2007, 81, new String[]{"Adventure", "Biography", "Drama"});

        movie = movieRepository.save(movie);

        assertThat(movie).isNotNull();
    }

}
