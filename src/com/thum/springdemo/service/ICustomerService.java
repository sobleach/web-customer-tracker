package com.thum.springdemo.service;

import java.util.List;

import com.thum.springdemo.entity.Customer;

public interface ICustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);

	public void deleteCustomer(int theId);
}
