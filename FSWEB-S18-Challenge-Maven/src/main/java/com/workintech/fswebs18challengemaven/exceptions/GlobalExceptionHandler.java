package com.workintech.fswebs18challengemaven.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CardErrorResponse> handleException(CardException cardException) {
        log.error("CardException fırlatıldı! Status: {}, Mesaj: {}",
                cardException.getHttpStatus(), cardException.getMessage());
        CardErrorResponse cardErrorResponse =
                new CardErrorResponse(cardException.getHttpStatus().value(), cardException.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(cardErrorResponse, cardException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<CardErrorResponse> handleException(Exception exception) {
        log.error("Beklenmeyen bir hata oluştu: ", exception);
        CardErrorResponse errorResponse =
                new  CardErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }




}
