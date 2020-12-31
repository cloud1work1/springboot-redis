package com.javacodegeeks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.javacodegeeks.model.User;
import com.javacodegeeks.service.UserService;

@SpringBootApplication
@EnableCaching
public class RedisSbApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(RedisSbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Shubham", 2000);
		userService.save(user);
		 user = new User("Pankaj", 29000);
			userService.save(user);
			 user = new User("Lewis", 550);
				userService.save(user);
	}

}
