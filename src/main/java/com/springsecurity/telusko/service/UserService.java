package com.springsecurity.telusko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.telusko.model.User;
import com.springsecurity.telusko.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;

	public User register(User user) {
		return userRepo.save(user);
	}
}
