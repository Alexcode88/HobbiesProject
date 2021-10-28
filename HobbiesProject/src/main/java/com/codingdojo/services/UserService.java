package com.codingdojo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.models.User;
import com.codingdojo.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	public UserService( UserRepository userRepository ) {
		this.userRepository = userRepository;
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

}
