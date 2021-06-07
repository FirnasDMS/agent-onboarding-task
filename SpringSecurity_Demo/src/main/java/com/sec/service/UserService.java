package com.sec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sec.model.User;
import com.sec.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	public void addUser(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	public User getOneById(int id) {
		// TODO Auto-generated method stub
		return userRepo.getById(id);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
		
	}
	
	
}
