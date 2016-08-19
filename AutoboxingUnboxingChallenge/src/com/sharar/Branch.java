package com.sharar;

import java.util.ArrayList;


public class Branch {
    private String branchName;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return branchName;
    }

    public void createNewCustomerAtBranch(String customerName, double amount) {
        if (customerDoesNotExist(customerName)) {
            Customer customer = new Customer(customerName, amount);
            this.customers.add(customer);
        } else System.out.println("Customer already exists");

        return;
    }

    private boolean customerDoesNotExist(String customerNameToCheck) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (customerNameToCheck == customers.get(i).getCustomerName()) {
                return false;
            }

        }
        return true;
    }

    public void listCustomersForBranch() {
        ArrayList<Customer> customers = this.customers;
        System.out.println("Branch " + this.branchName + " has the following customers: ");
        if (this.customers.size() != 0) {
            for (int i = 0; i < customers.size(); i++) {
                System.out.println(customers.get(i).getCustomerName());
            }
        } else System.out.println("none");
    }

    public void ReturnCustomerTransactions(String customerName) {
        System.out.println("Here are the transactions for customer " + customerName);
        int i = getPositionFromName(customerName);
        if (i >= 0)
            this.customers.get(i).printTransactions();
        else System.out.println("Customer does not exist");
    }

    private int getPositionFromName(String customerName) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).getCustomerName().equals(customerName))
                return i;
        }
        return -1;
    }

    public void addTransactionToCustomer(String customerName, double amount) {
        int i = getPositionFromName(customerName);
        if (i >= 0)
            this.customers.get(i).addTransaction(amount);
        else System.out.println("Customer does not exist");
    }

}
