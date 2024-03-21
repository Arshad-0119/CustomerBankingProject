package com.arshad.CustomerAccountProject.services;

import java.util.List;

import com.arshad.CustomerAccountProject.modelClasses.Account;

public interface AccountService {

	public Account createAccount(Account account);
	
	public List<Account> getAllAccounts();
	
	public Account getAccountById(int id);
	
	public void deleteAccount(int id);
}
