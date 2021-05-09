package com.ccomision.moviedb.integration.tmdb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

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
    private int apiMaxPages;
}
