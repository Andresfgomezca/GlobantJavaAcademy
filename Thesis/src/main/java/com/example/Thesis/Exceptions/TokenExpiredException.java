package com.example.Thesis.Exceptions;

public class TokenExpiredException extends RuntimeException {
    public TokenExpiredException() {
        super("The token is already expired");
    }
}