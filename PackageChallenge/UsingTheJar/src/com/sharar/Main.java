package com.sharar;

import com.sharar.mathfunctions.Series;

public class Main {

    public static void main(String[] args) {
        Series series = new Series();

        System.out.println("Sum to n");
        int limit = 8;
        for (int i = 0; i < limit; i++) {
            System.out.println(series.nSum(i));
        }
        System.out.println("Factorials");
        for (int i = 0; i < limit; i++) {
            System.out.println(series.factorial(i));
        }
        System.out.println("Fibonacci");
        for (int i = 0; i < limit; i++) {
            System.out.println(series.fibonacci(i));
        }
    }
}
