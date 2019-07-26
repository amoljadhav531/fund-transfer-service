package com.hcl.fundtransfer.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
