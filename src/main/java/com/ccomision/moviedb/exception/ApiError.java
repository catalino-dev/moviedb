package com.ccomision.moviedb.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(of = "errorCode")
enum ApiError {
    MOVIE_NOT_FOUND("The requested movie could not be found.");

    private final String errorCode;
    private final String errorMessage;

    ApiError(String errorMessage) {
        this.errorCode = this.name();
        this.errorMessage = errorMessage;
    }
}
