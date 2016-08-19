package com.sharar;

/**
 * Created by sharararzukrahman on 8/14/16.
 */
public class Printer {
    private int tonerLevel = 0;
    private int numberOfPrintedSheets = 0;
    private boolean isDuplex;

    public Printer(int tonerLevel, int numberOfPrintedSheets, boolean isDuplex) {
        if (tonerLevel >= 0 && tonerLevel <= 100)
            this.tonerLevel = tonerLevel;
        else
            System.out.println("Invalid toner level, must be between 0 and 100. You must fill it up.");

        if (numberOfPrintedSheets >= 0)
            this.numberOfPrintedSheets = numberOfPrintedSheets;
        else System.out.println("Invalid number of pages");
        this.isDuplex = isDuplex;
    }

    public int getTonerLevel() {
        System.out.println("Toner level is " + tonerLevel);
        return tonerLevel;

    }

    public int getNumberOfPrintedSheets() {
        System.out.println(numberOfPrintedSheets + " printed sheets to date");
        return numberOfPrintedSheets;
    }

    public boolean isDuplex() {
        return isDuplex;
    }

    public void addToner(int tonerAdded) {
        if (this.tonerLevel >= 0)
            this.tonerLevel += tonerAdded;
        if (this.tonerLevel > 100)
            System.out.println("Toner added exceeds capacity, toner has been added till capacity");

    }

    public void printPage(int printedPages) {
        if (tonerDoesNotExceedCapacity(printedPages)) {
            if (this.isDuplex) {
                int duplexPrintedPages = checkOddForDuplex(printedPages);
                numberOfPrintedSheets += duplexPrintedPages;
            } else {
                numberOfPrintedSheets += printedPages;
            }
        } else {
            System.out.println("Add more toner");
        }

    }

    private boolean tonerDoesNotExceedCapacity(int tonerUsed) {
        if (tonerUsed > this.tonerLevel) {
            System.out.println("Toner required exceeds toner levels. Cancelling print");
            return false;
        } else {
            this.tonerLevel -= tonerUsed;
            return true;
        }

    }

    private int checkOddForDuplex(int printedPages) {
        if (printedPages % 2 == 0)
            return printedPages / 2;
        else {
            return ((int) printedPages / 2 + 1);
        }
    }

}
