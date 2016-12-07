package com.reminder.service;

import java.util.List;

import com.reminder.model.User;

public interface UserService {

List<User> getAllUsers();
	
	User getById(String id);
	
	User getByemailId(String emailId);
	
	boolean saveUser(User user);
	
	boolean updateUser(User user);
	
	User validate(String emailId, String password);
	
}
