package com.durga.exam.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durga.exam.model.User;
import com.durga.exam.model.UserRole;
import com.durga.exam.repo.RoleRepository;
import com.durga.exam.repo.UserRepository;
import com.durga.exam.service.UserService;


@Service

public class UserServiceImpl implements UserService{
	
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		
		User local  = this.userRepository.findByUsername(user.getUsername());
		if(local!= null)
		{
			System.out.println("User is already there !!");
			throw new Exception("User already present !!");
		}
		else {
			//user create
			for(UserRole ur:userRoles)
			{
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;
	}

    //getting user by username
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
		
	}
	

}
