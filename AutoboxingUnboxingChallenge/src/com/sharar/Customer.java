package com.sharar;

import java.util.ArrayList;

public class Customer {
    private String customerName;
    private ArrayList<Double> transactions = new ArrayList<>();

    public Customer(String customerName) {
        this.customerName = customerName;
        this.transactions = new ArrayList<Double>();
    }

    public Customer(String customerName, double initialAmount) {
        this.customerName = customerName;
        this.transactions = new ArrayList<>();
        transactions.add(initialAmount);
    }

    public String getCustomerName() {
        return this.customerName;
    }

    private ArrayList<Double> getTransactions() {
        return this.transactions;
    }


    public void addTransaction(double amount) {
        this.transactions.add(amount);
    }

    public void printTransactions() {
        ArrayList<Double> transactions = getTransactions();
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println("Transaction " + (i + 1) + " was " + transactions.get(i).doubleValue());
        }
    }
}
