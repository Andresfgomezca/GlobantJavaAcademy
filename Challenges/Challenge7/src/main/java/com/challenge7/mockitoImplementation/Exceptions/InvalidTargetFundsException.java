package com.challenge7.mockitoImplementation.Exceptions;

public class InvalidTargetFundsException extends RuntimeException{
    public InvalidTargetFundsException(){
        super("The target account can not receive the transaction due to the current funds in the account.");
    }
}
