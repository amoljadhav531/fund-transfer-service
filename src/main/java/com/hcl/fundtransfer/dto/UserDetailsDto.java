package com.hcl.fundtransfer.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * User class represent the user table in database
 * @author amol.jadhav
 */
@Data
public class UserDetailsDto {
	
	private String username;
	
	private String password;
	
	private String confirmPassword;
	
	@NotNull
	@NotBlank
	private String fullName;
	
	@NotNull
	private long mobileNumber;
	
	@NotNull
	@NotBlank
	private String email;
	
	@NotNull
	@NotBlank
	private String gender;
	
	@NotNull
	@NotBlank
	private LocalDate dob;
	
}
