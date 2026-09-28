package com.workintech.s19d1.util;

import com.workintech.s19d1.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class HollywoodValidation {

    public static void checkId(Long id) {
        if (id == null || id <= 0) {
            throw new ApiException("Id is not valid: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkEntityNotNull(Object entity) {
        if (entity == null) {
            throw new ApiException("Entity cannot be null", HttpStatus.BAD_REQUEST);
        }
    }
}