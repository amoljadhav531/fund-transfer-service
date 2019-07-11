package com.hcl.fundtransfer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Account class represent the account table in database
 * @author amol.jadhav
 */
@Entity
public class Account {
	
	@Id
	@Column(name="account_number")
	private long accountNumber;
	
	@Column(name="account_holder")
	private String accountHolder;
	
	private double balance;

	private String username;
	

	public Account() {
		super();
	}
	
	public Account(long accountNumber, String accountHolder, double balance, String username) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.username = username;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
