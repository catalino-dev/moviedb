package com.ccomision.moviedb.controller;

import com.ccomision.moviedb.MovieDbTestConfiguration;
import com.ccomision.moviedb.dto.MovieDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@Import(MovieDbTestConfiguration.class)
class MovieControllerTest {

    @Autowired
    private MovieController controller;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("showAll should show all movies with the given pagination filters")
    void testShowAll() {
        Pageable pageable = PageRequest.of(1, 10);
        Page<MovieDto> result = controller.showAll(pageable);

        assertFalse(result.hasContent());
    }

    @Test
    void showMovie() {
    }
}
