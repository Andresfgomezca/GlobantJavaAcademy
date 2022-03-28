package com.challenge7.mockitoImplementation.Models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankAccount {

    private Long accountNumber;

    private String accountType;
    private double funds;

    private User user;
    private Bank bank;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankAccount(Long accountNumber, String accountType, double funds, User user, Bank bank) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.funds = funds;
        this.user = user;
        this.bank = bank;
    }

    public BankAccount() {

    }

    ;
}
