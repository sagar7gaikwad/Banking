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
	
	
	/** this method takes username and password from user for validation
	 * after validation successful returns flag as true and false.
	 * @param userName takes argument as username from user
	 * @param password takes argument as password from user
	 * @return
	 */
	public boolean validateUser(String userName, String password) {
		
		User testUser = loginRepository.findByUserNameAndPassword(userName,password);
		
		System.out.println(testUser);
		
		if(testUser.getUserName().equals(userName) && testUser.getPassword().equals(password)) {
			
			return true;
		}
		
		else
			return false;
	}


	
	/**
	 * This method return the transaction if login is successful.
	 * @param userName take username from the logged user name to get the account number 
	 * which is used to get the transaction details
	 * @return it returns the list of transactions.
	 */
	public List<Transaction> getTransactionDetails(String userName) {
		
		Account acc = accountRepository.findByUserName(userName);
		List<Transaction> transaction = transactionRepository.findByFromAccount(acc.getAccountNumber());
		return  transaction;
	}

	
		
}
