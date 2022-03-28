package com.example.Thesis.Exceptions;

public class EmailNotValidException extends RuntimeException {
    public EmailNotValidException(String email) {
        super("The email is not valid, the domain must be from globant.com"
                + "\"" + email + "\"");
    }
}
