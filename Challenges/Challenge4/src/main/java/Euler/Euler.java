package Euler;

import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Euler {
    //function to calculate the factorial of an Integer input
    static Function<Integer, Integer> factorial = f->(f==1) ? 1 : f * Euler.factorial.apply(f - 1);

    static BiFunction<Double, Integer, Double> pow = (base, pow) -> (pow == 0) ? 1 :base  *
            Euler.pow.apply(base, pow - 1);//this method will be reducing the pow until it is 1

    static BiFunction<Double, Integer, Double> E = (x, ePow) -> (ePow == 0) ? 1 : pow
            .apply(x,ePow)/factorial.apply(ePow) +  Euler.E.apply(x, ePow - 1);



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("submit the test cases");
        while(scan.hasNextDouble()){
            System.out.printf("%.4f",E.apply(scan.nextDouble(),9)); //expansion of the 10 terms
        }


    }
}
