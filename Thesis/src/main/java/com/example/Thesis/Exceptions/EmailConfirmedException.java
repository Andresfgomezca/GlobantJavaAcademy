package com.example.Thesis.Exceptions;

public class EmailConfirmedException extends RuntimeException {
    public EmailConfirmedException(String email) {
        super("The email is already in use"
                + "\"" + email + "\"");
    }
}
