package com.ccomision.moviedb.service;

import com.ccomision.moviedb.MovieDbTestConfiguration;
import com.ccomision.moviedb.entity.Movie;
import com.ccomision.moviedb.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
@Import(MovieDbTestConfiguration.class)
class MovieServiceTest {

    @Autowired
    MovieService service;

    @MockBean
    private MovieRepository movieRepository;

    @Test
    @DisplayName("fetchById should fetch the movie by the given id")
    void testFetchById() {
        // setup
        Long movieId = 2L;
        Movie movie = new Movie(movieId, "Widget Name", "Description", "Poster", "voteAverage", 1.0, LocalDate.now());
        doReturn(Optional.of(movie)).when(movieRepository).findById(movieId);

        // when
        Optional<Movie> actualMovie = service.fetchById(movieId);

        // then
        assertTrue(actualMovie.isPresent(), "Movie was not found");
        assertSame(actualMovie.get(), movie, "The movie returned was not the same as the mock");
    }
}
