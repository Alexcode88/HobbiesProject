package com.codingdojo.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.codingdojo.models.Hobby;

public interface HobbyRepository extends Repository<Hobby, Long>{
	List<Hobby> findAll(); // SELECT * FROM hobbies
}
