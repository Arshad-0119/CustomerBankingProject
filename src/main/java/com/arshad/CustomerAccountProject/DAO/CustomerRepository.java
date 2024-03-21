package com.arshad.CustomerAccountProject.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arshad.CustomerAccountProject.modelClasses.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
