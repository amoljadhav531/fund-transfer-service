package com.hcl.fundtransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.fundtransfer.dto.PayeeDto;
import com.hcl.fundtransfer.service.PayeeService;

@RestController
@RequestMapping("/fundtransfer")
public class PayeeController {

	@Autowired
	private PayeeService payeeService;

	@DeleteMapping("/payee")
	public ResponseEntity<?> deletePayee(@RequestBody PayeeDto payeeDto) {

		return new ResponseEntity<Object>(payeeService.deletePayee(payeeDto), HttpStatus.OK);
	}

}
