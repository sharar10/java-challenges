package com.sharar.mathfunctions;


public class Series {
    public int nSum(int n) {
        int i = 0;
        int sum = 0;
        while (i <= n) {
            sum += i;
            i++;
        }
        return sum;
    }

    public int factorial(int n) {
        int i = 1;
        int returned = 1;
        if (n == 1) {
            return 1;
        } else {
            while (i <= n) {
                returned *= i;
                i++;
            }
        }
        return returned;
    }

    public int fibonacci(int n) {
        int returned = 0;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int previous = 1;
            int secondPrevious = 0;
            int i = 2;
            while (i <= n) {
                returned = previous + secondPrevious;
                secondPrevious = previous;
                previous = returned;
                i++;
            }
        }
        return returned;
    }

}
