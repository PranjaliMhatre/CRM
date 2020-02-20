package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model){
		
		// get the customers from the CustomerDAO
		List<Customer> customersList = customerService.getCustomers();
		
		// set retrieved customers to the model
		model.addAttribute("customers",customersList);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
		
	}
	
	@GetMapping("/showUpdateForm")
	public String updateCustomer(@RequestParam("customerId")int customerId, Model theModel){
		// get the customer from the database
		Customer customer = customerService.getCustomer(customerId);
		
		//set customer as the model attribute to prepopulate the form
		theModel.addAttribute("customer", customer);
		
		// send over to our form		
		return "customer-form";
	}
}
