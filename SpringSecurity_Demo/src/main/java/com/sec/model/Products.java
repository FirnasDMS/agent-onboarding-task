package com.sec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Entity
@ToString
public@Data class Products {
	
	
	
	public Products() {
		super();
	}
	
	
	public Products(int id) {
		super();
		this.id = id;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String productName;

}
