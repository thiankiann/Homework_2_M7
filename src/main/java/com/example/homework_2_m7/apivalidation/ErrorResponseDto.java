package com.example.homework_2_m7.apivalidation;

import org.springframework.http.HttpStatusCode;

//public record UserNotFoundDto(String status , String message) { }
public record ErrorResponseDto(HttpStatusCode status , String message) { }
