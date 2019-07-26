package com.hcl.fundtransfer.dto;

/**
 * Payee class used as request body model
 * @author amol.jadhav
 */
public class PayeeDto {

	private String userName;
	
	private long accountNumber;
	

	public PayeeDto(String userName, long accountNumber) {
		super();
		this.userName = userName;
		this.accountNumber = accountNumber;
	}
	
	public PayeeDto() {
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
