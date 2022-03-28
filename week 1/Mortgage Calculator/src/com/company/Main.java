package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //This project was proposed in the module 1.1 of the course Empower Training: Java Basics
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        double principal = 0;
        double annualRate = 0;
        int periodYears = 0;
        double monthlyInterest = 0;
        double numberPayments = 0;


        Scanner scanner =  new Scanner(System.in);
        while(true) {
            System.out.println("Principal amount: $1k-$1M");
            principal = scanner.nextDouble();
            if (scanner.nextDouble() >=1000 || scanner.nextDouble() <= 1_000_000) {
                break;
            }
            System.out.println("invalid value ($1k-$1M)");
        }
        while(true){
            System.out.println("Annual interest rate:");
            annualRate = scanner.nextDouble();
            if (annualRate >=1 && annualRate <=30){
                monthlyInterest = annualRate / MONTHS_IN_YEAR / PERCENT;
                break;
            }
            System.out.println("=invalid value (1%-30%)");
        }

        while(true){
            System.out.println("Period (years):");
            periodYears = scanner.nextInt();
            if (periodYears <= 10 && periodYears >=1) {
                numberPayments = periodYears * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("invalid value (1 year - 10 years)");
        }

        double monthlyPayment = (principal*
                monthlyInterest*Math.pow((1+monthlyInterest), numberPayments))
                /(Math.pow((1+monthlyInterest), numberPayments) - 1);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String mortgageCurrency = currency.format(monthlyPayment);
        System.out.println("your mortgage will be: " + mortgageCurrency);
    }
}
