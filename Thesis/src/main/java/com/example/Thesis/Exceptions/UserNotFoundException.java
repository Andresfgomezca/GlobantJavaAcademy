package com.example.Thesis.Exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String email) {
        super("The user " + email + " does not exist");
    }
}