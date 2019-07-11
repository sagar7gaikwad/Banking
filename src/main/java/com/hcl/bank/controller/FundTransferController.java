package com.hcl.bank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FundTransferController {

	@PostMapping("/fund")
	public ResponseEntity<?>  validateLogin(@RequestParam Long fromAccount, @RequestParam Long toAccount, @RequestParam Double amount){
		
		return new ResponseEntity<String>("Transaction Successfull....",HttpStatus.OK);
	}

}
