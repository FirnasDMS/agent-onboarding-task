package com.sec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sec.model.MyUserDetails;
import com.sec.model.User;
import com.sec.service.UserService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private  UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/add")
    public ResponseEntity<String> AddUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
    	userService.addUser(user);
		return new ResponseEntity<>("Add Sucess", HttpStatus.OK);
	
    }
	
	@GetMapping("/users")
	public List<User> findAllUsers(){
		System.out.println("hello");
		return userService.findAllUsers();
	}
	
	@PatchMapping("/status/{id}/{active}")
	public ResponseEntity<String> updateUserStatus(@PathVariable int id,boolean active) {
		User user=userService.getOneById(id);
		user.setAtive(active);
		userService.update(user);
		return new ResponseEntity<>("Sucess", HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateUser(@PathVariable int id, User user) {
		User user2=userService.getOneById(id);
		user2.setPassword(user.getPassword());
		user2.setRoles(user.getRoles());
		user2.setUserName(user.getUserName());
		userService.update(user2);
		return new ResponseEntity<>("Sucess", HttpStatus.OK);
	}
	@PatchMapping("/password/{password}")
	public ResponseEntity<String> changePassword(@PathVariable String password) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MyUserDetails omUser = (MyUserDetails)auth.getPrincipal();
		int userId = omUser.getUserId();
		
		User user=userService.getOneById(userId);
		user.setPassword(password);
		userService.update(user);
		return new ResponseEntity<>("Sucess", HttpStatus.OK);
	}
}
