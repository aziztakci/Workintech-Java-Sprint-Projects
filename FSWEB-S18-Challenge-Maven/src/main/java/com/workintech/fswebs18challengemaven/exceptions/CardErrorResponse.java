package com.workintech.fswebs18challengemaven.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardErrorResponse {
    private int httpStatus;
    private String message;
    private long timestamp;

    public CardErrorResponse(String message) {
        this.message = message;
    }
}
