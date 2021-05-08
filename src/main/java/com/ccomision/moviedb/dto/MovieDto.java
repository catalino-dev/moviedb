package com.ccomision.moviedb.dto;

import com.ccomision.moviedb.entity.Movie;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Hidden
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDto {

    private Long id;
    private String title;

    private String overview;

    @JsonProperty(value = "poster_path")
    private String poster;

    @JsonProperty(value = "vote_average")
    private String voteAverage;

    private Double popularity;

    @JsonProperty(value = "release_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    private MovieDto(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.overview = movie.getOverview();
        this.poster = movie.getPoster();
        this.voteAverage = movie.getVoteAverage();
        this.popularity = movie.getPopularity();
        this.releaseDate = movie.getReleaseDate();
    }

    public static MovieDto from(Movie movie) {
        return new MovieDto(movie);
    }
}
