package com.codingdojo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name = "hobbies" )
public class Hobby {
	
	@Id
	@NotNull
	private int identifier;

	@NotNull
	@Size( max = 100 )
	private String name;
	
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
}
