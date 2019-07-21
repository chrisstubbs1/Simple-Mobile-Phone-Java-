package com.chrisstubbs;

import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static MobilePhone m1 = new MobilePhone("4787319279");
    private static boolean flag = true;

    public static void main(String[] args) {

        int userChoice;

        startPhone();
        while(flag) {
            System.out.println("\nEnter actions");
            printActions();

            userChoice = scan.nextInt();

            switch (userChoice){
                case 0:
                    m1.printContacts();
                    break;
                case 1:
                    addNewContact();
                    break;
                case 2:
                    removeContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    queryContact();
                    break;
                case 5:
                    shutDownPhone();
            }
        }
    }

    private static void startPhone(){
        System.out.println("Starting phone...");
    }

    private static void shutDownPhone(){
        System.out.println("Phone is shutting down... Goodbye!");
        flag = false;
    }

    private static void printActions(){
        System.out.println("\t0 - to print contacts\n" +
                            "\t1 - to add new contact\n" +
                            "\t2 - to remove contact\n"+
                            "\t3 - to update a contact\n" +
                            "\t4 - to query a contact\n" +
                            "\t5 - to shutdown phone");
    }

    private static void addNewContact(){
        System.out.println("Enter the contacts name");
        scan.nextLine();
        String name = scan.nextLine();
        System.out.println("Enter the contacts phone number");
        String number = scan.nextLine();

        Contacts newContact = Contacts.createContact(name, number);
        if(m1.addNewContact(newContact)){
            System.out.println("New contact added " + name + " " + number);
        }else{
            System.out.println("Cannot add, name already on file.");
        }
    }

    private static void updateContact(){
        System.out.println("Enter contact name");
        scan.nextLine();
        String name = scan.nextLine();
        Contacts existingContactRecord = m1.queryContacts(name);

        if(existingContactRecord == null){
            System.out.println("Contact does not exist");
            return;
        }

        System.out.println("Enter new contact name");
        String newName = scan.nextLine();
        System.out.println("New contact phone number");
        String newNumber = scan.nextLine();
        Contacts newContact = Contacts.createContact(newName,newNumber);
        if(m1.updateContact(existingContactRecord,newContact)){
            System.out.println("Successfully updated");
        }else{
            System.out.println("Update failed");
        }
    }

    public static void removeContact(){
        System.out.println("Enter contact name");
        scan.nextLine();
        String name = scan.nextLine();
        Contacts existingContactRecord = m1.queryContacts(name);

        if(existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }

        if(m1.removeContact(existingContactRecord)){
            System.out.println("Successfully deleted");
        }else{
            System.out.println("Error deleting contact");
        }
    }

    public static void queryContact(){
        System.out.println("Enter contact name");
        scan.nextLine();
        String name = scan.nextLine();
        Contacts existingContactRecord = m1.queryContacts(name);

        if(existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }else{
            System.out.println("Name ->" + existingContactRecord.getName() + " Phone number ->" +
                    existingContactRecord.getPhoneNumber());
        }


    }

}
