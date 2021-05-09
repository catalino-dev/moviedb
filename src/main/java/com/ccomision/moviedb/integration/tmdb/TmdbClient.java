package com.ccomision.moviedb.integration.tmdb;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TmdbClient {

    private final TmdbProperties tmdbProperties;
    private final RestTemplate restTemplate;

    public TmdbClient(TmdbProperties tmdbProperties, RestTemplate restTemplate) {
        this.tmdbProperties = tmdbProperties;
        this.restTemplate = restTemplate;
    }

    public TmdbPagedResponse getAllMovies(int page) {
        String tmdbEndpointUrl = tmdbProperties.getBaseUrl() + "?page=" + page;
        return restTemplate.getForEntity(tmdbEndpointUrl, TmdbPagedResponse.class).getBody();
    }
}
