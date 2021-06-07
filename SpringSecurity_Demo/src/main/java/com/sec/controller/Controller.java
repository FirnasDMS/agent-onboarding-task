package com.sec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sec.model.User;
import com.sec.service.UserService;

@RestController
public class Controller {
	@Autowired
	private UserService UserService;
	
	@GetMapping("/")
	public String home() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean hasUserRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_USER"));
		
		if(hasUserRole==true) {
			return "Welcome to ROLE USER";
		}
		return "Welcome to ROLE ADMIN";
	}
	


}
