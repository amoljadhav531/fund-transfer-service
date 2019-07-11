package com.hcl.fundtransfer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * User class represent the user table in database
 * @author amol.jadhav
 */
@Entity
public class User {

	@Id
	@NotNull
	@NotBlank
	@Length(min = 5, max = 15)
	private String username;
	
	@NotNull
	@NotBlank
	private String password;
	
	@Column(name="conform_password")
	@NotNull
	@NotBlank
	private String conformPassword;
	
	@Column(name="full_name")
	@NotNull
	@NotBlank
	private String fullName;
	
	@NotNull
	@Column(name="mobile_number")
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

	public String getConformPassword() {
		return conformPassword;
	}

	public void setConformPassword(String conformPassword) {
		this.conformPassword = conformPassword;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
