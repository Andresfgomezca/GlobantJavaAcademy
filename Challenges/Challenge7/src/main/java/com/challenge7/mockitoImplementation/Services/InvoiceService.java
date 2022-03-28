package com.challenge7.mockitoImplementation.Services;

import com.challenge7.mockitoImplementation.Exceptions.InsufficientFundsExceptionInvoice;
import com.challenge7.mockitoImplementation.Exceptions.InvalidBillException;
import com.challenge7.mockitoImplementation.Generators.BankAccountGenerator;
import com.challenge7.mockitoImplementation.Generators.InvoiceGenerator;
import com.challenge7.mockitoImplementation.Models.BankAccount;
import com.challenge7.mockitoImplementation.Models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    @Autowired
    private BankAccountGenerator bankAccountGenerator;
    @Autowired
    private InvoiceGenerator invoiceGenerator;

    public Invoice Payment(){
        BankAccount originAccount = bankAccountGenerator.transactionOrigin();
        Invoice invoice = invoiceGenerator.invoiceGenerated();

        if(verifyInvoiceIdIsCorrect(invoice)){
            if(verifyEnoughFunds(originAccount,invoice)){
                if(originAccount.getAccountType()=="Checking"){
                    originAccount.setFunds(originAccount.getFunds()-(invoice.getAmountToPay()*0.9));
                }else{
                    originAccount.setFunds(originAccount.getFunds()-(invoice.getAmountToPay()));
                }
                invoice.setStatus("Paid");
            }else {
                throw new InsufficientFundsExceptionInvoice();
            }
        } else {
            throw new InvalidBillException();
        }
        return invoice;
    }
    private boolean verifyEnoughFunds(BankAccount bankAccount, Invoice invoice){
        //This method aims the prefix A to verify if the account has enough funds to pay the invoice even if the account
        // is checking type and that the origin account has over 1.2 times the bill amount in its funds
        if(bankAccount.getAccountType()=="Checking"){
            return (bankAccount.getFunds()>=((invoice.getAmountToPay()*0.9)*1.2));
        }else{
            return (bankAccount.getFunds()>=invoice.getAmountToPay()*1.2);
        }

    }
    private boolean verifyInvoiceIdIsCorrect(Invoice invoice) {
        //this method aims the prefix D, verifying that the invoice id has the correct structure
        //NOTE: there was an error using the variable as Long and parsing the variable to String
        return (invoice.getInvoiceId().startsWith("00"))&&(invoice.getInvoiceId().length()==7);
    }
}
