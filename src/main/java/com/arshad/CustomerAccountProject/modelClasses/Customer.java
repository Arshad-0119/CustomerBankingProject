package com.arshad.CustomerAccountProject.modelClasses;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	private String firstName;
	private String secondName;
	private String email;
	
	@OneToMany
	@JoinColumn(name="accounts")
	private List<Account> accounts=new ArrayList<>();

	public Customer() {
		
	}
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", secondName=" + secondName + ", email=" + email + ", accounts="
				+ accounts + "]";
	}

	public Customer(String firstName, String secondName, String email, List<Account> accounts) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
		this.accounts = accounts;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int cutomerId) {
		this.customerId = cutomerId;
	}


}
