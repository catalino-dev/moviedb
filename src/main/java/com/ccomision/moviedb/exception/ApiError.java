package com.ccomision.moviedb.exception;

import lombok.Getter;

@Getter
enum ApiError {
    MOVIE_NOT_FOUND("The movie could not be found.");

    private final String errorCode;
    private final String errorMessage;

    ApiError(String errorMessage) {
        this.errorCode = this.name();
        this.errorMessage = errorMessage;
    }

    public String toString() {
        return this.errorCode;
    }
}
