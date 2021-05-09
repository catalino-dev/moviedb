package com.ccomision.moviedb.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(of = "errorCode")
enum ApiError {
    MOVIE_NOT_FOUND("The requested movie could not be found."),
    INVALID_REQUEST("The request is invalid."),
    URL_DOES_NOT_EXIST("The url you're trying to access does not exist."),
    INTERNAL_SERVER_ERROR("Service temporarily not available.");

    private final String errorCode;
    private final String errorMessage;

    ApiError(String errorMessage) {
        this.errorCode = this.name();
        this.errorMessage = errorMessage;
    }
}
