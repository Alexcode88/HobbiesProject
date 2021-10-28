package com.codingdojo.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table( name = "users" )
public class User {
	@Id
	@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size( max = 100 )
	private String firstname;
	
	@NotNull
	@Size( max = 100 )
	private String lastname;
	
	@JsonBackReference
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "hobby_identifier" )
	private Hobby hobby;
	
	public User() {}

	public User( String firstname, String lastname, Hobby hobby ) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Hobby getHobby() {
		return hobby;
	}

	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}
	
	
}
