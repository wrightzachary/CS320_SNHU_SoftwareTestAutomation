package com.snhu.contact.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.snhu.contact.Contact;

class ContactTest {

	// test to create a contact
	@Test
	public void testCreateContact() {
        String contactId = "123456789";
      	String firstName = "Zach";
        String lastName = "Wright";
        String phoneNumber = "1234567890";
        String address = "42 somewhere rd texas";
        
		
		Contact test = new Contact(contactId, firstName, lastName, phoneNumber, address);
			
		assertEquals(test.getContactId(), contactId);
		assertEquals(test.getFirstName(), firstName);
		assertEquals(test.getLastName(), lastName);
		assertEquals(test.getPhoneNumber(), phoneNumber);
		assertEquals(test.getAddress(), address);
			
	}
	
	// test that user id is too long
	@Test
	public void testUserIdIsTooLong() {
		
		String contactId = "12345678909";
      	String firstName = "Zach";
        String lastName = "Wright";
        String phoneNumber = "1234567890";
        String address = "42 some rd texas";
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}
	
	// test if user id is null
	@Test
	public void testIfUserIdIsNull() {
		
		String contactId = null;
      	String firstName = "Zach";
        String lastName = "Wright";
        String phoneNumber = "1234567890";
        String address = "42 some rd texas";
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}

	// test to set first name
	@Test
	public void testSetFirstName() {
		String contactId = "123456789";
      	String firstName = "Zach";
        String lastName = "Wright";
        String phoneNumber = "1234567890";
        String address = "42 some rd texas";
        
		Contact contact = new Contact(contactId, firstName, lastName, phoneNumber, address);
			
		String setFirstName = "Zachary";
		String setLastName = "Wright";
		String setPhoneNumber = "1234567890";
		String setAddress = "24 some rd texas";
	        
		contact.setFirstName(setFirstName);
		contact.setLastName(setLastName);
		contact.setPhoneNumber(setPhoneNumber);
		contact.setAddress(setAddress);
	        
		assertEquals(contact.getFirstName(), setFirstName);
		assertEquals(contact.getLastName(), setLastName);
		assertEquals(contact.getPhoneNumber(), setPhoneNumber);
		assertEquals(contact.getAddress(), setAddress);
	}

	// test if first name is null
	@Test
	public void testIfFirstNameIsNull() {
		
		String contactId = "123456789";
		String firstName = null;
		String lastName = "Wright";
		String phoneNumber = "1234567890";
		String address = "42 some rd texas";
    
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}
	
	// test if first name is too long
	@Test
	public void testFirstNameTooLong() {
		
		String contactId = "123456789";
		String firstName = "WhyIsMyNameSoLong";
		String lastName = "Wright";
		String phoneNumber = "1234567890";
		String address = "42 some rd texas";
        
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
		
	}
	
	// test if last name is too long
	@Test
	public void testIfLastNameIsTooLong() {
		
		String contactId = "123456789";
      	String firstName = "Zach";
        String lastName = "WhyIsMyNameSoLong";
        String phoneNumber = "1234567890";
        String address = "42 some rd texas";
        
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}
	
	// test if last name is null
	@Test
	public void testIfLastNameIsNull() {
		
		String contactId = "123456789";
      	String firstName = "Zach";
        String lastName = null;
        String phoneNumber = "1234567890";
        String address = "42 some rd texas";
        
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}
	
	// test if phone number is too long
	@Test
	public void testIfPhoneNumberIsTooLong() {
		
		String contactId = "123456789";
      	String firstName = "Zach";
        String lastName = "Wright";
        String phoneNumber = "12345678909" ;
        String address = "42 some rd texas";
        
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}
	
	// test if phone number is too short
	@Test
	public void testIfPhoneNumberIsTooShort() {
		
		String contactId = "123456789";
      	String firstName = "Zach";
        String lastName = "Wright";
        String phoneNumber = "123456789" ;
        String address = "42 some rd texas";
        
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}
	
	// test if phone number is null
	@Test
	public void testIfPhoneNumberISNull() {
		
		String contactId = "123456789";
      	String firstName = "Zach";
        String lastName = "Wright";
        String phoneNumber = null;
        String address = "42 some rd texas";
        
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}
	
	// test if address is too long
	@Test
	public void testIfAddressIsTooLong() {
		String contactId = "123456789";
      	String firstName = "Zach";
        String lastName = "Wright";
        String phoneNumber = "1234567890";
        String address = "WhyIsMyAddressSoLongLikeWhyCanItNotBeShortINeedToMove";
        
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
		
	}
	
	// test to see if address is null
	@Test
	public void testIfAddressIsNull() {
		String contactId = "123456789";
      	String firstName = "Zach";
        String lastName = "Wright";
        String phoneNumber = "1234567890";
        String address = null;
        
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
		
	}
	
}