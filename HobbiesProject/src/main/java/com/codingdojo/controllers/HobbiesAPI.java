package com.codingdojo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.models.Hobby;
import com.codingdojo.services.HobbyService;

@RestController
@RequestMapping ( value = "/api" )
public class HobbiesAPI {
	private final HobbyService hobbyService;
	
	public HobbiesAPI( HobbyService hobbyService ) {
		this.hobbyService = hobbyService;
	}
	
	@RequestMapping ( value = "/hobbies", method = RequestMethod.GET )
	public List<Hobby> getAllHobbies(){
		return hobbyService.getAllHobbies();
	}
}
