package com.sec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sec.model.Products;
import com.sec.service.ProductService;

import antlr.collections.List;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/addproduct")
	public ResponseEntity<String> addProduct(Products products) {
		productService.addProducts(products);
		return new ResponseEntity<>("Add Sucess", HttpStatus.OK);
	}
	
	@GetMapping("/products")
	public java.util.List<Products> findAllProducts(){
		return productService.findAllProducts();
	}
	
}
