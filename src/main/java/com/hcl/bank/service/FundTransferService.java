package com.hcl.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bank.entity.Account;
import com.hcl.bank.entity.Transaction;
import com.hcl.bank.repository.AccountRepository;
import com.hcl.bank.repository.TransactionRepository;

/**
 * @author Administrator
 *
 */
@Service
public class FundTransferService {
	

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountRepository accountRepository;
	
	/**
	 * this meathos does the transaction debit and cerdit
	 * @param fromAccount get from acc from user
	 * @param toAccount get to acc from user
	 * @param amount get amount from user
	 */
	public void fundTransfer(Long fromAccount, Long toAccount, Long amount) {
		
		
		Transaction transaction = new Transaction();
		transaction.setFromAccount(fromAccount);
		transaction.setToAccount(toAccount);
		transaction.setAmount(amount);
		
		transactionRepository.save(transaction);
		
		Account currentFromAccount = accountRepository.findByAccountNumber(fromAccount);
		
		Account currentToAccount = accountRepository.findByAccountNumber(toAccount);
		
		Account updatedAccount = new Account();
		
		Long currentBalance = (long) accountRepository.findByAccountNumber(fromAccount).getAccountBalance();
		
		if(currentBalance >= amount) {
		int updatedBalance = (int) (currentBalance - amount);
		
		updatedAccount.setAccountId(currentFromAccount.getAccountId());
		updatedAccount.setAccountBalance(updatedBalance);
		updatedAccount.setAccountNumber(fromAccount);
		updatedAccount.setUser_name(currentFromAccount.getUser_name());
		
		accountRepository.save(updatedAccount);
		}
		
		
		int updatedBalance = (int) (currentBalance + amount);
		
		updatedAccount.setAccountId(currentToAccount.getAccountId());
		updatedAccount.setAccountBalance(updatedBalance);
		updatedAccount.setAccountNumber(fromAccount);
		updatedAccount.setUser_name(currentToAccount.getUser_name());
		
		accountRepository.save(currentToAccount);
		
		
	}
	
	
	
	}
