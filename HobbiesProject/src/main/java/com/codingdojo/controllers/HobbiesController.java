package com.codingdojo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.models.Hobby;
import com.codingdojo.services.HobbyService;

@Controller
public class HobbiesController {
	private final HobbyService hobbyService;
	
	public HobbiesController( HobbyService hobbyService ) {
		this.hobbyService = hobbyService;
	}
	
	@RequestMapping( value = "/hobbies", method = RequestMethod.GET )
	public String displayHobbies( Model model ) {
		List<Hobby> hobbyList = hobbyService.getAllHobbies();
		
		model.addAttribute( "hobbyList", hobbyList );
		
		return "hobbies.jsp";
	}
}
