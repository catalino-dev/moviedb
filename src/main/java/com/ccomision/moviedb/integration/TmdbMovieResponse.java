package com.ccomision.moviedb.integration;

import com.ccomision.moviedb.dto.MovieDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TmdbMovieResponse {

    @JsonProperty("results")
    List<MovieDto> content;

    @JsonProperty("page")
    int number;

    @JsonProperty("total_results")
    Long totalElements;

    @JsonProperty("total_pages")
    int totalPages;
}
