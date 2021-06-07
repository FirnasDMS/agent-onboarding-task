package com.sec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sec.model.Item;
import com.sec.repo.ItemRepo;

@Service
public class ItemService {

	@Autowired
	private ItemRepo itemRepo;

	public void addItem(Item item) {
		itemRepo.save(item);
		
	}
}
