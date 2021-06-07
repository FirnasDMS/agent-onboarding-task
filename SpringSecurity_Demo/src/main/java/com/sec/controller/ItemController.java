package com.sec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sec.model.Item;
import com.sec.model.Products;
import com.sec.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@PostMapping("/add/{productsId}")
	public ResponseEntity<String> addItem(@PathVariable int productsId, Item item){
		
	
			item.setProducts(new Products(productsId));
			itemService.addItem(item);
			return new ResponseEntity<>("Add Sucess", HttpStatus.OK);
		
		
	}
}
