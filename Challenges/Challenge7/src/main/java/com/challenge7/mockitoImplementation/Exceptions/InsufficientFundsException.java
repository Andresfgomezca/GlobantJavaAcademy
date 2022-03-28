package com.challenge7.mockitoImplementation.Exceptions;

public class InsufficientFundsException extends RuntimeException{

    public InsufficientFundsException(){
        super("Insufficient funds in the account to process the transaction.");
    }
}