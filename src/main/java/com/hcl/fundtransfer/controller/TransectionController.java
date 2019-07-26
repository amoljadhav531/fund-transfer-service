package com.hcl.fundtransfer.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.fundtransfer.dto.FundTransferDto;
import com.hcl.fundtransfer.service.TransectionService;

/**
 * TransectionController class provide API for banking transection management
 * 
 * @author amol.jadhav
 */
@RestController
@RequestMapping("/transection")
@Validated
public class TransectionController {

	@Autowired
	private TransectionService transectionService;

	
	/**
	 * Method used for API mapping to URL /payees/{userName}
	 * @param userName login user name
	 * @return List<Payee> List of payee objects
	 */
	@GetMapping("/payee/{userId}")
	public  ResponseEntity<Object> getAllPayees(@PathVariable Long userId){
		return new ResponseEntity<>(transectionService.getAllPayees(userId),HttpStatus.OK);
	}
	
	
	/**
	 * Method used for API mapping to URL /fundtransfer
	 * 
	 * @param fundTransfer Object having details required to transfer a fund
	 * @return
	 */
	@PostMapping("/fundtransfer")
	public ResponseEntity<?> fundTransfer(@Valid @RequestBody FundTransferDto fundTransfer) {
		try {
			transectionService.fundTransfer(fundTransfer);
			return new ResponseEntity<>("Transection Successful", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
