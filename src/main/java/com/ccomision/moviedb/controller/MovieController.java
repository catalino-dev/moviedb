package com.ccomision.moviedb.controller;

import com.ccomision.moviedb.dto.MovieDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping
public class MovieController implements MovieOperations {

    public MovieController() {
    }

    @Override
    public Page<MovieDto> showAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<MovieDto> showMovie(Long id) {
        return Optional.empty();
    }
}
