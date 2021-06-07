package com.sec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Entity
@ToString
public @Data class User {
	
	
	
	public User() {
		
	}
	
	
	
	public User(int id) {
		super();
		this.id = id;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String password;
	private boolean ative;
	private String roles;
	
	

}
