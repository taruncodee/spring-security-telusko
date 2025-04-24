package com.springsecurity.telusko.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.telusko.model.User;
import com.springsecurity.telusko.model.UserPrincipal;
import com.springsecurity.telusko.repo.UserRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
	
	private UserRepo repo ;
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		
		if(user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("User not found");
		}
		
		return new UserPrincipal(user);
	}

}
