package com.snhu.contact;

import java.util.List;
import java.util.ArrayList;

// this class contains methods to modify created contact objects
public class ContactService {

	// array list to hold contacts
	public static List<Contact> contactList = new ArrayList<Contact>();

	// method to add contacts to list
	public void addContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {

		if (!(contactList.isEmpty())) {
			for (Contact contact : contactList) {
				if (contact.getContactId().equals(contactId)) {
					throw new IllegalArgumentException("Duplicate ID");
				}
			}
		}

		Contact contact = new Contact(contactId, firstName, lastName, phoneNumber, address);
		contactList.add(contact);

	}

	// method to delete existing contacts in the list
	public void deleteContact(String contactId) {

		// iterate through list until the searched id is found then removes it
		for (int i = 0; i < contactList.size(); i++) {
			Contact contact = contactList.get(i);
			if (contact.getContactId().equals(contactId)) {
				contactList.remove(i);
			}
		}
	}

	// method allows to update first name by contactId
	public void editFirstName(String contactId, String firstName) {
		for (int i = 0; i < contactList.size(); i++) {
			Contact contact = contactList.get(i);
			if (contact.getContactId().equals(contactId)) {
				contact.setFirstName(firstName);
			}
		}
	}

	// method allows to update last name by contactId
	public void editLastName(String contactId, String lastName) {
		for (int i = 0; i < contactList.size(); i++) {
			Contact contact = contactList.get(i);
			if (contact.getContactId().equals(contactId)) {
				contact.setLastName(lastName);
			}
		}
	}

	// method allows to update phone number by contactId
	public void editPhone(String contactId, String phoneNumber) {
		for (int i = 0; i < contactList.size(); i++) {
			Contact contact = contactList.get(i);
			if (contact.getContactId().equals(contactId)) {
				contact.setPhoneNumber(phoneNumber);
			}
		}
	}

	// method allows to update address by contactId
	public void editAddress(String contactId, String address) {
		for (int i = 0; i < contactList.size(); i++) {
			Contact contact = contactList.get(i);
			if (contact.getContactId().equals(contactId)) {
				contact.setAddress(address);
			}
		}
	}
}
