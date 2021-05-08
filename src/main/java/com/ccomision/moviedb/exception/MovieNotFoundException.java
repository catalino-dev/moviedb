package com.ccomision.moviedb.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MovieNotFoundException extends RuntimeException {

    private final String errorMessage;

    public MovieNotFoundException() {
        this.errorMessage = ApiError.MOVIE_NOT_FOUND.getErrorMessage();
    }
}
