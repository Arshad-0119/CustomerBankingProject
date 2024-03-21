package com.arshad.CustomerAccountProject.modelClasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	
	@Id
	@GeneratedValue
	private int id;
	private AccountType accountType;
	private int balance;
	
	public int getId() {
		return id;
	}
	public Account(int id, AccountType accountType, int balance) {
		super();
		this.id = id;
		this.accountType = accountType;
		this.balance = balance;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Account() {
		super();
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	

}
