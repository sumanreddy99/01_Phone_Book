package com.phoneboook.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoneboook.info.model.Contact;

public interface PhoneBookRepository extends JpaRepository<Contact, Integer> {

}
