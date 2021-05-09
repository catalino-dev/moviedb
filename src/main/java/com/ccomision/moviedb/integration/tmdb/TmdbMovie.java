package com.ccomision.moviedb.integration.tmdb;

import com.ccomision.moviedb.entity.Movie;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import java.time.LocalDate;

@Data
@Hidden
@JsonIgnoreProperties(ignoreUnknown = true)
public class TmdbMovie {

    private Long id;
    private String title;

    private String overview;

    @JsonProperty(value = "poster_path")
    @JsonDeserialize(using = TmdbPosterImageDeserializer.class)
    private String poster;

    @JsonProperty(value = "vote_average")
    private Double voteAverage;

    private Double popularity;

    @JsonProperty(value = "release_date")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    public static Movie toMovie(TmdbMovie movieDto) {
        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setOverview(movieDto.getOverview());
        movie.setPoster(movieDto.getPoster());
        movie.setVoteAverage(movieDto.getVoteAverage());
        movie.setPopularity(movieDto.getPopularity());
        movie.setReleaseDate(movieDto.getReleaseDate());
        return movie;
    }
}
