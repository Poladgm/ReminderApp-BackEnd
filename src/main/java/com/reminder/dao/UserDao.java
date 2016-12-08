package com.reminder.dao;

import java.util.List;

import com.reminder.model.User;

public interface UserDao {

	List<User> getAllUsers();
	
	User getById(int id);
	
	User getByemailId(String emailId);
	
	boolean saveUser(User user);
	
	boolean updateUser(User user);
	
	User validate(String emailId, String password);
	
	
}
