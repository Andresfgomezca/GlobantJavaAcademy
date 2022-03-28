package com.challenge7.mockitoImplementation.Models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transaction {
    int transactionId;
    double amount;
    String origin;
    String target;
}
