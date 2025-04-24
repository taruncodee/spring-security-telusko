package com.springsecurity.telusko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.telusko.model.User;
import com.springsecurity.telusko.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userService.register(user);
	}
	
}
