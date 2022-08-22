package com.snhu.contact.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.snhu.contact.ContactService;

class ContactServiceTest {

	// clear the array list after each test 
	@AfterEach
	void tearDown() throws Exception {
		ContactService.contactList.removeAll(ContactService.contactList);
	}
	
	// tests the creation and addition of a new contact object
	@Test
	public void testAddContact() {
		String contactId = "123456789";
		String firstName = "Zach";
		String lastName = "Wright";
		String phoneNumber = "1234567890";
		String address = "42 some rd texas";
		
		ContactService test = new ContactService();
		test.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		assertTrue(!(ContactService.contactList.isEmpty()));
		assertEquals(ContactService.contactList.get(0).getContactId(), "123456789");
		assertEquals(ContactService.contactList.get(0).getFirstName(), "Zach");
		assertEquals(ContactService.contactList.get(0).getLastName(), "Wright");
		assertEquals(ContactService.contactList.get(0).getPhoneNumber(), "1234567890");
		assertEquals(ContactService.contactList.get(0).getAddress(), "42 some rd texas");
	}
	
	// test to make sure two contacts cannot have same id
	@Test
	public void testDuplicateId() {
		
		ContactService contactService = new ContactService();
		contactService.addContact("123456789", "Zach", "Wright", "1234567890", "42 some rd texas");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact("123456789", "Chani", "Wright", "1234567890", "42 some rd texas");
		});
		
	}
	
	//test to make sure existing contact objects can be deleted
	@Test
	public void testDeleteContact() {
		String contactId = "123456789";
		String firstName = "Zach";
		String lastName = "Wright";
		String phoneNumber = "1234567890";
		String address = "42 some rd texas";
		
		ContactService contactService = new ContactService();
		contactService.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		assertTrue(!(ContactService.contactList.isEmpty()));
		
		if (!(ContactService.contactList.isEmpty())) {
			contactService.deleteContact(contactId);
		}
		
		assertTrue(ContactService.contactList.isEmpty());
	}
	
	// test to update first name
	@Test
	public void testEditFirstName() {
		String contactId = "123456789";
		String firstName = "Zach";
		String lastName = "Wright";
		String phoneNumber = "1234567890";
		String address = "42 some rd texas";
		
		ContactService contactService = new ContactService();
		contactService.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String updatedName = "Zachary";
		contactService.editFirstName(contactId, updatedName);
		
		//assert the first name attribute of the contact object was updated
		assertEquals(ContactService.contactList.get(0).getFirstName(), "Zachary");
		
	}
	
	// test for updating a name that is too long
	@Test
	public void testEditFirstName_TooLong() {
		String contactId = "123456789";
		String firstName = "Zach";
		String lastName = "Wright";
		String phoneNumber = "1234567890";
		String address = "42 some rd texas";
		
		ContactService contactService = new ContactService();
		contactService.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String updatedName = "WhyIsMyNameSoLong";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.editFirstName("123456789", updatedName);
		});
	}
	
	// test to edit last name
	@Test
	public void testEditLastName() {
		String contactId = "123456789";
		String firstName = "Zach";
		String lastName = "Wright";
		String phoneNumber = "1234567890";
		String address = "42 some rd texas";
		
		ContactService contactService = new ContactService();
		contactService.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String updatedLastName = "Puryear";
		contactService.editLastName(contactId, updatedLastName);
		
		assertEquals(ContactService.contactList.get(0).getLastName(), "Puryear");
	}

	// test to update phone number
	@Test
	public void testEditPhoneNumber() {
		String contactId = "123456789";
		String firstName = "Zach";
		String lastName = "Wright";
		String phoneNumber = "1234567890";
		String address = "42 some rd texas";
		
		ContactService contactService = new ContactService();
		contactService.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String updatedPhoneNumber = "0123456789";
		contactService.editPhone(contactId, updatedPhoneNumber);
		
		assertEquals(ContactService.contactList.get(0).getPhoneNumber(), updatedPhoneNumber);
	}
	
	// test to update address
	@Test
	public void testEditAddress() {
		String contactId = "123456789";
		String firstName = "Zach";
		String lastName = "Wright";
		String phoneNumber = "1234567890";
		String address = "42 somewhere rd texas";
		
		ContactService contactService = new ContactService();
		contactService.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String updatedAddress = "24 somewhere rd texas";
		contactService.editAddress(contactId, updatedAddress);
		
		assertEquals(ContactService.contactList.get(0).getAddress(), updatedAddress);
	}
}