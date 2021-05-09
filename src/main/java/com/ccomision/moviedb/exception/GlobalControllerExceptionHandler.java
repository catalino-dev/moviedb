package com.ccomision.moviedb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MovieNotFoundException.class)
    public ApiErrorMessage handleMovieNotFound(MovieNotFoundException ex) {
        return ApiErrorMessage.of(ex.getErrorCode(), ex.getErrorMessage());
    }
}
