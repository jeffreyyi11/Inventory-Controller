package com.jeff.inventorycontroller.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/") 
	public String index() {
		return "Register_login.jsp";	
	}
	
	@GetMapping("/addproducts")
	public String addProduct() {
		return "AddProduct.jsp";
	}
}
