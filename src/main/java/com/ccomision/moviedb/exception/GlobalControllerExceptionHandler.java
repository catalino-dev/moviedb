package com.ccomision.moviedb.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@Slf4j
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MovieNotFoundException.class)
    public ApiErrorMessage handleMovieNotFound(MovieNotFoundException ex) {
        return ApiErrorMessage.of(ex.getErrorCode(), ex.getErrorMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ApiErrorMessage handleBadRequest(MethodArgumentTypeMismatchException ex) {
        return ApiErrorMessage.of(ApiError.INVALID_REQUEST);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ NoHandlerFoundException.class })
    public ApiErrorMessage handleNoHandlerFound(NoHandlerFoundException ex) {
        return ApiErrorMessage.of(ApiError.URL_DOES_NOT_EXIST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public ApiErrorMessage handleInternalServerError(Exception ex) {
        log.error("Error in processing request: {}", ex.getLocalizedMessage());
        System.out.println("Log: " + Arrays.toString(ex.getStackTrace()));
        return ApiErrorMessage.of(ApiError.INTERNAL_SERVER_ERROR);
    }
}
