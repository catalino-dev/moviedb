package com.ccomision.moviedb.service;

import com.ccomision.moviedb.entity.Movie;
import com.ccomision.moviedb.repository.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Page<Movie> fetchAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    public Optional<Movie> fetchById(Long id) {
        return movieRepository.findById(id);
    }
}
