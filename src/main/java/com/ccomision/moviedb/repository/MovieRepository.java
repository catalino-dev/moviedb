package com.ccomision.moviedb.repository;

import com.ccomision.moviedb.entity.Movie;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {

    Optional<Movie> findById(Long id);
}
