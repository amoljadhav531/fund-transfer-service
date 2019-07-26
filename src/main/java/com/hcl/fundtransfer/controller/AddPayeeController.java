package com.hcl.fundtransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.fundtransfer.dto.PayeeDto;
import com.hcl.fundtransfer.entity.Payee;
import com.hcl.fundtransfer.service.AddPayeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
public class AddPayeeController {

	@Autowired
	private AddPayeeService addPayeeService;
	
	@PostMapping
	public ResponseEntity<Payee> addPayee(@RequestBody PayeeDto payeeDto){
		return new ResponseEntity<>(addPayeeService.addPayee(payeeDto), HttpStatus.OK);
	}
	
}
