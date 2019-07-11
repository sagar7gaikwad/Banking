package com.hcl.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.entity.Transaction;
import com.hcl.bank.service.LoginService;


@RestController
@RequestMapping("/login")
public class LoginController {

	
	@Autowired
	LoginService loginService;
	

	@PostMapping("/validate")
	public ResponseEntity<?>  validateLogin(@RequestParam String userName, @RequestParam String password){
		
		if(loginService.validateUser(userName, password))
		 {
			 return new ResponseEntity<String>("Login Successfull....",HttpStatus.OK);
			 
			 
		 }
		 else
		 {
			 return new ResponseEntity<String>("Login fail...",HttpStatus.OK);
		 }
			 
		
	}
	
	@GetMapping("/getDetails/{userName}")
	public ResponseEntity<List<Transaction>> getTransactionDetails(@PathVariable("userName") String userName) {
		 return new ResponseEntity<List<Transaction>>(loginService.getTransactionDetails(userName), HttpStatus.OK); 
	}
	
	
}
