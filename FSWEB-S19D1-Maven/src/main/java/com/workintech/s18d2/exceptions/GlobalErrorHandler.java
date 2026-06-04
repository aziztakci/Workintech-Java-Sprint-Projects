package com.workintech.s18d2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {

@ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(PlantException plantException) {
    ErrorResponse errorResponse = new ErrorResponse(plantException.getMessage());
    return new ResponseEntity<>(errorResponse,plantException.getHttpStatus());
}

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
