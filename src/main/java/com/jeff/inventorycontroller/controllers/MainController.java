package com.jeff.inventorycontroller.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jeff.inventorycontroller.models.Category;
import com.jeff.inventorycontroller.services.CategoryService;

@Controller
public class MainController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/") 
	public String index() {
		return "Register_login.jsp";	
	}
	
	@GetMapping("/categories")
	public String categories(Model model) {
		List<Category> categories = categoryService.allCategories();
		model.addAttribute("categories", categories);
		return "Categories.jsp";
	}
	
	@GetMapping("/addcategory")
	public String addCategory() {
		return "AddCategory.jsp";
	}
	
	@PostMapping("/addcatetgory")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
		categoryService.createCategory(category);
		return "redirect:/categories";
	}
}
