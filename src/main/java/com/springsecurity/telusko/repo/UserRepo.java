package com.springsecurity.telusko.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.telusko.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);

}
