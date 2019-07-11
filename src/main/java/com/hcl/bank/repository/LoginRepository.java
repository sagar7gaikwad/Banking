package com.hcl.bank.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bank.entity.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Integer> {

	//@Query(value="select * from user p where p.user_name = :userName", nativeQuery=true)
	 User findByUserNameAndPassword(String userName,String password);
	
}
