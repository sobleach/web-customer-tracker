package com.thum.springdemo.dao;

import java.util.List;

import com.thum.springdemo.entity.Customer;

public interface ICustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);

}
