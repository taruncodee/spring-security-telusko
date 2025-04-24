package com.springsecurity.telusko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.springsecurity.telusko.model.User;
import com.springsecurity.telusko.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private AuthenticationManager authManager;

	public User register(User user) {
		return userRepo.save(user);
	}
	
	public String verify(User user) {
		Authentication authentication = 
				authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authentication.isAuthenticated())
				return jwtService.generateToken(user.getUsername());
		return "Fail";
	}
}
