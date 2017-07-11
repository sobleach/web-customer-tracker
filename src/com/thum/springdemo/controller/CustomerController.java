package com.thum.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thum.springdemo.entity.Customer;
import com.thum.springdemo.service.CustomerServiceImpl;
import com.thum.springdemo.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject our customer service
	@Autowired
	private ICustomerService iCustomerService;

	@GetMapping("/list")
	public String listCustomer(Model theModel) {

		// get customers from the service
		List<Customer> theCustomers = iCustomerService.getCustomers();

		// add the custoemrs to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		// save the customer using our service
		iCustomerService.saveCustomer(theCustomer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		// get the customer from the database
		Customer theCustomer = iCustomerService.getCustomers(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);

		// send over to our form
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {

		// delete the customer
		iCustomerService.deleteCustomer(theId);

		return "redirect:/customer/list";
	}

	@PostMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName") String theSearchName, Model theModel) {

		// search customers from the service
		List<Customer> theCustomers = iCustomerService.searchCustomers(theSearchName);

		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}
}
