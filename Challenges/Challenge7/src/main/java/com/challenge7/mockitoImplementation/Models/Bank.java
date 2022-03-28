package com.challenge7.mockitoImplementation.Models;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Bank {

    private Long bankId;
    private String bankName;

    public Bank(Long id, String bankName) {
        this.bankId = id;
        this.bankName = bankName;
    }
    public Bank(){

    }
}
