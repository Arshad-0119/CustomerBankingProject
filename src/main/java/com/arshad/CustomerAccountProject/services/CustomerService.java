package com.arshad.CustomerAccountProject.services;

import java.util.List;

import com.arshad.CustomerAccountProject.modelClasses.Customer;

public interface CustomerService {
	
	public Customer saveCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public Boolean deleteCustomer(int id);
	
	public List<Customer> getAllCustomers();

}
