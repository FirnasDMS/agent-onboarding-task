package com.sec.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sec.model.MyUserDetails;
import com.sec.model.User;
import com.sec.repo.UserRepo;
@Service
public class MyuserDetailService implements UserDetailsService{

	@Autowired
	UserRepo UserRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		try {
			Optional<User> user=UserRepo.findByUserName(username);
			return user.map(MyUserDetails::new).get();
		}catch (Exception e) {
			 throw new UsernameNotFoundException(username+" "+ "Not Found!");
		}
		
	}

}
