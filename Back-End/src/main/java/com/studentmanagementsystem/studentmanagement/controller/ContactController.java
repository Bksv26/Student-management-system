package com.studentmanagementsystem.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagementsystem.studentmanagement.entity.Contact;
import com.studentmanagementsystem.studentmanagement.repository.Contactrepository;
import com.studentmanagementsystem.studentmanagement.service.ContactService;

@RestController
@RequestMapping("/contact")
@CrossOrigin("http://localhost:3000")
public class ContactController {

	    @Autowired
	    private Contactrepository contactrepository;
	    @Autowired
	    private ContactService contactservice;

	    @PostMapping("/save")
	    public Contact saveContact(@RequestBody Contact contact) {
	    	 return contactservice.addcontact(contact);
	    }
	    @GetMapping("/all")
	    public List<Contact> getAllContacts() {
	        return contactservice.getAllContacts();
	    }
	    @DeleteMapping("/delete/{cid}")
	    public String deleteContact(@PathVariable int cid) {
	        contactservice.deleteContact(cid);
	        return "Deleted successfully";
	    }


	}


