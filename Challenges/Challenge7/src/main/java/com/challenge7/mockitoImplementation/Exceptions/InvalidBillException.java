package com.challenge7.mockitoImplementation.Exceptions;

public class InvalidBillException extends RuntimeException{
    public InvalidBillException(){
        super("the bill has incorrect id, it requires to initiate with 2 zeros and the amount of digits is exactly 7");
    }
}
