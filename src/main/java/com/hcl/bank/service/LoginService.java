package com.hcl.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bank.entity.Account;
import com.hcl.bank.entity.Transaction;
import com.hcl.bank.entity.User;
import com.hcl.bank.repository.AccountRepository;
import com.hcl.bank.repository.LoginRepository;
import com.hcl.bank.repository.TransactionRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	public boolean validateUser(String userName, String password) {
		
		User testUser = loginRepository.findByUserNameAndPassword(userName,password);
		
		System.out.println(testUser);
		
		if(testUser.getUserName().equals(userName) && testUser.getPassword().equals(password)) {
			
			return true;
		}
		
		else
			return false;
	}


	public List<Transaction> getTransactionDetails(String userName) {
		
		Account acc = accountRepository.findByUserName(userName);
		List<Transaction> transaction = transactionRepository.findByFromAccount(acc.getAccountNumber());
		return  transaction;
	}

	
		
}
