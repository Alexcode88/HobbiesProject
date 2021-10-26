package com.codingdojo.services;

import java.util.List;
import java.util.Optional;

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
	
	public Hobby getHobbyById( int id ) {
		Optional<Hobby> optionalHobby = hobbyRepository.findByIdentifier( id );
		if ( optionalHobby.isPresent() ) {
			return optionalHobby.get();
		}
		else {
			return null;
		}
	}
	
	public Hobby updateHobby( Hobby hobby ) {
		return hobbyRepository.save( hobby );
	}
	
	public Hobby createHobby( Hobby hobby ) {
		return hobbyRepository.save( hobby );
	}
}
