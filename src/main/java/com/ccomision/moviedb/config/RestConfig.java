package com.ccomision.moviedb.config;

import com.ccomision.moviedb.integration.tmdb.TmdbRequestInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    @Bean(name = "restTemplate")
    public RestTemplate buildTmdbRestTemplate(RestTemplateBuilder restTemplateBuilder,
                                              TmdbRequestInterceptor tmdbRequestInterceptor) {
        return restTemplateBuilder
            .interceptors(tmdbRequestInterceptor)
            .build();
    }
}
