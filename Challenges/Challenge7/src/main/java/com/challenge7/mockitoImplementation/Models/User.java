package com.challenge7.mockitoImplementation.Models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long userId;

    private String firstName;
    private String lastName;

    private Bank bank;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

}
