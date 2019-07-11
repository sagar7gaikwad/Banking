package com.hcl.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bank.entity.Account;
import com.hcl.bank.entity.User;
import com.hcl.bank.repository.AccountRepository;
import com.hcl.bank.repository.UserRepository;

@Service
public class RegistrationService {
	
	
	@Autowired
	UserRepository registrationRepository;
	
	@Autowired
	AccountRepository accountRepository;

	
	/**
	 * this method takes user from controller and save to database and creates random account number, add 10k balance and
	 * username for further reference if required to use join query 
	 * add it into the account db table.
	 * @param user takes user object from user
	 */
	public void registerUser(User user) {
		
			//insert data into user table
			registrationRepository.save(user);
			
			long number = (long) Math.abs(Math.random() * 1000000000);
			String username = user.getUserName();
			
			Account account = new Account();
			account.setAccountNumber(number);
			account.setAccountBalance(10000);
			account.setUser_name(username);
			
			//Saving Account Details
			accountRepository.save(account);
			
	}
			
					
		
	}
	
	
