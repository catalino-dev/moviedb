package com.ccomision.moviedb.integration.tmdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TmdbPagedResponse {

    @JsonProperty("results")
    List<TmdbMovie> content;

    @JsonProperty("page")
    int number;

    @JsonProperty("total_results")
    Long totalElements;

    @JsonProperty("total_pages")
    int totalPages;
}
