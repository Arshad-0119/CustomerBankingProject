package com.arshad.CustomerAccountProject.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arshad.CustomerAccountProject.DTO.TransferFunds;
import com.arshad.CustomerAccountProject.modelClasses.Account;
import com.arshad.CustomerAccountProject.modelClasses.Customer;
import com.arshad.CustomerAccountProject.services.AccountServiceImpl;
import com.arshad.CustomerAccountProject.services.CustomerServiceImpl;

@RestController
public class TransactionController {
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	@Autowired
	private AccountServiceImpl accountService;
	
	@PostMapping("/customer/{id}/account")
	public ResponseEntity<Customer> createAccountToCustomer(@PathVariable int id, @RequestBody Account account){
		Customer customer = customerService.getCustomer(id);
		List<Account> accounts = customer.getAccounts();
		account = accountService.createAccount(account);
		accounts.add(account);
		customer.setAccounts(accounts);
		customer = customerService.saveCustomer(customer); 
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@PostMapping("/customer/{id}")
	public ResponseEntity<Customer> makeTransaction(@RequestBody TransferFunds transferFunds, @PathVariable int id){
		Customer customer = customerService.getCustomer(id);
		List<Account> accounts = customer.getAccounts();
		List<Integer> accountList = accounts.stream().map(Account::getId).collect(Collectors.toList());
		int sourceAccountId = transferFunds.getSourceAccountId();
		int destinationAccountId = transferFunds.getDestinationAccountId();
		if(!accountList.contains(sourceAccountId)) {
			throw new EntityNotFoundException("Source Account number is invalid");
		}
		if(!accountList.contains(destinationAccountId)) {
			throw new EntityNotFoundException("Destination Account number is invalid");
		}
		int amount = transferFunds.getAmount();
		if(amount<=0)
			throw new EntityNotFoundException("Amount should be positive");
		Account sourceAccount = accountService.getAccountById(sourceAccountId);
		if(sourceAccount.getBalance()<0||sourceAccount.getBalance()<amount)
			throw new EntityNotFoundException("Insufficient Balance");
		Account destinationAccount = accountService.getAccountById(destinationAccountId);
		sourceAccount.setBalance(sourceAccount.getBalance()-amount);
		destinationAccount.setBalance(destinationAccount.getBalance()+amount);
		return new ResponseEntity<>(customerService.saveCustomer(customer),HttpStatus.OK);
	}

}
