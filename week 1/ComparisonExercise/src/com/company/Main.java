package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// this exercise is to use different comparisons
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number:");
        int number = scanner.nextInt();
        //if divisible by 5 we get fizz, by 3 we get buzz if it is not we get the same number printed on terminal
        //MOST SPECIFIC CONDITIONS FIRST
        if(number % 5 == 0 && number % 3 == 0){
            System.out.println("fizzbuzz");
        }
        else if(number % 5 == 0){
            System.out.println("fizz");
        }
        else if(number % 3 == 0){
            System.out.println("buzz");
        }
        else {
            System.out.println(number);
        }
    }
}
