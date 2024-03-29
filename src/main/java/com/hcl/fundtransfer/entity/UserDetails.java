package com.hcl.fundtransfer.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
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
	private String mobileNumber;
	
	@NotNull
	@NotBlank
	private String email;
	
	@NotNull
	@NotBlank
	private String gender;
	
	@NotNull
	private LocalDate dob;
	
	@OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL)
	@JsonIgnore
	private Account account;
	
}
