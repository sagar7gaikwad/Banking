package com.hcl.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.bank.service.FundTransferService;

@Controller
public class FundTransferController {
	
	@Autowired
	FundTransferService fundtransferService;
	
	

	@PostMapping("/fund")
	public ResponseEntity<String>  validateLogin(@RequestParam Long fromAccount, @RequestParam Long toAccount, @RequestParam Long amount){
		fundtransferService.fundTransfer(fromAccount,toAccount,amount);
		return new ResponseEntity<String>("Transaction Successfull....",HttpStatus.OK);
	}

}
