package com.hcl.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.entity.User;
import com.hcl.bank.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;
	
	/**
	 * This method is used to validate all the fields and register user
	 * and after user registered random account number is generated, and saved in database
	 * @param user takes the all parameter from user and bind to entity user
	 * @return string message displayed saying that User Registered and account number generated
	 */
	@PostMapping("/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody User user){
		if(user.getUserName() != null &&
				user.getUserName() .equals("")  && user.getPassword() .equals("") &&
				user.getPassword() != null && user.getUserContactNo()!= null &&
				user.getUserEmail() .equals("") && user.getUserGender() != null && user.getUserDOB() != null) {
			
		registrationService.registerUser(user);
		return new ResponseEntity<String>("User Registered and account number generated",HttpStatus.OK);
		}
		
		else {
		return new ResponseEntity<String>("Invalid",HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
