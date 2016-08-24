package com.sharar.mathfunctions;


public class Series {
    public long nSum(int n) {
        int i = 0;
        long sum = 0;
        while (i <= n) {
            sum += i;
            i++;
        }
        return sum;
    }

    public long factorial(int n) {
        int i = 1;
        long returned = 1;
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

    public long fibonacci(int n) {
        long returned = 0;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            long previous = 1;
            long secondPrevious = 0;
            long i = 2;
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
