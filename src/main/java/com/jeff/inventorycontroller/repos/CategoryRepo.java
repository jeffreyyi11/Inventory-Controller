package com.jeff.inventorycontroller.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jeff.inventorycontroller.models.Category;

@Repository
public interface CategoryRepo extends CrudRepository <Category, Long> {
	List<Category> findAll();
	String findByName(String name);
	String findByDescription(String description);
}
