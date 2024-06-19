package com.example.homework_2_m7.apivalidation;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

//public record UserNotFoundDto(String status , String message) { }
public record UserNotFoundDto(HttpStatusCode status , String message) { }
