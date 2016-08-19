package com.sharar;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.createBranch("branch");
        bank.listBranches();
        bank.getBranch("branch").createNewCustomerAtBranch("sharar",5000);
        bank.getBranch("branch").addTransactionToCustomer("sharar",2000);
        bank.getBranch("branch").ReturnCustomerTransactions("sharar");
        bank.getBranch("branch").listCustomersForBranch();
        bank.createBranch("wadoi");



    }
}
