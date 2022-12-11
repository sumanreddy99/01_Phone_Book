package com.phoneboook.info.service;

import java.util.List;

import com.phoneboook.info.model.Contact;

public interface PhoneBookService {
	public String saveContact(Contact contact);
	public List<Contact> getAllContaccts();
	public Contact getContactById(Integer contactId);
	public String updateContact(Contact contact);
	public String deleteContactById(Integer contactId);
	

}
