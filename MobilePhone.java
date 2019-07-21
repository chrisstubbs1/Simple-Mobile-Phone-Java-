package com.chrisstubbs;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contacts> contactList;
    private String myNumber;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contactList = new ArrayList<>();
    }

    private String getMyNumber() {
        return myNumber;
    }

    public void printContacts() {
        int i = 0;
        System.out.println("Contact List:");
        for (Contacts element : contactList) {
            System.out.println((i + 1) + ". " + element.getName() + " \t " +
                    element.getPhoneNumber());
            i++;
        }
        System.out.println();
    }

    public boolean addNewContact(Contacts contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already exists");
            return false;
        }

        contactList.add(contact);
        return true;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + " was not found");
            return false;
        }
        this.contactList.set(foundPosition, newContact);
        System.out.println("Old contact " + oldContact.getName() + " was replaces with "
                + newContact.getName());

        return true;
    }

    public boolean removeContact(Contacts contact) {
        int foundPosition = findContact(contact);
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already exists");
            return false;
        }

        contactList.remove(foundPosition);
        return true;
    }

    private int findContact(Contacts contact) {
        return this.contactList.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.contactList.size(); i++) {
            Contacts contact = this.contactList.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contacts contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contacts queryContacts(String name){
        int position = findContact(name);

        if(position >= 0){
            return this.contactList.get(position);
        }
        return null;
    }
}
