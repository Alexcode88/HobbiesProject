package com.codingdojo.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.codingdojo.models.User;

public interface UserRepository extends Repository<User, Long>{
	List<User> findAll(); // SELECT * FROM users
}
