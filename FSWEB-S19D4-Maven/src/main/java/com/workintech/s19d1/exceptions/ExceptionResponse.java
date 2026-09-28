package com.workintech.s19d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse {

    private String message;
    private int status;
    private LocalDateTime dateTime;
}