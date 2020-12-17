package com.jeff.inventorycontroller.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeff.inventorycontroller.models.Category;
import com.jeff.inventorycontroller.models.User;
import com.jeff.inventorycontroller.services.CategoryService;
import com.jeff.inventorycontroller.services.UserService;
import com.jeff.inventorycontroller.validator.UserValidator;

@Controller
public class MainController {
	@Autowired
	private CategoryService categoryService;
	private UserService userService;
	private UserValidator userValidator;
	
	@GetMapping("/") 
	public String index(@ModelAttribute("user") User user) {
		return "Register_login.jsp";	
	}
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "Register_login.jsp";
		} else {
			System.out.println("registering user");
			User u = userService.registerUser(user);
			session.setAttribute("userId", u.getId());
			return "redirect:/categories";
		}
	}
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user,@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		boolean isAuthentic = userService.authenticateUser(email, password);
		if (isAuthentic) {
			System.out.println("logging in");
			User u = userService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/categories";
		} else {
			model.addAttribute("error", "Invalid Credentials. Try Again");
			return "Register_login.jsp";
		}
	}
	
	@GetMapping("/categories")
	public String categories(Model model) {
		List<Category> categories = categoryService.allCategories();
		System.out.println(categories.toString());
		model.addAttribute("categories", categories);
		return "Categories.jsp";
	}
	
	@GetMapping("/addcategory")
	public String addCategory(@ModelAttribute("category") Category category) {
		return "AddCategory.jsp";
	}
	
	@PostMapping("/addcategory")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "AddCategory.jsp";
		} else {
			categoryService.createCategory(category);
			return "redirect:/categories";
		}
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		categoryService.deleteCategory(id);
		return "redirect:/categories";
	}
}
