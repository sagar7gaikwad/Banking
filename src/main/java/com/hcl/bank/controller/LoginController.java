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
	

	/**
	 * This method is used to validate the username and password send by user
	 * @param userName get username from user
	 * @param password get password from user
	 * @return string weather login successful or not
	 */
	@PostMapping("/validate")
	public ResponseEntity<String>  validateLogin(@RequestParam String userName, @RequestParam String password){
		
		if(loginService.validateUser(userName, password))
		 {
			 return new ResponseEntity<String>("Login Successfull....",HttpStatus.OK);
			 
			 
		 }
		 else
		 {
			 return new ResponseEntity<String>("Login fail...",HttpStatus.OK);
		 }
			 
		
	}
	
	
	/**
	 * This method is used to return the transaction based on username from transaction table
	 * after login successful
	 * @return list of transactions based on account number
	 */
	@GetMapping("/getDetails/{userName}")
	public ResponseEntity<List<Transaction>> getTransactionDetails(@PathVariable("userName") String userName) {
		 return new ResponseEntity<List<Transaction>>(loginService.getTransactionDetails(userName), HttpStatus.OK); 
	}
	
	
}
