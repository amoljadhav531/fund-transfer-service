package com.hcl.fundtransfer.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Account class represent the account table in database
 * 
 * @author amol.jadhav
 */
@Entity
@Data
public class Account {

	@Id
	@Column(name = "account_number")
	private long accountNumber;

	@Column(name = "account_holder")
	private String accountHolder;

	private double balance;

	private String ifscCode;

	@OneToMany(mappedBy = "account")
	private List<TransactionHistory> transactionHistories;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private UserDetails userDetails;

}
