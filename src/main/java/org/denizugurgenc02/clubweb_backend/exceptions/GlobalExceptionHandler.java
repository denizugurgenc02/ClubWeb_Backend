package org.denizugurgenc02.clubweb_backend.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Status Code -> 500
    public ErrorResponse handleException(Exception e) {
        System.err.println("Error: " + e.getMessage());
        return new ErrorResponse("We have trouble: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
