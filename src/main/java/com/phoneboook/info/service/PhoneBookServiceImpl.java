package com.phoneboook.info.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoneboook.info.model.Contact;
import com.phoneboook.info.repository.PhoneBookRepository;
@Service
public class PhoneBookServiceImpl implements PhoneBookService {

	@Autowired
	public PhoneBookRepository phoneBookRepository;

	@Override
	public String saveContact(Contact contact) {

		contact = phoneBookRepository.save(contact);

		if (contact.getId() != null) {
			return "SUCCESS";
		} else {

			return "Failed";
		}
	}

	@Override
	public Contact getContactById(Integer contactId) {

		Optional<Contact> contact = phoneBookRepository.findById(contactId);

		if (contact.isPresent()) {
			return contact.get();
		}

		return null;
	}

	@Override
	public String updateContact(Contact contact) {

		if (phoneBookRepository.existsById(contact.getId())) {

			phoneBookRepository.save(contact);

			return "SUCCESS";
		} else {

			return "no record found";
		}
	}

	@Override
	public String deleteContactById(Integer contactId) {

		if (phoneBookRepository.existsById(contactId)) {

			phoneBookRepository.deleteById(contactId);
			return " SUCCESS";
		}
		return "record not found";
	}

	@Override
	public List<Contact> getAllContaccts() {

		return phoneBookRepository.findAll();
	}

}
