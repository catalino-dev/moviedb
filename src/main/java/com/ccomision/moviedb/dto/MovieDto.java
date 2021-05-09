package com.ccomision.moviedb.dto;

import com.ccomision.moviedb.entity.Movie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Hidden
@NoArgsConstructor
public class MovieDto {

    private Long id;
    private String title;
    private String overview;
    private String poster;
    private Double voteAverage;
    private Double popularity;
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
