package com.ccomision.moviedb.entity;

import com.ccomision.moviedb.dto.MovieDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String overview;

    private String poster;

    private String voteAverage;

    private Double popularity;

    private LocalDate releaseDate;

    public static Movie from(MovieDto movieDto) {
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
