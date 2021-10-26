package com.codingdojo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Hobby;
import com.codingdojo.repositories.HobbyRepository;

@Service
public class HobbyService {
	private final HobbyRepository hobbyRepository;
	
	public HobbyService( HobbyRepository hobbyRepository ) {
		this.hobbyRepository = hobbyRepository;
	}
	
	public List<Hobby> getAllHobbies(){
		return hobbyRepository.findAll();
	}
}
