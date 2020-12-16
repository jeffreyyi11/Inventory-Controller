package com.jeff.inventorycontroller.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.inventorycontroller.models.Category;
import com.jeff.inventorycontroller.repos.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	public Category createCategory(Category c) {
		return categoryRepo.save(c);
	}
	
	public Category updateCategory(Category c) {
		return categoryRepo.save(c);
	}
	
	public void deleteCategory(Long id) {
		categoryRepo.deleteById(id);
	}
}
