package com.ccomision.moviedb.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
public class ApiErrorMessage {

    @Schema(description = "The error code.")
    private String errorCode;

    @Schema(description = "The error message.")
    private String errorMessage;

    public static ApiErrorMessage of(ApiError apiError) {
        return new ApiErrorMessage(apiError.getErrorCode(), apiError.getErrorMessage());
    }
}
