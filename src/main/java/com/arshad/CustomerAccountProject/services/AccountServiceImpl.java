package com.arshad.CustomerAccountProject.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshad.CustomerAccountProject.DAO.AccountRepository;
import com.arshad.CustomerAccountProject.modelClasses.Account;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository repository;

	@Override
	public Account createAccount(Account account) {
		return repository.save(account);
	}

	@Override
	public List<Account> getAllAccounts() {
		return repository.findAll();
	}

	@Override
	public Account getAccountById(int id) {
		Optional<Account> optional = repository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Account not found with ID: " + id));
	}

	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);;
	}

}
