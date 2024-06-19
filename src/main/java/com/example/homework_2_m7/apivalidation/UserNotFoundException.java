package com.example.homework_2_m7.apivalidation;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public HttpStatusCode StatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}