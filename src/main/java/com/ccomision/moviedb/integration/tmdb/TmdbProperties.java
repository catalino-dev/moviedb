package com.ccomision.moviedb.integration.tmdb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@Component
@ConfigurationProperties("tmdb")
public class TmdbProperties {

    @NotNull
    private String apiKey;

    @NotNull
    private String baseUrl;

    @NotNull
    @Positive
    private int apiMaxPages;
}
