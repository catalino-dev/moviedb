package com.ccomision.moviedb.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class TmdbClient {

    private static final String BASE_URL = "https://api.themoviedb.org/3/movie";

    private final RestTemplate restTemplate;

    public TmdbClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public TmdbMovieResponse populateMovies(int page) {
        String tmdbEndpointUrl = BASE_URL + "/popular?page=" + page;
        return restTemplate.getForEntity(tmdbEndpointUrl, TmdbMovieResponse.class).getBody();
    }
}
