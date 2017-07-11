package com.thum.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thum.springdemo.dao.ICustomerDAO;
import com.thum.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {

	// need to inject customer dao
	@Autowired
	private ICustomerDAO iCustomerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return iCustomerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		iCustomerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomers(int theId) {
		return iCustomerDAO.getCustomers(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		iCustomerDAO.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		return iCustomerDAO.searchCustomers(theSearchName);
	}

}
