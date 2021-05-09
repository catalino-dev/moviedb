package com.ccomision.moviedb.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the movie.", example = "1", required = true)
    private Long id;

    @Schema(description = "Title of the movie.", required = true)
    private String title;

    @Lob
    @Schema(description = "Plot summary of the movie.")
    private String overview;

    @Schema(description = "Poster image link of the movie.")
    private String poster;

    @Schema(description = "Vote average of the movie.")
    private String voteAverage;

    @Schema(description = "The popularity value of the movie.")
    private Double popularity;

    @Schema(description = "The release date of the movie.")
    private LocalDate releaseDate;
}
