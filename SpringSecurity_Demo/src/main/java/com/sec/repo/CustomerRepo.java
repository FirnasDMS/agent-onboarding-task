package com.sec.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.sec.model.Customers;

public interface CustomerRepo extends JpaRepository<Customers, Integer>{

	List<Customers> findAllByUserId(int userId);

	 @Query (value = "SELECT  * FROM customers  INNER JOIN USER ON  user.id= Customers.user_id WHERE user.user_name=?1", nativeQuery = true)
	    List<Customers> findCustomersByAgentName(String name);


}
