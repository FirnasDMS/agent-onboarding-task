package com.sec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sec.model.Products;
import com.sec.repo.ProductRepo;

@Service
public class ProductService {
	

	@Autowired
 	ProductRepo productRepo;

	public void addProducts(Products products) {
		// TODO Auto-generated method stub
		productRepo.save(products);
	}

	public List<Products> findAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}
}
