package com.ccomision.moviedb.controller;

import com.ccomision.moviedb.entity.Movie;
import com.ccomision.moviedb.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("showAll should show all movies with the given pagination filters")
    void testShowAllSuccess() throws Exception {
        // setup
        int page = 1;
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);

        Movie movie1 = new Movie();
        movie1.setId(1L);
        movie1.setTitle("Avengers");
        movie1.setOverview("Overview");
        movie1.setPoster("Poster");
        movie1.setPopularity(1.10);
        movie1.setVoteAverage(40.5);
        movie1.setReleaseDate(LocalDate.now());

        Movie movie2 = new Movie();
        movie2.setId(2L);
        movie2.setTitle("Spider-Man");
        movie2.setOverview("Overview");
        movie2.setPoster("Poster");
        movie2.setPopularity(2.10);
        movie2.setVoteAverage(99.5);
        movie2.setReleaseDate(LocalDate.now());

        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        Page<Movie> pagedMovies = new PageImpl<>(movies, pageable, movies.size());

        when(movieService.fetchAll(pageable)).thenReturn(pagedMovies);

        // when
        mockMvc.perform(get("/api/movie?page=1&size=10")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        // then
        verify(movieService).fetchAll(pageable);
    }

    @Test
    @DisplayName("showMovie should show requested movie for the given movie id")
    void testShowMovieSuccess() throws Exception {
        // setup
        long movieId = 8L;
        Movie movie = new Movie();
        movie.setId(movieId);
        movie.setTitle("Avengers");
        movie.setOverview("Overview");
        movie.setPoster("Poster");
        movie.setPopularity(1.10);
        movie.setVoteAverage(40.5);
        movie.setReleaseDate(LocalDate.now());

        when(movieService.fetchById(movieId)).thenReturn(Optional.of(movie));

        // when
        mockMvc.perform(get("/api/movie/" + movieId)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        // then
        verify(movieService).fetchById(movieId);
    }

    @Test
    @DisplayName("showMovie should return NOT_FOUND https status when fetching a movie that does not exist")
    void testShowMovieWithFailedResourceNotFound() throws Exception {
        // setup
        long movieId = 4L;

        when(movieService.fetchById(movieId)).thenReturn(Optional.empty());

        // when
        mockMvc.perform(get("/api/movie/" + movieId)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());

        // then
        verify(movieService).fetchById(movieId);
    }
}
