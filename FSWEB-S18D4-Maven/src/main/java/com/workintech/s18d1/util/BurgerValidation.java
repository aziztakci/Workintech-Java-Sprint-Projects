package com.workintech.s18d1.util;

import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
    public static void checkId(long id) {
        if (id <= 0) {
            throw new BurgerException("Id must be greater than 0: " + id, HttpStatus.BAD_REQUEST);
        }
    }
}