package com.example.Thesis.Exceptions;

public class TokenAlreadyConfirmedException extends RuntimeException {
    public TokenAlreadyConfirmedException() {
        super("The token was used in a previous registration");
    }
}