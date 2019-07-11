package com.hcl.bank.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.hcl.bank.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
}
