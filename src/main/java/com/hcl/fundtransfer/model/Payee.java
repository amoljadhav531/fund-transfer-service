package com.hcl.fundtransfer.model;

/**
 * Payee class used as request body model
 * @author amol.jadhav
 */
public class Payee {

	private String userName;
	
	private long accountNumber;
	

	public Payee(String userName, long accountNumber) {
		super();
		this.userName = userName;
		this.accountNumber = accountNumber;
	}
	
	public Payee() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
}
