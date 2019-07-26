package com.hcl.fundtransfer.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * LoginUser class used as request body model
 * @author amol.jadhav
 */
public class LoginUserDto {

	@NotNull
	@NotBlank
	private String username;
	
	@NotNull
	@NotBlank
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}