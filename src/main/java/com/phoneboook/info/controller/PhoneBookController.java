package com.phoneboook.info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phoneboook.info.model.Contact;
import com.phoneboook.info.service.PhoneBookService;

@RestController
public class PhoneBookController {

	@Autowired
	private PhoneBookService phoneBookService;

	@RequestMapping(value = "/getAllContacts", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllContaccts() {

		List<Contact> contacts = phoneBookService.getAllContaccts();
		if (contacts != null && !contacts.isEmpty()) {
			return new ResponseEntity<Object>("All Contacts Retrieve SuccessFully ", HttpStatus.OK);

		}
		return new ResponseEntity<Object>("Failed To Retrieve All Contacts", HttpStatus.BAD_REQUEST);

	}

	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ResponseEntity<Object> saveContact(@RequestBody Contact contact) {
		String saveContact = phoneBookService.saveContact(contact);

		if (saveContact.equals("SUCCESS")) {

			return new ResponseEntity<Object>("Contact Inserted SuccessFully", HttpStatus.OK);
		} else {

		}
		return new ResponseEntity<Object>("Contact Insertion Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/getContact/{contactId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getContactById(@PathVariable("contactId") Integer contactId) {
		Contact contact = phoneBookService.getContactById(contactId);
		if (contact != null) {
			return new ResponseEntity<Object>("Contact Retrieve SuccessFully ", HttpStatus.OK);

		}
		return new ResponseEntity<Object>("Failed To Retrieve Contact", HttpStatus.BAD_REQUEST);

	}

	@RequestMapping(value = "/updateContact", method = RequestMethod.PATCH)
	public ResponseEntity<Object> updateContact(@RequestBody Contact contact) {

		String updateContact = phoneBookService.updateContact(contact);
		if (updateContact.equals("SUCCESS")) {

			return new ResponseEntity<Object>("Contact Updated SuccessFully", HttpStatus.OK);
		} else {

		}
		return new ResponseEntity<Object>("Contact Updation Failed", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@RequestMapping(value = "/deleteContact/{contactId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteContactById(@PathVariable("contactId") Integer contactId) {

		String deleteContact = phoneBookService.deleteContactById(contactId);

		if (deleteContact.equals("SUCCESS")) {
			return new ResponseEntity<Object>("Contact Deleted SuccessFully", HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Contact Deleted SuccessFully", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
