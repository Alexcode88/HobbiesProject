package com.codingdojo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.codingdojo.models.Hobby;

public interface HobbyRepository extends Repository<Hobby, Long>{
	List<Hobby> findAll(); // SELECT * FROM hobbies
	Optional<Hobby> findByIdentifier( int id ); // SELECT * FROM hobbies WHERE identifier=id
	Hobby save( Hobby hobby );
	//Long deleteByIdentifier( int id ); // DELETE FROM hobbies WHERE identifier = id
}