package com.sharar;

import java.util.ArrayList;

/**
 * Created by sharararzukrahman on 8/16/16.
 */
public class Bank {
    private ArrayList<Branch> branches;

    public Bank() {
        this.branches = new ArrayList<Branch>();
    }

    private int getBranchPositionFromName(String branchName) {
        for (int i = 0; i < this.branches.size(); i++) {
            if (this.branches.get(i).getBranchName().equals(branchName))
                return i;
        }
        return -1;
    }


    public Branch getBranch(String branchName) {
        int i = getBranchPositionFromName(branchName);
        Branch branch = this.branches.get(i);
        if (i >= 0) {
            return branch;
        } else {
            System.out.println("Branch does not exist");
            Branch emptyBranch = new Branch("empty");
            return branch;
        }

    }

    public void createBranch(String branchName) {
        Branch branch = new Branch(branchName);
        branches.add(branch);
    }


    public void listBranches() {
        ArrayList<Branch> branches = this.branches;
        System.out.println("List of branches: ");
        if (branches.size() != 0) {
            for (int i = 0; i < branches.size(); i++) {
                System.out.println(branches.get(i).getBranchName());
            }
        } else System.out.println("none");
    }

}



