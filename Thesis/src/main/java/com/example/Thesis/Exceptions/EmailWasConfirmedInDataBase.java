package com.example.Thesis.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmailWasConfirmedInDataBase {


    @ResponseBody
    @ExceptionHandler(EmailConfirmedException.class)
    @ResponseStatus(HttpStatus.IM_USED)
    String EmailAlreadyExistsHandler(EmailConfirmedException exception) {
        return exception.getMessage();
    }
}
