package com.challenge7.mockitoImplementation.Models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Invoice {
    private String invoiceId;
    private Long companyId;
    private double amountToPay;
    private String expirationDate;
    private String status;

    public Invoice(String invoiceId, Long companyId, double amountToPay, String expirationDate, String status) {
        this.invoiceId = invoiceId;
        this.companyId = companyId;
        this.amountToPay = amountToPay;
        this.expirationDate = expirationDate;
        this.status = status;
    }
}
