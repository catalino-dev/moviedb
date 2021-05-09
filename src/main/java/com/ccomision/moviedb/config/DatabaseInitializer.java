package com.ccomision.moviedb.config;

import com.ccomision.moviedb.entity.Movie;
import com.ccomision.moviedb.integration.tmdb.TmdbClient;
import com.ccomision.moviedb.integration.tmdb.TmdbMovie;
import com.ccomision.moviedb.integration.tmdb.TmdbProperties;
import com.ccomision.moviedb.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Configuration
public class DatabaseInitializer {

    private final TmdbProperties tmdbProperties;
    private final MovieRepository movieRepository;

    DatabaseInitializer(TmdbProperties tmdbProperties, MovieRepository movieRepository) {
        this.tmdbProperties = tmdbProperties;
        this.movieRepository = movieRepository;
    }

    @Bean
    CommandLineRunner initializeMovieDatabase(TmdbClient tmdbClient) {
        log.info("Initializing TMDb movies database...");
        int maxApiPagesToFetch = tmdbProperties.getApiMaxPages();

        List<Movie> movies = IntStream.range(1, maxApiPagesToFetch)
            .parallel()
            .mapToObj(tmdbClient::getAllMovies)
            .flatMap(response -> response.getContent().stream())
            .map(TmdbMovie::toMovie)
            .collect(Collectors.toList());

        return args -> movies.forEach(movieRepository::save);
    }
}
