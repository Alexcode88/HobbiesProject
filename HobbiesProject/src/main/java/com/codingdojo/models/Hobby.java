package com.codingdojo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table( name = "hobbies" )
public class Hobby {
	
	@Id
	@NotNull
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int identifier;

	@NotNull
	@Size( max = 100 )
	private String name;
	
	@JsonManagedReference
	@OneToMany( mappedBy = "hobby", fetch = FetchType.LAZY )
	private List<User> users;
	
	public Hobby() {}

	public Hobby( int identifier, String name ) {
		this.identifier = identifier;
		this.name = name;
	}
	
	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
