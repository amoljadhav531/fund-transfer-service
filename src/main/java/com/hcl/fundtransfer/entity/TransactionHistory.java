package com.hcl.fundtransfer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * TransactionDetails class represent the transaction_details table in database
 * @author amol.jadhav
 */
@Entity
@Data
public class TransactionHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	
	private String date;
	
	private String transactionType;

	private double amount;
	
	private double availableBalance;
	
	private String transactionDescription;
	
	@ManyToOne
	@JoinColumn(name = "account_number")
	@JsonIgnore
	private Account account;
	
}
