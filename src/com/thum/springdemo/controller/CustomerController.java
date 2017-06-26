package com.thum.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thum.springdemo.dao.ICustomerDAO;
import com.thum.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer dao
	@Autowired
	private ICustomerDAO iCustomerDAO;

	@GetMapping("/list")
	public String listCustomer(Model theModel) {

		// get customers from the dao
		List<Customer> theCustomers = iCustomerDAO.getCustomers();

		// add the custoemrs to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}
}
