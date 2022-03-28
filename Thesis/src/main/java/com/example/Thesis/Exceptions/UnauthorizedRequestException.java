package com.example.Thesis.Exceptions;

public class UnauthorizedRequestException extends RuntimeException {
    public UnauthorizedRequestException() {
        super("User does not have the permissions to process this request");
    }
}