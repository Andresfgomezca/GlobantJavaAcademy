package com.company;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date; //importada por usar la clase date.
import java.util.Locale;
import java.util.Scanner;

public class Main { //always uppercase

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello world"); //print line method
        int age =30; //the best way to create the variables is by inizialiting the variables
        System.out.println(age); //print line method
        age=35;
        System.out.println(age); //print line method
        long viewCount = 3_123_456_789L;
        float price = 10.99F;
        char letter = 'A';
        boolean isElegible = false;
        //complex objects (data, mails, etc)
        //reference
        Date now = new Date();//using a function from the class date to print the current date
        System.out.println(now);


        Point point1 = new Point(1,2);
        Point point2 = point1; //this variable is not indipendend of each other
        point1.x = 2; //point 2 will be changed 2 because the change is in the memory and not just in the value

        String messsage = "message"; //Strings are reference types
        //some usefull methods (endsWith, StartsWith, indexOf, length, replace(target"",replacement"")) arguments are
        //the variables sended and parameters are the variables required, another example is trim() that removes extra
        //spaces (to remove errors in passwords)

        String example1 = "Hello \"andres\""; //it will add the "" to print hello "andres" in a String

        //tutorial for arrays

        int[] numbersx = new int[5];
        numbersx[0]=1;
        numbersx[1]=2;
        //it will crash if the index doesn't exist
        //we can call the arrays class to use the function to convert our array into a string
        Arrays.toString(numbersx);
        System.out.println(Arrays.toString(numbersx));
        //we can use the sort method to organize the array
        int[] numbersy = {1,2,3,4,5};
        System.out.println(numbersy.length);
        //2 dimensional array
        int[][] numbersx2 = new int [2][3];
        numbersx2[0][0] = 1;
        System.out.println(Arrays.deepToString(numbersx2));
        //We can also fulfill an array with {}
        int[][] array2 = {{1,2,3},{1,2,3}};


        //final variables

        final float pi = 3.14F; // is recommended to call constants with capital letters

        //casting, using variables that are of a different type
        //we can add short to an int but not viceversa, that implicit casting
        //byte > short > int > long > float > double
        //explicit casting will only happen with numbers if the variable x is a double we can call it like this: (int)x

        //String to int, Integer class has a method call "parseInt", float, short, double has the same method.

        //Math class
        /*
        -round, it rounds a float number to an int number (it also works with double)
        -we have also max, min, random

         */
        //Example of a random number between 0 to 100
        double random = Math.round(Math.random() * 100);
        //we can also use explicit casting with (int) to convert it to int

        //Formatting numbers
        /*
        we have the class numberFormat that has methods to convert the numbers
         */
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        //this class is abstract and we can not create an instance
        String ExampleCurrency = currency.format(123456789);

        //reading inputs from the user
        /*
         in java we have the scanner class to read imputs
         */
        Scanner scanner = new Scanner(System.in);
        byte age2 = scanner.nextByte();
        System.out.println("you are wrote" + age2);
        //example 2 of a clean code to read input
        System.out.println("Name: ");
        String name2 = scanner.nextLine().trim();
        //this expression will read the user input (name and last name) and remove the spaces to have a clear variable

        //CONTROL FLOW

        /*
        comparison operators

        logical operators

        conditional statements

        loops

        mortgage calculator error
         */
        //comparison operators
        // !+ == <= >=
        //Logical operators - example
        int temperature = 12;
        boolean iswarm = temperature > 20 && temperature < 30; //and
        System.out.println(iswarm);

        //exxample 2

        boolean hasHighIncome = true;
        boolean hasGoodCredit = true;

        boolean isEligible = hasGoodCredit || hasHighIncome; //or

        boolean hasCriminalRecords = false;
        //Example with not
        boolean isEligible2 = (hasGoodCredit || hasHighIncome) && !hasCriminalRecords; //not

        //if statements
        if (temperature >=30){
            System.out.println("its warm");
            System.out.println("drink water");
        }
        else if (temperature<30 && temperature>20) {
            System.out.println("is a cool day");
        }
        else{
            System.out.println("Cold day");
        }

        //Simplifying if statements

        int income = 120_000;
        boolean hasHughIncome = (income > 120000);

        //the ternary operator

        String className = income>100000 ? "first" : "Economy"; //on this case we are using the ? sign to submit an if

        //Switch statements - example

        String role = "admin";
        switch (role){
            case "admin":
                System.out.println("you are an admin");
                break;
            case "moderator":
                System.out.println("you are an moderator");
                break;
            default:
                System.out.println("you are a guest");
        //we can use different type of variables  depending on the variable selected
        }

        //for loop

        for (int i = 0; i < 5; i++)
            System.out.println("hello world");

        //while loops
        int i=5;
        while(i>0){
            System.out.println("hello world");
            i--;
        }
        //exercise 2
        Scanner scanner2 = new Scanner(System.in);
        String input = "";
        while (!input.equals("quit")){ //its bad practice to create the scanner inside the loop
            System.out.println("input:");
            input = scanner.nextLine().toLowerCase();
            System.out.println(input);
        }
        //while is useful when we don't know how many time we are going to repeat something

        //do.. while loop
        do{
            //it is executed at least once
        } while (!input.equals("quit"));


        //break and continue statement
        /*
        continue go to the beginning of the loop and break ends the loop
        COMMON TECHNIQUE IS USE WHILE(TRUE) AND A BREAK CONDITION TO END THE LOOP
         */

        //for each loop
        //it is use to itirate over arrays or collections
        String[] fruits = {"apple", "mango", "orange"};
        for (String fruit: fruits){ //has some limitations like access to the index or the order
            System.out.println(fruit);
        }

    }
}
