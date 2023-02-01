package com.durga.exam.service;

import java.util.Set;

import com.durga.exam.model.User;
import com.durga.exam.model.UserRole;

public interface UserService {
	
	//creating User
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	//get User by username
	public User getUser(String username);
	
	//get delete user by id
	public void deleteUser(Long userId);

}
