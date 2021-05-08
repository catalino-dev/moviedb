package com.ccomision.moviedb.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MovieNotFoundException extends RuntimeException {

    private final String errorCode;
    private final String errorMessage;

    public MovieNotFoundException() {
        this.errorCode = ApiError.MOVIE_NOT_FOUND.getErrorCode();
        this.errorMessage = ApiError.MOVIE_NOT_FOUND.getErrorMessage();
    }
}
