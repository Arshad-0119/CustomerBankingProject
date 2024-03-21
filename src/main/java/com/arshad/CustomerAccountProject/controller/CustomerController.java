package com.arshad.CustomerAccountProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arshad.CustomerAccountProject.modelClasses.Customer;
import com.arshad.CustomerAccountProject.services.CustomerServiceImpl;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceImpl service;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		Customer savedCustomer = service.saveCustomer(customer);
		return new ResponseEntity<>(savedCustomer,HttpStatus.OK);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id){
		Customer repoCustomer = service.getCustomer(id);
		return new ResponseEntity<>(repoCustomer,HttpStatus.OK);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> listOfCustomer = service.getAllCustomers();
		return new ResponseEntity<>(listOfCustomer,HttpStatus.OK);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id){
		service.deleteCustomer(id);
		return new ResponseEntity<>("Deleted",HttpStatus.OK);
	}
	
	@PostMapping("/customer/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		Customer updatedCustomer = service.updateCustomer(customer);
		return new ResponseEntity<>(updatedCustomer,HttpStatus.OK);
	}
	
}
