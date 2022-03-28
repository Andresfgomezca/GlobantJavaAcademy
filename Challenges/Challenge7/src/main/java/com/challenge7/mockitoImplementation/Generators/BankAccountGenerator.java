package com.challenge7.mockitoImplementation.Generators;

import com.challenge7.mockitoImplementation.Models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BankAccountGenerator{
    BankAccount transactionOrigin();
    BankAccount transactionTarget();
}
