package com.sec.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.model.Item;

public interface ItemRepo  extends JpaRepository<Item, Integer>{

}
