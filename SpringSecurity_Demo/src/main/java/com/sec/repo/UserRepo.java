package com.sec.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	Optional<User> findByUserName(String userName);

}
