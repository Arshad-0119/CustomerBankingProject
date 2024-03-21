package com.arshad.CustomerAccountProject.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.arshad.CustomerAccountProject.DAO.CustomerRepository;
import com.arshad.CustomerAccountProject.modelClasses.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository repo;

	@Override
	public Customer saveCustomer(Customer customer) {
		return repo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer customer1 = getCustomer(customer.getCustomerId());
		customer1.setEmail(customer.getEmail());
		customer1.setFirstName(customer.getFirstName());
		customer1.setSecondName(customer.getSecondName());
		customer1.setAccounts(customer1.getAccounts());
		return repo.save(customer1); 
	}

	@Override
	public Customer getCustomer(int id) {
		Customer customer1 = repo.findById(id).orElse(null);
		if(ObjectUtils.isEmpty(customer1)) 
			throw new EntityNotFoundException("Customer not found with the ID: "+id);
		return customer1;
	}

	@Override
	public Boolean deleteCustomer(int id) {
		getCustomer(id);
		repo.deleteById(id);
		return true;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}
	
}
