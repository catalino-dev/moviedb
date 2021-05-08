package com.ccomision.moviedb.config;

import com.ccomision.moviedb.entity.Movie;
import com.ccomision.moviedb.integration.TmdbClient;
import com.ccomision.moviedb.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;

@Configuration
class LoadDatabase {

  private final MovieRepository movieRepository;

  LoadDatabase(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  @Bean
  CommandLineRunner initDatabase(TmdbClient tmdbClient) {
      List<Movie> movies = IntStream.range(1, 100)
        .parallel()
        .peek(value -> out.print("."))
        .mapToObj(tmdbClient::populateMovies)
        .flatMap(response -> response.getContent().stream())
        .map(Movie::from)
        .collect(Collectors.toList());

    return args -> movies.forEach(movieRepository::save);
  }
}
