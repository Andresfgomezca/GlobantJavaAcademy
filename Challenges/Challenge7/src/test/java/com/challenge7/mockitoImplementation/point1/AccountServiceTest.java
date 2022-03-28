package com.challenge7.mockitoImplementation.point1;

import com.challenge7.mockitoImplementation.Exceptions.InsufficientFundsException;
import com.challenge7.mockitoImplementation.Exceptions.InvalidTargetFundsException;
import com.challenge7.mockitoImplementation.Generators.BankAccountGenerator;
import com.challenge7.mockitoImplementation.Models.Bank;
import com.challenge7.mockitoImplementation.Models.BankAccount;
import com.challenge7.mockitoImplementation.Models.User;
import com.challenge7.mockitoImplementation.Services.BankAccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    @Mock
    private BankAccountGenerator bankAccountGenerator;

    @InjectMocks
    private BankAccountService bankAccountService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void TransactionToAnotherBankTest() {
        //setup - data
        Bank globant = new Bank(5L, "Globant");
        Bank bankX = new Bank(2L, "bankX");
        User user1 = User.builder()
                .userId(1L)
                .firstName("Andres")
                .lastName("Gomez")
                .bank(globant)
                .build();
        User user2 = User.builder()
                .userId(1L)
                .firstName("Juan")
                .lastName("Marin")
                .bank(bankX)
                .build();
        BankAccount origin = new BankAccount(1L, "Savings", 2000000, user1, globant);
        BankAccount target = new BankAccount(2L, "Savings", 100000, user2, bankX);
        //setup - expectations
        Mockito.when(bankAccountGenerator.transactionOrigin()).thenReturn(origin);
        Mockito.when(bankAccountGenerator.transactionTarget()).thenReturn(target);
        //Service
        bankAccountService.calculateTransaction(500000);
        //validation
        assertAll(
                () -> assertEquals(1496500, origin.getFunds()),
                () -> assertEquals(600000, target.getFunds())
        );
    }

    @Test
    public void EnoughFundsTest() {
        //setup - data
        Bank globant = new Bank(5L, "Globant");
        Bank bankX = new Bank(2L, "bankX");
        User user1 = User.builder()
                .userId(1L)
                .firstName("Andres")
                .lastName("Gomez")
                .bank(globant)
                .build();
        User user2 = User.builder()
                .userId(1L)
                .firstName("Juan")
                .lastName("Marin")
                .bank(bankX)
                .build();
        BankAccount origin = new BankAccount(1L, "Savings", 400000, user1, globant);
        BankAccount target = new BankAccount(2L, "Savings", 100000, user2, bankX);
        //setup - expectations
        Mockito.when(bankAccountGenerator.transactionOrigin()).thenReturn(origin);
        Mockito.when(bankAccountGenerator.transactionTarget()).thenReturn(target);
        //Service
        InsufficientFundsException exception = assertThrows(InsufficientFundsException.class, () -> bankAccountService.calculateTransaction(500000));
        //validation
        Assertions.assertEquals("Insufficient funds in the account to process the transaction.", exception.getMessage());
    }

    @Test
    public void verifyAccountTypeException() {
        //setup - data
        Bank globant = new Bank(5L, "Globant");
        Bank bankX = new Bank(2L, "bankX");
        User user1 = User.builder()
                .userId(1L)
                .firstName("Andres")
                .lastName("Gomez")
                .bank(globant)
                .build();
        User user2 = User.builder()
                .userId(1L)
                .firstName("Juan")
                .lastName("Marin")
                .bank(bankX)
                .build();
        BankAccount origin = new BankAccount(1L, "Savings", 2000000, user1, globant);
        BankAccount target = new BankAccount(2L, "Checking", 2000000, user2, bankX);
        //setup - expectations
        Mockito.when(bankAccountGenerator.transactionOrigin()).thenReturn(origin);
        Mockito.when(bankAccountGenerator.transactionTarget()).thenReturn(target);
        //Service
        InvalidTargetFundsException exception = assertThrows(InvalidTargetFundsException.class, () -> bankAccountService.calculateTransaction(500000));
        //validation
        Assertions.assertEquals("The target account can not receive the transaction due to the current funds in the account.", exception.getMessage());
    }

    @Test
    public void TransactionToDifferentBankWithBigAmmount() {
        //setup - data
        Bank globant = new Bank(5L, "Globant");
        Bank bankX = new Bank(2L, "bankX");
        User user1 = User.builder()
                .userId(1L)
                .firstName("Andres")
                .lastName("Gomez")
                .bank(globant)
                .build();
        User user2 = User.builder()
                .userId(1L)
                .firstName("Juan")
                .lastName("Marin")
                .bank(bankX)
                .build();
        BankAccount origin = new BankAccount(1L, "Savings", 2200000, user1, globant);
        BankAccount target = new BankAccount(1L, "Savings", 100000, user2, bankX);
        //setup - expectations
        Mockito.when(bankAccountGenerator.transactionOrigin()).thenReturn(origin);
        Mockito.when(bankAccountGenerator.transactionTarget()).thenReturn(target);
        //Service
        bankAccountService.calculateTransaction(2000000);
        //validation
        assertAll(
                () -> Assertions.assertEquals(196500, origin.getFunds()),
                //there should be a tax to the target account due to the amount received
                () -> Assertions.assertEquals(2040000, target.getFunds())
        );
    }
}