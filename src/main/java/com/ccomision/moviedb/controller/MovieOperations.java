package com.ccomision.moviedb.controller;

import com.ccomision.moviedb.dto.MovieDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping("/movie")
public interface MovieOperations {

    @GetMapping
    Page<MovieDto> showAll(Pageable pageable);

    @GetMapping("/{id}")
    Optional<MovieDto> showMovie(@PathVariable Long id);
}
