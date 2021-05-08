package com.ccomision.moviedb.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties("tmdb")
public class TmdbProperties {

	private String apiKey;
}
