package com.hcl.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.bank.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	@Query(value="select * from transaction where from_account=?1",nativeQuery = true)
	List<Transaction> findByFromAccount(Long accountNumber);

		

}
