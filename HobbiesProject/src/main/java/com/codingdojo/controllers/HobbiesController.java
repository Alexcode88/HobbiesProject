package com.codingdojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.models.Hobby;
import com.codingdojo.services.HobbyService;

@Controller
public class HobbiesController {
	private final HobbyService hobbyService;
	
	public HobbiesController( HobbyService hobbyService ) {
		this.hobbyService = hobbyService;
	}
	
	@RequestMapping( value = "/hobbies", method = RequestMethod.GET )
	public String displayHobbies( @ModelAttribute("hobby") Hobby hobby, Model model ) {
		List<Hobby> hobbyList = hobbyService.getAllHobbies();
		
		model.addAttribute( "hobbyList", hobbyList );
		
		return "hobbies.jsp";
	}
	
	@RequestMapping( value = "/hobbies/update", method = RequestMethod.POST )
	public String updateHobby( @RequestParam( value = "identifier" ) int identifier, 
							   @RequestParam( value = "name" ) String name,
							   RedirectAttributes redirectAttributes) {
		
		Hobby currentHobby = hobbyService.getHobbyById( identifier );
		if ( currentHobby == null ) {
			redirectAttributes.addFlashAttribute( "errorMessage", "That hobby identifier doesn't exist." );
		}
		else {
			currentHobby.setName( name );
			hobbyService.updateHobby( currentHobby );
		}
		
		return "redirect:/hobbies";
	}
	
	@RequestMapping( value = "/hobbies/create", method = RequestMethod.POST )
	public String createHobby( @Valid @ModelAttribute( "hobby" ) Hobby hobby,
							   BindingResult result,
							   RedirectAttributes redirectAttributes ) {
		
		if ( result.hasErrors() ) {
			return "hobbies.jsp";
			//redirectAttributes.addFlashAttribute( "errorMessage", "You need to provide the identifier. The name must be lesser than 100 characters long!" );
		}
		else {
			Hobby currentHobby = hobbyService.getHobbyById( hobby.getIdentifier() );
			
			if( currentHobby == null ) {
				hobbyService.createHobby( hobby );
			}else {
				redirectAttributes.addFlashAttribute( "errorMessage", "That hobby identifier belongs to another hobby." );
			}
			
		}
		
		return "redirect:/hobbies";
	}
	
	
}
