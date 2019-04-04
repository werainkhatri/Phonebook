package com.applications.werainkhatri.phonebook;

import java.util.ArrayList;

class ContactList {

    private static ArrayList<Contact> contacts = new ArrayList<>();

    public ContactList() {

    }

    public static void addContact(String name, String number) {
        contacts.add(new Contact(name, number));
    }

    public static ArrayList<Contact> getContacts() {
        return contacts;
    }

}
