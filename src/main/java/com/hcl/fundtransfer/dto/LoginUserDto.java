package com.hcl.fundtransfer.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;


/**
 * LoginUser class used as request body model
 * @author amol.jadhav
 */
@Data
public class LoginUserDto {

	@NotNull
	@NotBlank
	private String username;
	
	@NotNull
	@NotBlank
	private String password;
}