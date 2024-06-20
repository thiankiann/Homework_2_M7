package com.example.homework_2_m7.apivalidation;

import com.example.homework_2_m7.controller.GitHubRestController;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@Log4j2
@ControllerAdvice(assignableTypes = GitHubRestController.class)
class ApiValidationErrorHandler {

    @ExceptionHandler( UserNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @JsonSerialize()
    public UserNotFoundDto handleException(UserNotFoundException exception){
        log.warn("WRONG USER NAME");
        //return new UserNotFoundDto(HttpStatus.NOT_FOUND, exception.getMessage());
        return new UserNotFoundDto(exception.StatusCode(), exception.getMessage());
      //  return new UserNotFoundDto("404", "Wrong user name ");
    }
}
