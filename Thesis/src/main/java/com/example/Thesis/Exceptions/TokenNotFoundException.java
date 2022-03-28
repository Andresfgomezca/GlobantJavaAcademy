package com.example.Thesis.Exceptions;

public class TokenNotFoundException extends RuntimeException {
    public TokenNotFoundException() {
        super("The token submitted is not correct");
    }
}