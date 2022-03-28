package com.challenge7.mockitoImplementation.Exceptions;

public class InsufficientFundsExceptionInvoice extends RuntimeException{

    public InsufficientFundsExceptionInvoice(){
        super("Insufficient funds in the account to process the payment. the funds must be 20% higher than the price of the invoice");
    }
}