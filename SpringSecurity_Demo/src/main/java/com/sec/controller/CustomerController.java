package com.sec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sec.model.Customers;
import com.sec.model.Products;
import com.sec.model.User;
import com.sec.service.CustomerService;
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	
	@PostMapping("/add/{userId}/{productId}{}")
	public ResponseEntity<String> addCustomers(@PathVariable int userId,@PathVariable int productId,Customers customers) {
		
		customers.setUser(new User(userId));
		customers.setProducts(new Products(productId));
		customerService.addCustomers(customers);
		return new ResponseEntity<>("Sucess", HttpStatus.OK);
	}
	
	@GetMapping("/find/{userId}")
	public List<Customers>findAllCustomerByUserId(@PathVariable int userId){
		
		return customerService.findAllByUserId(userId);
	}
	
	@GetMapping("/findbyname/{name}")
	public List<Customers>findAllCustomerByUserName(@PathVariable String name){
		
		return customerService.findAllByUserName(name);
	}
	
	@PatchMapping("/assign/{id}/{productsId}")
	public ResponseEntity<String> updateCustomerIterm(@PathVariable int id,@PathVariable int productsId){
		
		try {
			Customers customers=customerService.getOne(id);
			customers.setProducts(new Products(productsId));
			customerService.update(customers);
			 return new ResponseEntity<>(" Sucess", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
		}
		
	}
}
