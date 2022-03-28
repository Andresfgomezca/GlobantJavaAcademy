package com.challenge7.mockitoImplementation.Services;

import com.challenge7.mockitoImplementation.Exceptions.InsufficientFundsException;
import com.challenge7.mockitoImplementation.Exceptions.InvalidTargetFundsException;
import com.challenge7.mockitoImplementation.Generators.BankAccountGenerator;
import com.challenge7.mockitoImplementation.Models.BankAccount;
import com.challenge7.mockitoImplementation.Models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountGenerator bankAccountGenerator;

    public Transaction calculateTransaction(double transactionFunds) {
        BankAccount originTransaction = bankAccountGenerator.transactionOrigin();
        BankAccount targetTransaction = bankAccountGenerator.transactionTarget();

        double TransactionTax = transactionFunds > 1500000 ? 0.03 : 0;

        if (verifyFunds(originTransaction, transactionFunds, verifyTheTargetBankForTheTransactionIsGlobant(targetTransaction))) {
            //there are enough funds in the account for the transaction
            if (verifyCheckingAccountCondition(targetTransaction, transactionFunds)) {
                //verify if the transaction can not be processed due to the current funds of the target
                if (verifyTheTargetBankForTheTransactionIsGlobant(targetTransaction)) {
                    //no extra charges for the origin account because is to the same bank
                    originTransaction.setFunds(originTransaction.getFunds() - transactionFunds);
                    targetTransaction.setFunds(targetTransaction.getFunds() + transactionFunds - (TransactionTax*transactionFunds));
                } else {
                    //extra charge of 3500 because the target account is from a different bank
                    originTransaction.setFunds(originTransaction.getFunds() - transactionFunds - 3500);
                    targetTransaction.setFunds(targetTransaction.getFunds() + transactionFunds - (TransactionTax*transactionFunds));
                }
            } else {
                //target account has over 3 times the amount of the transaction
                throw new InvalidTargetFundsException();
            }
        } else {
            throw new InsufficientFundsException();
        }
        return Transaction.builder()
                .transactionId(1)
                .amount(transactionFunds)
                .origin(originTransaction.getUser().getFirstName()).target(targetTransaction.getUser().getFirstName())
                .build();
    }

    private boolean verifyFunds(BankAccount originAccount, double transactionFunds, boolean targetBank) {
        if (targetBank) {
            //there is no cost for the transaction
            return (originAccount.getFunds() > transactionFunds);
        } else {
            //there is a cost for the transaction to other banks
            return (originAccount.getFunds() > transactionFunds + 3500);
        }
    }

    private boolean verifyCheckingAccountCondition(BankAccount targetAccount, double fundsToTransaction) {
        if (targetAccount.getAccountType() == "Checking") {
            if (targetAccount.getFunds() > (fundsToTransaction * 3)) {
                //Account type is checking but the account has over 3 times the amount of money of the transaction
                return false;
            } else {
                //Account type is checking and the founds are less than 3 times the transaction
                return true;
            }
        } else {
            //Account is savings type and the transaction can be process
            return true;
        }
    }

    private boolean verifyTheTargetBankForTheTransactionIsGlobant(BankAccount bank) {
        //Verify if the bank target is globant
        return bank.getBank().getBankName() == "Globant";
    }

}
