package com.hcl.fundtransfer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.fundtransfer.dto.LoginUserDto;
import com.hcl.fundtransfer.dto.UserDetailsDto;
import com.hcl.fundtransfer.entity.Account;
import com.hcl.fundtransfer.entity.UserDetails;
import com.hcl.fundtransfer.service.TransectionService;
import com.hcl.fundtransfer.service.UserService;


/**
 * UserController class provide API for User registration and login
 * @author amol.jadhav
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TransectionService transectionService;
	
	/**
	 * Method used for API mapping to URL /register 
	 * @param user object have details required for user registration
	 * @return
	 */
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody UserDetailsDto user) {	
		
		if(user.getPassword().equals(user.getConfirmPassword()))			
			return new ResponseEntity<Account>(userService.registerUser(user), HttpStatus.OK);
					
	  return new ResponseEntity<String>("Your conform password is not matching with password", HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Method used for API mapping to URL /login 
	 * @param user object have login user-name and password
	 * @return
	 */
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginUserDto userDto) {
		try {
			
		if (userService.userExist(userDto.getUsername()))
			return new ResponseEntity<>("No Account Found, Please Register", HttpStatus.NO_CONTENT);
		
		if (userService.checkLogin(userDto.getUsername(), userDto.getPassword()))
			return new ResponseEntity<>(transectionService.getTransectionHistory(userDto.getUsername()),HttpStatus.OK);
		 else 
			return new ResponseEntity<>("Username & Password is Incorrect", HttpStatus.UNAUTHORIZED);
			
		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
