package com.reminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reminder.model.contactUs;
import com.reminder.service.contactService;

@RestController
public class contactController {

	@Autowired
	private contactService contactService;
	@Autowired
	private contactUs contact;

	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public ResponseEntity<contactUs> addContact(@RequestBody contactUs contact) {
		System.out.println("starting save contact");
		contactService.saveContact(contact);
		return new ResponseEntity<contactUs>(HttpStatus.OK);
	}
}
