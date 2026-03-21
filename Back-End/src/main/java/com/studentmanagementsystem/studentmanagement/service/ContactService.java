package com.studentmanagementsystem.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagementsystem.studentmanagement.entity.Contact;
import com.studentmanagementsystem.studentmanagement.repository.Contactrepository;
@Service
public class ContactService {
	@Autowired
	public Contactrepository contactrepository;
	
	public Contact addcontact(Contact contact) {
		return contactrepository.save(contact);
	}

	
	public List<Contact> getAllContacts() {
	    return contactrepository.findAll();
	}

	
	public void deleteContact(int cid) {
	    contactrepository.deleteById(cid);
	}

}
