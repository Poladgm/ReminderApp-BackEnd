package com.reminder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reminder.dao.contactDao;
import com.reminder.model.contactUs;

@Service
public class contactServiceImpl implements contactService {

	@Autowired
	private contactDao contactDao;

	public contactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(contactDao contactDao) {
		this.contactDao = contactDao;
	}

	public boolean saveContact(contactUs contactUs) {
		// TODO Auto-generated method stub
		return contactDao.saveContact(contactUs);
	}

}
