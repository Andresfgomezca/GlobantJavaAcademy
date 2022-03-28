package com.example.Thesis.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmailNotValidForValidator {


    @ResponseBody
    @ExceptionHandler(EmailNotValidException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    String EmailNotValidForValidator(EmailNotValidException exception) {
        return exception.getMessage();
    }
}
