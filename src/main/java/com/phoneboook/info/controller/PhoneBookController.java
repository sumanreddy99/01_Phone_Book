package com.phoneboook.info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phoneboook.info.model.Contact;
import com.phoneboook.info.service.PhoneBookService;

@RestController
public class PhoneBookController {

	@Autowired
	public PhoneBookService phoneBookService;

	
	@PostMapping(value = "/saveContact")
	public ResponseEntity<Object> saveContact(@RequestBody Contact contact) {
		String saveContact = phoneBookService.saveContact(contact);

		if (saveContact.equals("SUCCESS")) {

			return new ResponseEntity<Object>("Contact Inserted SuccessFully", HttpStatus.OK);
		} else {

		}
		return new ResponseEntity<Object>("Contact Insertion Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/getAllContacts")
	public List<Contact> getAllContaccts() {

		List<Contact> contacts = phoneBookService.getAllContaccts();
		if (contacts != null && !contacts.isEmpty()) {
			return contacts;
		} else
			return null;

	}

	
	@GetMapping(value = "/getContact/{contactId}")
	public Contact getContactById(@PathVariable("contactId") Integer contactId) {
		Contact contact = phoneBookService.getContactById(contactId);
		if (contact != null) {
			return contact;

		}
		return null;

	}

	@PatchMapping(value = "/updateContact")
	public ResponseEntity<Object> updateContact(@RequestBody Contact contact) {

		String updateContact = phoneBookService.updateContact(contact);
		if (updateContact.equals("SUCCESS")) {

			return new ResponseEntity<Object>("Contact Updated SuccessFully", HttpStatus.OK);
		} else {

		}
		return new ResponseEntity<Object>("Contact Updation Failed", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@DeleteMapping(value = "/deleteContact/{contactId}")
	public ResponseEntity<Object> deleteContactById(@PathVariable("contactId") Integer contactId) {

		String deleteContact = phoneBookService.deleteContactById(contactId);

		if (deleteContact.equals("SUCCESS")) {
			return new ResponseEntity<Object>("Contact Deleted SuccessFully", HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Contact Deleted SuccessFully", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
