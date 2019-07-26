package com.hcl.fundtransfer.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * FundTransfer class used as request body model
 * @author amol.jadhav
 */
public class FundTransferDto {

	@NotNull
	@NotBlank
	private String loginUserName;
	
	@NotNull
	private PayeeDto payee;
	
	@NotNull
	private double amount;
	


	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public PayeeDto getPayee() {
		return payee;
	}

	public void setPayee(PayeeDto payee) {
		this.payee = payee;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
