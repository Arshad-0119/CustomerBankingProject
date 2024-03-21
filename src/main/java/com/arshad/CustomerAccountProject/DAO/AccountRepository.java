package com.arshad.CustomerAccountProject.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arshad.CustomerAccountProject.modelClasses.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
