package com.sec.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "products",cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Customers> customers;
}
