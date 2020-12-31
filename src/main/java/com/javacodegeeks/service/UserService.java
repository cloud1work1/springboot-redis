package com.javacodegeeks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacodegeeks.model.User;
import com.javacodegeeks.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User findById(long id) throws Exception {
		return userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
}
