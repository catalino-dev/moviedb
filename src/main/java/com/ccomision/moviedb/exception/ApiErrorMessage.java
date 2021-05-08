package com.ccomision.moviedb.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiErrorMessage {
    private String errorCode;
    private String errorMessage;
}
