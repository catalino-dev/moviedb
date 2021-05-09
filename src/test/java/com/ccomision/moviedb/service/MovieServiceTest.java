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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@SpringBootTest
@Import(MovieDbTestConfiguration.class)
class MovieServiceTest {

    @Autowired
    MovieService service;

    @MockBean
    private MovieRepository movieRepository;

    @Test
    @DisplayName("fetchAll should fetch the movie by the given id")
    void testFetchAll() {
        // setup
        Pageable pageable = PageRequest.of(1, 5);
        Movie movie1 = new Movie();
        movie1.setId(1L);
        movie1.setTitle("The Flash");
        movie1.setOverview("Overview");
        movie1.setPoster("Poster");
        movie1.setPopularity(1.10);
        movie1.setVoteAverage("40.50");
        movie1.setReleaseDate(LocalDate.now());

        Movie movie2 = new Movie();
        movie2.setId(2L);
        movie2.setTitle("Spider-Man");
        movie2.setOverview("Overview");
        movie2.setPoster("Poster");
        movie2.setPopularity(2.10);
        movie2.setVoteAverage("99.50");
        movie2.setReleaseDate(LocalDate.now());

        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(movie1);
        expectedMovies.add(movie2);
        Page<Movie> pagedMovies = new PageImpl<>(expectedMovies, pageable, expectedMovies.size());
        doReturn(pagedMovies)
            .when(movieRepository).findAll(pageable);

        // when
        Page<Movie> actualPagedMovie = service.fetchAll(pageable);

        // then
        assertIterableEquals(expectedMovies, actualPagedMovie.getContent());
        verify(movieRepository).findAll(pageable);
    }

    @Test
    @DisplayName("fetchById should fetch the movie by the given id")
    void testFetchById() {
        // setup
        Long movieId = 2L;
        Movie expectedMovie = new Movie();
        expectedMovie.setId(movieId);
        expectedMovie.setTitle("Avengers");
        expectedMovie.setOverview("Overview");
        expectedMovie.setPoster("Poster");
        expectedMovie.setPopularity(1.10);
        expectedMovie.setVoteAverage("40.50");
        expectedMovie.setReleaseDate(LocalDate.now());
        doReturn(Optional.of(expectedMovie))
            .when(movieRepository).findById(movieId);

        // when
        Optional<Movie> actualMovie = service.fetchById(movieId);

        // then
        assertTrue(actualMovie.isPresent());
        assertSame(expectedMovie, actualMovie.get());
        verify(movieRepository).findById(movieId);
    }
}
