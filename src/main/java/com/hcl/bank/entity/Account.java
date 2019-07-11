package com.hcl.bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="account")
public class Account {

	
	@Id
	@Column(name = "account_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId;
	
	@Column(name = "account_number")
	private Long accountNumber;
	
	@Column(name = "account_balance")
	private int accountBalance;

	@Column(name = "user_name")
	private String userName;

	
	
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int i) {
		this.accountBalance = i;
	}

	public String getUser_name() {
		return userName;
	}

	public void setUser_name(String userName) {
		this.userName = userName;
	}
	
	
	
}
