package com.reminder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reminder.dao.UserDao;
import com.reminder.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

	public User getById(int id) {
		// TODO Auto-generated method stub
		return userDao.getById(id);
	}

	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		return userDao.saveUser(user);
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	public User validate(String emailId, String password) {
		// TODO Auto-generated method stub
		return userDao.validate(emailId, password);
	}

	public User getByemailId(String emailId) {
		// TODO Auto-generated method stub
		return userDao.getByemailId(emailId);
	}

}
