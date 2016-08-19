package com.sharar;

import java.util.ArrayList;


public class MobilePhone {
    private ArrayList<Contacts> mobileContacts = new ArrayList<>();
    private ArrayList<String> mobileContactNames = new ArrayList<>();

    private void getContactNamesFromContacts() {
        //ArrayList<String> mobileContactNames = new ArrayList<String>();
        for (int i = 0; i < mobileContacts.size(); i++) {
            String string = mobileContacts.get(i).getContactName();
            mobileContactNames.add(i,string);
        }
        if (mobileContactNames.size() != mobileContacts.size()) {

        }
    }

    private void addContactToArrayList(Contacts contact) {
        String contactName = contact.getContactName();
        if ((getContactIndexWithName(contactName)) <0)
            mobileContacts.add(contact);
        else System.out.println("Contact already exists");
    }

    public void addContact(String contactName, String contactNumber) {
        Contacts contact = new Contacts(contactName, contactNumber);
        addContactToArrayList(contact);
    }


    public void displayContactList() {
        System.out.println("Here is a list of your " + mobileContacts.size() + " contacts:");
        for (int i = 0; i < mobileContacts.size(); i++) {
            Contacts contact = mobileContacts.get(i);
            System.out.println("Name: " + contact.getContactName() + "\t Number: " + contact.getContactNumber());
        }
    }

    public void modifyName(String oldName, String newName) {
        int i = getContactIndexWithName(oldName);
        if (i >= 0) {
            Contacts contact = mobileContacts.get(i);
            contact.setContactName(newName);
        } else System.out.println("Contact not found by modifyname");
    }

    public void modifyPhoneNumber(String contactName, String newPhoneNumber) {
        int i = getContactIndexWithName(contactName);
        if (i >= 0) {
            Contacts contact = mobileContacts.get(i);
            contact.setContactNumber(newPhoneNumber);
        } else System.out.println("Contact not found by phonenumber");

    }

    private int getContactIndexWithName(String contactName) {
        if (mobileContacts.size() > 0) {
            getContactNamesFromContacts();
            return mobileContactNames.indexOf(contactName);
        } else return -1;
    }

    public void removeContact(String contactName) {
        int contactIndexWithName = getContactIndexWithName(contactName);
        if (contactIndexWithName >= 0) {
            mobileContacts.remove(contactIndexWithName);
        } else System.out.println("Contact not found");
    }


}
