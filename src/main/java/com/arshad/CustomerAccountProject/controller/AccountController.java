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

import com.arshad.CustomerAccountProject.modelClasses.Account;
import com.arshad.CustomerAccountProject.services.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@PostMapping("/account")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account savedAccount = service.createAccount(account);
		return new ResponseEntity<>(savedAccount,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAllAccounts(){
		List<Account> list = service.getAllAccounts();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/account/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable int id ) {
		Account account = service.getAccountById(id);
		return new ResponseEntity<>(account,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/account/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable int id) {
		service.deleteAccount(id);
		return new ResponseEntity<>("Deleted the account with ID:"+id,HttpStatus.OK);
		
	}

}
