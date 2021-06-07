package com.sec.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.model.Products;

public interface ProductRepo extends JpaRepository<Products, Integer>{

}
