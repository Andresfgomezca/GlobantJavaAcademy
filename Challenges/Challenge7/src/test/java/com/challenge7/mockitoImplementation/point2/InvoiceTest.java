package com.challenge7.mockitoImplementation.point2;

import com.challenge7.mockitoImplementation.Exceptions.InsufficientFundsException;
import com.challenge7.mockitoImplementation.Exceptions.InsufficientFundsExceptionInvoice;
import com.challenge7.mockitoImplementation.Exceptions.InvalidBillException;
import com.challenge7.mockitoImplementation.Exceptions.InvalidTargetFundsException;
import com.challenge7.mockitoImplementation.Generators.BankAccountGenerator;
import com.challenge7.mockitoImplementation.Generators.InvoiceGenerator;
import com.challenge7.mockitoImplementation.Models.Bank;
import com.challenge7.mockitoImplementation.Models.BankAccount;
import com.challenge7.mockitoImplementation.Models.Invoice;
import com.challenge7.mockitoImplementation.Models.User;
import com.challenge7.mockitoImplementation.Services.BankAccountService;
import com.challenge7.mockitoImplementation.Services.InvoiceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.persistence.criteria.CriteriaBuilder;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {

    @Mock
    private InvoiceGenerator invoiceGenerator;

    @InjectMocks
    private InvoiceService invoiceService;

    @Mock
    private BankAccountGenerator bankAccountGenerator;

    @InjectMocks
    private BankAccountService bankAccountService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void NotEnoughFundsExceptionDueToThePorcentRequired() {
        //setup - data
        Bank globant = new Bank(5L, "Globant");
        User user1 = User.builder()
                .userId(1L)
                .firstName("Andres")
                .lastName("Gomez")
                .bank(globant)
                .build();
        BankAccount origin = new BankAccount(1L, "Savings", 230000, user1, globant);
        Invoice invoice = new Invoice("0012345", 10101010L, 200000, "2022-04-10", "Not paid");
        //setup - expectations
        Mockito.when(bankAccountGenerator.transactionOrigin()).thenReturn(origin);
        Mockito.when(invoiceGenerator.invoiceGenerated()).thenReturn(invoice);
        //Service
        InsufficientFundsExceptionInvoice exception = assertThrows(InsufficientFundsExceptionInvoice.class,
                () -> invoiceService.Payment());
        //validation
        Assertions.assertEquals
                ("Insufficient funds in the account to process the payment. " +
                        "the funds must be 20% higher than the price of the invoice", exception.getMessage());
    }

    @Test
    public void EnoughFundsTest() {
        //setup - data
        Bank globant = new Bank(5L, "Globant");
        User user1 = User.builder()
                .userId(1L)
                .firstName("Andres")
                .lastName("Gomez")
                .bank(globant)
                .build();
        BankAccount origin = new BankAccount(1L, "Savings", 250000, user1, globant);
        Invoice invoice = new Invoice("0012345", 10101010L, 200000, "2022-04-10", "Not paid");
        //setup - expectations
        Mockito.when(bankAccountGenerator.transactionOrigin()).thenReturn(origin);
        Mockito.when(invoiceGenerator.invoiceGenerated()).thenReturn(invoice);
        //Service
        invoiceService.Payment();
        //validation
        assertAll(
                () -> Assertions.assertEquals(50000, origin.getFunds()),
                //there should be a tax to the target account due to the amount received
                () -> Assertions.assertEquals("paid", invoice.getStatus())
        );
    }
    @Test
    public void VerifyDiscountForCheckingAccount() {
        //setup - data
        Bank globant = new Bank(5L, "Globant");
        User user1 = User.builder()
                .userId(1L)
                .firstName("Andres")
                .lastName("Gomez")
                .bank(globant)
                .build();
        BankAccount origin = new BankAccount(1L, "Checking", 250000, user1, globant);
        Invoice invoice = new Invoice("0012345", 10101010L, 200000, "2022-04-10", "Not paid");
        //setup - expectations
        Mockito.when(bankAccountGenerator.transactionOrigin()).thenReturn(origin);
        Mockito.when(invoiceGenerator.invoiceGenerated()).thenReturn(invoice);
        //Service
        invoiceService.Payment();
        //validation
        assertAll(
                () -> Assertions.assertEquals(70000, origin.getFunds()),
                //there should be a tax to the target account due to the amount received
                () -> Assertions.assertEquals("paid", invoice.getStatus())
        );
    }

    @Test
    public void VerifyInvoiceHasACorrectStructure() {
        //setup - data
        Bank globant = new Bank(5L, "Globant");
        User user1 = User.builder()
                .userId(1L)
                .firstName("Andres")
                .lastName("Gomez")
                .bank(globant)
                .build();
        BankAccount origin = new BankAccount(1L, "Checking", 250000, user1, globant);
        Invoice invoice = new Invoice("0123456", 10101010L, 200000, "2022-04-10", "Not paid");
        //setup - expectations
        Mockito.when(bankAccountGenerator.transactionOrigin()).thenReturn(origin);
        Mockito.when(invoiceGenerator.invoiceGenerated()).thenReturn(invoice);
        //Service
        InvalidBillException exception = assertThrows(InvalidBillException.class,
                () -> invoiceService.Payment());
        //validation
        Assertions.assertEquals
                ("the bill has incorrect id, it requires to initiate with " +
                        "2 zeros and the amount of digits is exactly 7", exception.getMessage());
    }
}