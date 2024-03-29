package com.hcl.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.bank.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	@Query(value="select * from account where user_name =?1" , nativeQuery = true)
     Account findByUserName(String userName);

	@Query(value="select * from transaction where from_account =?1" , nativeQuery = true)	
	Account  findByAccountNumber(Long accountNumber);
	
	
}
