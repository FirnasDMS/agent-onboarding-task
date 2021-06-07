package com.sec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sec.model.Customers;
import com.sec.repo.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo customerRepo;

	public void addCustomers(Customers customers) {
		// TODO Auto-generated method stub
		customerRepo.save(customers);
	}

	public List<Customers> findAllByUserId(int userId) {
		// TODO Auto-generated method stub
		return customerRepo.findAllByUserId(userId);
	}

	public List<Customers> findAllByUserName(String name) {
		// TODO Auto-generated method stub
		return customerRepo.findCustomersByAgentName(name);
	}

	public Customers getOne(int id) {
		// TODO Auto-generated method stub
		return customerRepo.getById(id);
	}

	public void update(Customers customers) {
		
		customerRepo.save(customers);
	}

}
