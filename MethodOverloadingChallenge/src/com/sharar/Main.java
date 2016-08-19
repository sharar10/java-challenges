package com.sharar;

public class Main {

    public static void main(String[] args) {
       // System.out.println(calcFeetAndInchesToCentimeters(1,12));
        System.out.println(calcFeetAndInchesToCentimeters(55));

    }

    public static double calcFeetAndInchesToCentimeters(int feet, int inches) {
        double centimeters;
        if ((feet >= 0) && (inches >= 0) && (inches < 12)) {
            centimeters = (feet * 30.48) + (inches * 2.54);
            return centimeters;
        } else {
            System.out.println("Invalid input parameters");
            return -1;
        }
    }

    public static double calcFeetAndInchesToCentimeters(int inches) {
        if (inches >= 0) {
            int feet = (inches / 12);
            inches = (inches % 12);
            return calcFeetAndInchesToCentimeters(feet, inches);
        } else {
            return -1;
        }
    }

}
