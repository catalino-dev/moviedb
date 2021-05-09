package com.ccomision.moviedb.controller;

import com.ccomision.moviedb.dto.MovieDto;
import com.ccomision.moviedb.entity.Movie;
import com.ccomision.moviedb.exception.ApiErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "movie", description = "The movie API")
public interface MovieOperations {

    /**
     * Get all catalog of movies
     *
     * @param pageable Contains pagination filters used to modify the criteria to be returned
     *
     * @return a {@link MovieDto}
     */
    @Operation(summary = "Get all catalog of movies", tags = { "movie" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Movie.class)))
        })
    })
    @GetMapping
    Page<MovieDto> showAll(@ParameterObject Pageable pageable);

    /**
     * Get the movie of the given {@code movieId}
     *
     * @param movieId The movie identifier
     *
     * @return a {@link MovieDto}
     */
    @Operation(summary = "Get the requested movie", tags = { "movie" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
        }),
        @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorMessage.class))
        }),
        @ApiResponse(responseCode = "404", description = "Movie not found", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorMessage.class))
        })
    })
    @GetMapping("/{movieId}")
    MovieDto showMovie(
        @Parameter(description = "Id of the movie to be shown. Cannot be empty.", required = true)
        @PathVariable Long movieId);
}
