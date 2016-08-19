package com.sharar;

import java.util.Scanner;

public class Main {

    ///WE CAN COMBINE 3 and 4 together!!!!!! using scanner input


    private static Scanner scanner = new Scanner(System.in);

    private static MobilePhone myPhone = new MobilePhone();

    public static void main(String[] args) {
        boolean running = true;
        int state =0;
        showInstructions();


        while (running) {
            System.out.println("myPhone started up, choose a command: ");
            state = scanner.nextInt();
            scanner.nextLine();
            switch (state) {
                case 0: //display commands
                    showInstructions();
                    break;
                case 1: // display contacts
                    myPhone.displayContactList();
                    break;
                case 2: //add contacts
                    addContact();
                    break;
                case 3: //modify contactName
                    modifyContactName();
                    break;
                case 4: //modify contactNumber
                    modifyContactNumber();
                    break;
                case 5: //remove contacts
                    removeContact();
                    break;
                case 6: //quit
                    running = false;
                    break;

            }

        }

    }

    public static void showInstructions() {
        System.out.println("Press 0 to show instructions");
        System.out.println("Press 1 to display all contacts");
        System.out.println("Press 2 to add a contact");
        System.out.println("Press 3 to modify a contact name");
        System.out.println("Press 4 to modify a contact phone number");
        System.out.println("Press 5 to remove a contact");
        System.out.println("Press 6 to quit this program");

    }

    public static void addContact() {
        System.out.println("Please enter a contact name: ");
        String contactName = scanner.nextLine();
        System.out.println("Please enter a contact phone number: ");
        String contactNumber = scanner.nextLine();
        myPhone.addContact(contactName,contactNumber);

    }

    public static void modifyContactName() {
        System.out.println("Please enter the contact who's name you wish to modify");
        String oldName = scanner.nextLine();
        System.out.println("Please enter the new name for " + oldName + ": ");
        String newName = scanner.nextLine();
        myPhone.modifyName(oldName,newName);

    }

    public static void modifyContactNumber() {
        System.out.println("Please enter the contact who's number you wish to modify");
        String name = scanner.nextLine();
        System.out.println("Please enter a new number for " + name);
        String newNumber = scanner.nextLine();
        myPhone.modifyPhoneNumber(name, newNumber);

    }

    public static void removeContact() {
        System.out.println("Please enter the contact you wish to remove: ");
        String contactName = scanner.nextLine();
        myPhone.removeContact(contactName);

    }


}
