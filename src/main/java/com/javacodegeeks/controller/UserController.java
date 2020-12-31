package com.javacodegeeks.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacodegeeks.model.User;
import com.javacodegeeks.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	
	@Cacheable(value="users", key="#userId", unless= "#result.followers<12000")
	@GetMapping("/{userId}")
	public User findOne(@PathVariable("userId") Long userId) throws Exception {
		logger.info("Geeting user with id: {}", userId);
		return userService.findById(userId);
	}
}
