package com.phoneboook.info.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "phonebook")
@Data
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "mailId")
	private String mailId;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	
	
	public Contact() {
	
	}
	
		
	

}
