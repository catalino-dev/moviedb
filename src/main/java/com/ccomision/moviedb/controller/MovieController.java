package com.ccomision.moviedb.controller;

import com.ccomision.moviedb.dto.MovieDto;
import com.ccomision.moviedb.exception.MovieNotFoundException;
import com.ccomision.moviedb.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MovieController implements MovieOperations {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public Page<MovieDto> showAll(Pageable pageable) {
        return movieService.fetchAll(pageable)
            .map(MovieDto::from);
    }

    @Override
    public MovieDto showMovie(Long id) {
        return movieService.fetchById(id)
            .map(MovieDto::from)
            .orElseThrow(MovieNotFoundException::new);
    }
}
