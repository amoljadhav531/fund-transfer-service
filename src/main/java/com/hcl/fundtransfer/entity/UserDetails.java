package com.hcl.fundtransfer.entity;

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
@Entity
@Data
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@NotNull
	@NotBlank
	@Length(min = 5, max = 15)
	private String username;
	
	@NotNull
	@NotBlank
	private String password;
	
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
	private String dob;
	
	@OneToOne(mappedBy = "userDetails")
	@JsonIgnore
	private Account account;
}
