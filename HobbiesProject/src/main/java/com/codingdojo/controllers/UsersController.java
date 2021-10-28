package com.codingdojo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.models.User;
import com.codingdojo.services.UserService;

@Controller
public class UsersController {
	private final UserService userService;
	
	public UsersController( UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping( value = "/users", method = RequestMethod.GET )
	public String displayUsers( Model model ) {
		List<User> userList = userService.getAllUsers();
		model.addAttribute( "userList", userList );
		return "users.jsp";
		
	}
}
