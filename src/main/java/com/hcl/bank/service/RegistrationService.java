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
	
	
