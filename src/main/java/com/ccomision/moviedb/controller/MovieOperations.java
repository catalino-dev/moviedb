package com.ccomision.moviedb.controller;

import com.ccomision.moviedb.dto.MovieDto;
import com.ccomision.moviedb.entity.Movie;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie")
public interface MovieOperations {

    @GetMapping
    Page<MovieDto> showAll(Pageable pageable);

    @Operation(summary = "Get a movie by its id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the movie", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
        }),
        @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content) })
    @GetMapping("/{id}")
    MovieDto showMovie(@PathVariable Long id);
}
